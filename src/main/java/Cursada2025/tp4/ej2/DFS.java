package Cursada2025.tp4.ej2;

import Cursada2025.tp4.Arco;
import Cursada2025.tp4.Grafo;
import Cursada2025.tp4.GrafoDirigido;
import Cursada2025.tp4.Vertice;

import java.util.ArrayList;
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
    ArrayList<Integer> visitados;

    public void dfsVisitar(GrafoDirigido<T> grafo){
        for (Vertice<T> v : grafo.getVertices()){
            v.setColor("Blanco");
        }
        for (Vertice<T> vertice : grafo.getVertices()){
            buscarEnProfundidad(vertice);
        }
    }

    private void buscarEnProfundidad(Vertice<T> v){
        v.setColor("Amarillo");
//
       for (Arco<T> ady : v.getAdyacentes()){
            if (!visitados.contains(ady.getVerticeDestino())) {
                visitados.add(ady.getVerticeDestino());
                buscarEnProfundidad(v);
            }
            else if (v.getColor().equals("Amarillo")){
                System.out.println("Hay Ciclo");
            }
        }
        v.setColor("Negro");
    }

}
