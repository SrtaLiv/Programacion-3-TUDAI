package Cursada2025.tp4.ej2;

import Cursada2025.tp4.Arco;
import Cursada2025.tp4.Grafo;
import Cursada2025.tp4.GrafoDirigido;
import Cursada2025.tp4.Vertice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class DFS<T> {
    // DFS es para busquedas profundas
    /**
     * Usá DFS cuando:
     * Te interesa explorar caminos completos antes de probar otros.
     * Buscás ciclos en un grafo.
     * Querés ver si hay una ruta entre dos nodos (no la más corta).
     * Trabajás con problemas de backtracking (como laberintos, sudokus, etc).
     */
    HashMap<Integer, String> visitados;

    public void dfsVisitar(GrafoDirigido<T> grafo){
        for (Vertice<T> v : grafo.getVertices()){
            visitados.put(v.getId(), "Blanco");
        }
        for (Integer vertice : grafo.getVertices()){ // cambiarlo por iterator
            buscarEnProfundidad(vertice);
        }
    }

    private boolean buscarEnProfundidad(Vertice<T> v){
        visitados.put(v.getId(), "Amarillo"); // Esta visitado
//
       for (Arco<T> ady : v.getAdyacentes()){
            if (visitados.get(ady.getVerticeDestino()).equals("Blanco")){ // si el ady no esta visitado,
                //estaba mal poner is es igual amarillo, pq si fuera NEGRO entraba, y no queremos eso.
                visitados.put(ady.getVerticeDestino(), "Amarillo"); // lo visitamos
                buscarEnProfundidad(v);
            }
            else if (visitados.get(ady.getVerticeDestino()).equals("Amarillo")){
                return true; // hay ciclo
            }
        }
        visitados.put(v.getId(), "Negro");
       return false;
    }

}
