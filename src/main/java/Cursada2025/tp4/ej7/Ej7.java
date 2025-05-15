package Cursada2025.tp4.ej7;

import Cursada2025.tp4.GrafoDirigidoMap;
import Cursada2025.tp4.GrafoNoDirigido;
import Cursada2025.tp4.ej6.Ejercicio6;

import java.util.ArrayList;
import java.util.Iterator;

public class Ej7 {
    /**
     * Ejercicio 7
     * Dado un grafo no orientado que modela las rutas de la provincia de Buenos Aires, devolver
     * todos los caminos alternativos que se pueden tomar para ir desde la ciudad de Buenos Aires
     * a la ciudad de Tandil, considerando que en el tramo Las Flores-Rauch está cortado al tránsito.
     */
    ArrayList<Integer> visitados;
    ArrayList<ArrayList<Integer>> solucion = new ArrayList<>();

    public Ej7(ArrayList<Integer> visitados, ArrayList<ArrayList<Integer>> solucion) {
        this.visitados = visitados;
        this.solucion = solucion;
    }

    public Ej7() {
        visitados = new ArrayList<>();
        solucion = new ArrayList<>();
    }

    public ArrayList<Integer> getVisitados() {
        return new ArrayList<>(visitados);
    }

    public void setVisitados(ArrayList<Integer> visitados) {
        this.visitados = visitados;
    }

    public ArrayList<ArrayList<Integer>> getSolucion() {
        return new ArrayList<>(solucion);
    }

    public void setSolucion(ArrayList<ArrayList<Integer>> solucion) {
        this.solucion = solucion;
    }

    public void encontrarDestinoConTransito(GrafoNoDirigido gr, int origen, int destino){
        visitados.clear();
        solucion.clear();
        visitados.add(origen);

        Iterator<Integer> ady = gr.obtenerAdyacentes(origen);
        while (ady.hasNext()){
            Integer next = ady.next();
            recorrerAlDestino(gr, next, destino);
        }
    }

    private void recorrerAlDestino(GrafoNoDirigido gr, int actual, int destino) {
        // si es solucion..
        if (visitados.contains(actual)) {
            return;
        }

        visitados.add(actual);

        if (actual == destino){
            solucion.add(new ArrayList<>(visitados)); // verificar q sea correcto
            visitados.remove((Integer) actual);
            return;
        }

        Iterator<Integer> it = gr.obtenerAdyacentes(actual);
        while (it.hasNext()) {
            int siguiente = it.next();

            if ((actual == 2 && siguiente == 3) || (actual == 3 && siguiente == 2)) {
                return;
            }

            recorrerAlDestino(gr, siguiente, destino);
        }

        visitados.remove((Integer) actual);
    }

    public static void main(String[] args) {
        GrafoNoDirigido<Integer> g = new GrafoNoDirigido<>();

        for (int i = 1; i <= 9; i++) g.agregarVertice(i);

        g.agregarArco(1, 2, 0);
        g.agregarArco(1, 5, 0);
        g.agregarArco(2, 3, 0); // Las Flores - Rauch
        g.agregarArco(3, 4, 0);
        g.agregarArco(4, 8, 0);
        g.agregarArco(8, 9, 0);
        g.agregarArco(9, 5, 0);
        g.agregarArco(5, 6, 0);
        g.agregarArco(6, 7, 0);
        g.agregarArco(7, 3, 0);
        g.agregarArco(5, 4, 0);
        g.agregarArco(1, 4, 0);
        g.agregarArco(2, 5, 0);

        Ej7 ej = new Ej7();
        ej.encontrarDestinoConTransito(g, 1, 9); // Ejemplo: de Buenos Aires (1) a Tandil (9)

        System.out.println("Caminos encontrados:");
        for (ArrayList<Integer> camino : ej.getSolucion()) {
            System.out.println(camino);
        }
    }
}
