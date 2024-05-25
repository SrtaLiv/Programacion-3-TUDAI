package practico4.ej3;
import practico4.grafosHash.GrafoDirigidoHASH;

import java.util.*;

/**
 * Ejercicio 3
 * Implemente un algoritmo que determine si un grafo dirigido tiene algún ciclo.
 */
public class GrafoTieneCiclo {
    // Método principal para verificar si el grafo contiene un ciclo
    public boolean tieneCiclo(GrafoDirigidoHASH grafo) {
        HashSet<Integer> visitados = new HashSet<>();
        HashSet<Integer> enCamino = new HashSet<>(); // para mantener los vértices en el camino actual de la DFS

        Iterator<Integer> itV = grafo.obtenerVertices();

        // Recorre los vertices
        while (itV.hasNext()) {
            int vertice = itV.next();

            // Si el vértice no ha sido visitado, iniciar una búsqueda de ciclo desde este vértice
            if (!visitados.contains(vertice)) {

                // Si se encuentra un ciclo, retornar true
                if (buscarCiclo(grafo, vertice, visitados, enCamino)) {
                    return true;
                }
            }
        }
        // Si no se encuentra ningún ciclo, retornar false
        return false;
    }

    // Método recursivo para buscar ciclos usando DFS
    public boolean buscarCiclo(GrafoDirigidoHASH graf, int vertice, HashSet<Integer> visitados, HashSet<Integer> camino) {
        // Marcar el vértice actual como visitado
        visitados.add(vertice);

        // Añadir el vértice actual al conjunto de vértices en el camino actual
        camino.add(vertice);

        // Obtener un iterador para todos los vértices adyacentes (destinos) del vértice actual
        Iterator<Integer> adyacentes = graf.obtenerAdyacentes(vertice);

        // Recorrer todos los vértices adyacentes
        while (adyacentes.hasNext()) {
            int ady = adyacentes.next();

            // Si un vértice adyacente no ha sido visitado, continuar la búsqueda recursivamente
            if (!visitados.contains(ady)) {

                if (buscarCiclo(graf, ady, visitados, camino)) { //Si es true, se encontro ciclo.
                    return true;
                }
                // Si un vértice adyacente está en el camino actual, se encontró un ciclo
            } else if (camino.contains(ady)) {
                return true; // Se encontró un ciclo
            }
        }

        // Quitar el vértice actual del conjunto de vértices en el camino actual
        camino.remove(vertice);
        // No se encontró un ciclo en esta rama de la búsqueda
        return false;
    }

    /**
     *
     Ejemplo para aclarar el uso de camino
     Supongamos que tenemos un grafo dirigido con los siguientes vértices y arcos:

     Vértices: 1, 2, 3, 4
     Arcos: (1 -> 2), (2 -> 3), (3 -> 4), (4 -> 2)
     Aquí hay un ciclo: 2 -> 3 -> 4 -> 2.

     * Cómo funciona el conjunto camino en este contexto
     * Iniciamos DFS desde el vértice 1:
     *
     * Añadimos el vértice 1 a visitados y camino.
     * visitados = {1}
     * camino = {1}
     * Desde el vértice 1, vamos al vértice 2:
     *
     * Añadimos el vértice 2 a visitados y camino.
     * visitados = {1, 2}
     * camino = {1, 2}
     * Desde el vértice 2, vamos al vértice 3:
     *
     * Añadimos el vértice 3 a visitados y camino.
     * visitados = {1, 2, 3}
     * camino = {1, 2, 3}
     * Desde el vértice 3, vamos al vértice 4:
     *
     * Añadimos el vértice 4 a visitados y camino.
     * visitados = {1, 2, 3, 4}
     * camino = {1, 2, 3, 4}
     * Desde el vértice 4, intentamos ir al vértice 2:
     *
     * El vértice 2 ya está en camino, lo que indica que hemos encontrado un ciclo.
     * Retornamos true para indicar que se encontró un ciclo.
     */
}

