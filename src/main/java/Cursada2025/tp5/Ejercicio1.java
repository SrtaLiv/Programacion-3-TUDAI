package Cursada2025.tp5;

import Cursada2025.tp4.GrafoDirigidoMap;

import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio1 {
    ArrayList<Integer> visitados;
    ArrayList<Integer> solucion;

    public Ejercicio1() {
        this.visitados = new ArrayList<>();
        this.solucion = new ArrayList<>();
    }

    public ArrayList<Integer> getVisitados() {
        return new ArrayList<>(visitados);
    }

    public void setVisitados(ArrayList<Integer> visitados) {
        this.visitados = visitados;
    }

    public ArrayList<Integer> getSolucion() {
        return new ArrayList<>(solucion);
    }

    public void setSolucion(ArrayList<Integer> solucion) {
        this.solucion = solucion;
    }

    public void buscarCaminoMasLargo(GrafoDirigidoMap<Integer> gr, int origen, int salida){
        visitados.add(origen);

        Iterator<Integer> it = gr.obtenerAdyacentes(origen);
        while (it.hasNext()){
            buscarCaminos(gr, it.next(), salida); // 4
        }
    }

    private void buscarCaminos(GrafoDirigidoMap<Integer> gr, int actual, int destino){
        // Condicion de corte
        if (actual == destino){
            visitados.add(actual);

            if (visitados.size() > solucion.size()){
                solucion = new ArrayList<>(visitados);
            }
        }
        else {
            Iterator<Integer> it = gr.obtenerAdyacentes(actual);
            Integer num = it.next();
            if (!visitados.contains(num)){
                visitados.add(actual);

                while (it.hasNext()){
                    buscarCaminos(gr, it.next(), destino);
                }

                visitados.remove((Integer) actual);
            }
        }
    }

    public static void main(String[] args) {
        Ejercicio1 ej = new Ejercicio1();
        GrafoDirigidoMap<Integer> gr = new GrafoDirigidoMap<>();
        gr.agregarVertice(1);
        gr.agregarVertice(2);
        gr.agregarVertice(3);
        gr.agregarVertice(4);
        gr.agregarVertice(5);
        gr.agregarVertice(6);
        gr.agregarVertice(7);
        gr.agregarVertice(8);

        gr.agregarArco(1, 2, null);
        gr.agregarArco(2, 3, null);
        gr.agregarArco(3, 8, null);
        gr.agregarArco(4, 8, null);
        gr.agregarArco(1, 4, null);

        ej.buscarCaminoMasLargo(gr, 1, 8);

        System.out.println("Camino con vertices a 1 a 8:");
        for (Integer nodo : ej.getSolucion()) {
            System.out.print(nodo + " ");
        }
    }
}
