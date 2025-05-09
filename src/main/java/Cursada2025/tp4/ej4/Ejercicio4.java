package Cursada2025.tp4.ej4;

import Cursada2025.tp4.GrafoDirigido;

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

    public ArrayList<Integer> devolverCaminoSimpleMayorLongitud(GrafoDirigido<T> grafoDirigido,
                                                                Integer v1, Integer v2){
        // buscar camino de mayor longitud desde el vertice v1 al vertice v2

        Iterator<Integer> ady = grafoDirigido.obtenerAdyacentes(v1);
        visitados.add(v1);
        while (ady.hasNext()){
            if (!visitados.contains(ady.next())){
                buscarCaminoMayorLongitud(grafoDirigido, ady.next(), v2);
            }
        }
        return caminoMasLargo;
    }

    public void buscarCaminoMayorLongitud(GrafoDirigido<T> gr, Integer v1, Integer v2){
        Iterator<Integer> ady = gr.obtenerAdyacentes(v1);
        while (ady.hasNext()){
            if (!visitados.contains(ady.next())){
                visitados.add(ady.next());

                if (Objects.equals(ady.next(), v2)){ // si es solucion
                    if (visitados.size() > caminoMasLargo.size()){
                        caminoMasLargo = new ArrayList<>(visitados);
                    }
                }
                // ELSE PARA NO SEGUIR RECORRIENDO! pq seguiria recorriendo
                // si ya encontre solucion?!
                else{
                    buscarCaminoMayorLongitud(gr, ady.next(), v2);
                }

                //los recorridos estan visitados, se eliminan
                // Recomendado siemre hacerlo en el mismo nivel
                // de !visitados.contains..
                visitados.remove(ady.next());
            }
            // no tenia sentido pq en ningun momento lo agrego
            // a visitados s
            //visitados.remove(ady.next());
        }
    }
}
