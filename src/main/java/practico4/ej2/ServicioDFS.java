package practico4.ej2;

import practico4.grafosHash.GrafoDirigidoHASH;

import java.util.HashSet;
import java.util.Iterator;


public class ServicioDFS {

    public static void dfsRecursivo(GrafoDirigidoHASH<String> grafo, int verticeActual, HashSet<Integer> visitados) {
        visitados.add(verticeActual);
        System.out.println("Visitando vértice: " + verticeActual);

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(verticeActual);
        while (adyacentes.hasNext()) {
            int adyacente = adyacentes.next();
            if (!visitados.contains(adyacente)) {
                dfsRecursivo(grafo, adyacente, visitados);
            }
        }
    }

}
