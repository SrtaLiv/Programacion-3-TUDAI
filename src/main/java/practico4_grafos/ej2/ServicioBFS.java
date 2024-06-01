package practico4_grafos.ej2;

import practico4_grafos.grafosHash.GrafoDirigidoHASH;

import java.util.HashSet;
import java.util.Iterator;

public class ServicioBFS {
    //(Breadth-First Search) - Recorrido en Amplitud
    public static void bfsRecursivo(GrafoDirigidoHASH<String> grafo, int verticeActual, HashSet<Integer> visitados) {
        visitados.add(verticeActual);
        System.out.println("Visitando vértice: " + verticeActual);

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(verticeActual);
        while (adyacentes.hasNext()) {
            int adyacente = adyacentes.next();
            if (!visitados.contains(adyacente)) {
                bfsRecursivo(grafo, adyacente, visitados);
            }
        }
    }


}
