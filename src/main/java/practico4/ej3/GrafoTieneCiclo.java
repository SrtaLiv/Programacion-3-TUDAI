package practico4.ej3;

import practico4.grafoListaAdy.GrafoDirigido;

import java.util.HashSet;

public class GrafoTieneCiclo {
    GrafoDirigido<?> grafito;

    public GrafoTieneCiclo(GrafoDirigido<?> grafito) {
        this.grafito = grafito;
    }
    //agarro vertice origen
    //recorro..
    //si vertice destino el proximo es igual que el vertice origen
    // break; el grafo tiene un ciclo

    public boolean tieneCiclo() {
        HashSet<GrafoDirigido<?>.Vertice> visitados = new HashSet<>();
        HashSet<GrafoDirigido<?>.Vertice> enRecorrido = new HashSet<>();

        for (GrafoDirigido<?>.Vertice vertice : grafito.getVertices()) {
            if (dfs(vertice, visitados, enRecorrido)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(GrafoDirigido<?>.Vertice vertice, HashSet<GrafoDirigido<?>.Vertice> visitados, HashSet<GrafoDirigido<?>.Vertice> enRecorrido) {
        if (enRecorrido.contains(vertice)) {
            return true; // Ciclo encontrado
        }

        if (visitados.contains(vertice)) {
            return false; // Ya visitado, no forma ciclo
        }

        visitados.add(vertice);
        enRecorrido.add(vertice);

        /*for (Arco<?> arco : vertice.getAdyacentes()) {
            if (dfs(arco.getVerticeDestino(), visitados, enRecorrido)) {
                return true;
            }
        }

         */

        enRecorrido.remove(vertice); // Eliminar de la lista de recorrido
        return false;
    }
}