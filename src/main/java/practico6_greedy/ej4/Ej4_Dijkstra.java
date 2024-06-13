package practico6_greedy.ej4;

import java.util.ArrayList;

public class Ej4_Dijkstra {
    /**
     * Ejercicio 4
     * Algoritmo de Dijkstra. Dado un grafo con pesos no negativos, implemente el algoritmo de Dijkstra
     * para determinar el array de distancias y de predecesores en el camino más corto, desde un vértice
     * orígen dado como parámetro hacia el resto de los vértices. Una vez realizado, imprima el camino
     * más corto que se debe seguir desde el orígen hacia cada vértice.

    ArrayList<Integer> distancia = new ArrayList<>();
    public void algoritmo(Grafo grafo, int origen){
        ArrayList<Integer> distancia = new ArrayList<>();
        ArrayList<Integer> predecesores = new ArrayList<>();

        ArrayList<Integer> vertices = grafo.obtenerVertices();
        int actual = vertices.get(origen);

        ArrayList<Integer> ady = actual.obtenerAdyacentes().iterator();

        for (Integer v : vertices){
            if (origen.obtenerAdyacentes().contains(v)){
                imprimirCaminoMasCorto(origen, v);
            }
        }


    }

    public void imprimirCaminoMasCorto(int origen, int vertice){
        System.out.println("camino mas corto:");
        for (Integer v : distancia){
            System.out.println(v);
        }
    }
     */
}
