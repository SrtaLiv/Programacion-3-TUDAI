package practico4.ej2;

import practico4.Grafo;
import practico4.GrafoDirigido;

import java.util.*;

public class ServicioDFS {
    GrafoDirigido<?> grafoDirigido;

    ArrayList<GrafoDirigido.Vertice> verticesVisitados;

    public ServicioDFS(GrafoDirigido<?> grafoDirigido, ArrayList<GrafoDirigido.Vertice> verticesVisitados) {
        this.grafoDirigido = grafoDirigido;
        this.verticesVisitados = verticesVisitados;
    }

    public ArrayList<Integer> dfs() {
        ArrayList<Integer> caminoCompleto = new ArrayList<>();
        Iterator<Integer> itr = grafoDirigido.obtenerVertices();
        while (itr.hasNext()) {
            recorrerDFS(vertice);
        }

    }

    public ArrayList<Integer> recorrerDFS(GrafoDirigido.Vertice vertice){

            if (vertice.getAdyacentes().size() == 0) {
                ArrayList<Integer> camino = new ArrayList<>();
                camino.add(vertice.getId());
                return camino;
            }

            if (verticesVisitados.contains(vertice)) {
                //return new ArrayList<>();
                return null;
            }

            verticesVisitados.add(vertice);
            recorrerDFS(vertice);
            verticesVisitados.remove(vertice);


    }


}
