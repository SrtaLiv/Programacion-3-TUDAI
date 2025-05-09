package Cursada2025.tp4.ej4;

import Cursada2025.tp4.GrafoDirigido;
import Cursada2025.tp4.GrafoDirigidoMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Ejercicio4<T> {
    /**
     * Ejercicio 4
     * Escribir un algoritmo que, dado un grafo dirigido y dos vértices i, j de este grafo, devuelva el
     * camino simple (sin ciclos) de mayor longitud del vértice i al vértice j. Puede suponerse que el
     * grafo de entrada es acíclico
     */

    // con bfs
    ArrayList<Integer> caminoMasLargo = new ArrayList<>();
    ArrayList<Integer> visitados = new ArrayList<>();

    public ArrayList<Integer> devolverCaminoSimpleMayorLongitud(GrafoDirigidoMap<T> grafoDirigido,
                                                                Integer v1, Integer v2){
        // buscar camino de mayor longitud desde el vertice v1 al vertice v2
        visitados.add(v1);
        buscarCaminoMayorLongitud(grafoDirigido, v1, v2);
        return caminoMasLargo;
    }

    public void buscarCaminoMayorLongitud(GrafoDirigidoMap<T> gr, Integer v1, Integer v2){
        // si es solucion corto antes
        if (v1.equals(v2)) {
            if (visitados.size() > caminoMasLargo.size()) {
                caminoMasLargo = new ArrayList<>(visitados);
            }
            return;
        }

        Iterator<Integer> ady = gr.obtenerAdyacentes(v1);
        while (ady.hasNext()) {
            Integer sig = ady.next();

            if (!visitados.contains(sig)) {
                visitados.add(sig);
                buscarCaminoMayorLongitud(gr, sig, v2);
                visitados.remove(sig); // backtrack
            }
        }
    }

    public static void main(String[] args) {
        GrafoDirigidoMap<Integer> grafoDirigidoMap = new GrafoDirigidoMap<>();
        grafoDirigidoMap.agregarVertice(1);
        grafoDirigidoMap.agregarVertice(2);
        grafoDirigidoMap.agregarVertice(3);
        grafoDirigidoMap.agregarVertice(4);
        grafoDirigidoMap.agregarVertice(5);

        grafoDirigidoMap.agregarArco(1, 2, 0);
        grafoDirigidoMap.agregarArco(2, 3, 0);
        grafoDirigidoMap.agregarArco(3, 4, 0);
        grafoDirigidoMap.agregarArco(4, 5, 0);

        Ejercicio4<Integer> ej4 = new Ejercicio4<>();
        ArrayList<Integer> caminoLargo = ej4.devolverCaminoSimpleMayorLongitud(grafoDirigidoMap, 4, 5);

        System.out.println("Camino más largo:");
        for (Integer nodo : caminoLargo) {
            System.out.print(nodo + " ");
        }
    }
}
