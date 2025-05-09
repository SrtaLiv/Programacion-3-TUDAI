package Cursada2025.tp4.ej2;

import Cursada2025.tp4.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
    private HashMap<Integer, String> visitados = new HashMap<>();

    public boolean dfsVisitar(GrafoDirigidoMap<T> grafo) {
        // Inicializar todos los vértices como "Blanco"
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            visitados.put(vertices.next(), "Blanco");
        }

        // Recorrer vértices y hacer DFS
        Iterator<Integer> vertices2 = grafo.obtenerVertices();
        while (vertices2.hasNext()) {
            int v = vertices2.next();
            if (visitados.get(v).equals("Blanco")) {
                if (buscarEnProfundidad(v, grafo)) {
                    return true; // ciclo encontrado
                }
            }
        }
        return false; // no hay ciclos
    }

    private boolean buscarEnProfundidad(int v, GrafoDirigidoMap<T> grafo) {
        visitados.put(v, "Amarillo");

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(v);
        while (adyacentes.hasNext()) {
            int adyacenteId = adyacentes.next();
            String color = visitados.get(adyacenteId);
            if (color.equals("Blanco")) {
                if (buscarEnProfundidad(adyacenteId, grafo)) {
                    return true;
                }
            } else if (color.equals("Amarillo")) {
                return true; // ciclo encontrado
            }
        }

        visitados.put(v, "Negro");
        return false;
    }

}
