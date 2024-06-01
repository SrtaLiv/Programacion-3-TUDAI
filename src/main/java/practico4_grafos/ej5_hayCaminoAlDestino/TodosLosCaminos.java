package practico4_grafos.ej5_hayCaminoAlDestino;

import practico4_grafos.grafosHash.GrafoDirigidoHASH;

import java.util.ArrayList;
import java.util.Iterator;

public class TodosLosCaminos {
/**
 * Escriba un algoritmo que dado un grafo G y un vértice v de dicho grafo, devuelva una lista
 * con todos los vértices a partir de los cuales exista un camino en G que termine en v.
 */

public ArrayList<Integer> verticesQueLleguenADestino(int actual, int destino, GrafoDirigidoHASH grafo){
    ArrayList<Integer> verticesQueCumple = new ArrayList<>();
    //grafo.visitados.clear();

    Iterator<Integer> todosLosVertices = grafo.obtenerVertices();
    while (todosLosVertices.hasNext()){
        Integer v = todosLosVertices.next();
        //grafo.visitados.clear(); // Clear visitados for each new start point

        if (verticesQueLleguenADestinoDFS(v, destino, grafo)) {
            verticesQueCumple.add(v);
        }
    }
    return verticesQueCumple;
}


    private boolean verticesQueLleguenADestinoDFS(int actual, int destino, GrafoDirigidoHASH grafo) {
        if (actual == destino) {
            return true;
        }
        //grafo.visitados.put(actual, new HashSet<>());
        Iterator<Integer> it = grafo.obtenerAdyacentes(actual);

        while (it != null && it.hasNext()) {
            Integer vAdy = it.next();
            //if (!grafo.visitados.containsKey(vAdy) && verticesQueLleguenADestinoDFS(vAdy, destino, grafo)){
            return true;
        }
    //}
        return false;
    }


}
