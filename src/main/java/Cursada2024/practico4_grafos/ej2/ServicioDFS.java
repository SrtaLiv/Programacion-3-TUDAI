package practico4_grafos.ej2;

import practico4_grafos.grafosHash.GrafoDirigidoHASH;

import java.util.HashSet;
import java.util.Iterator;


public class ServicioDFS {

    HashSet<Integer> visitados;

    public ServicioDFS() {
        this.visitados = new HashSet<>();
    }

    public void dfsRecursivo(GrafoDirigidoHASH gr, int vertice){
        if (this.visitados.contains(vertice)){
            return;
        }

        visitados.add(vertice);
        System.out.print(vertice+" > ");

        Iterator<Integer> vertices = gr.obtenerAdyacentes(vertice);
        while (vertices.hasNext()){
            Integer v = vertices.next();
            //visitados.add(v);                    <- ta mal :c
            dfsRecursivo(gr, v);
        }

        System.out.println("");
        visitados.remove(vertice);

    }





















    /*
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
    }*/

}
