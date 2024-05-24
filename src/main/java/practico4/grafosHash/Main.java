package practico4.grafosHash;

import java.util.HashSet;
import java.util.Iterator;

import static practico4.ej2.ServicioBFS.bfsRecursivo;
import static practico4.ej2.ServicioDFS.dfsRecursivo;

public class Main {
    public static void main(String[] args) {
        GrafoDirigidoHASH<String> grafo = new GrafoDirigidoHASH<>();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);

        grafo.agregarArco(1, 2, "ruta 3");
        grafo.agregarArco(2, 3, "ruta 4");
        grafo.agregarArco(1, 2, "ruta 4");

        /*System.out.println("Cantidad de vértices: " + grafo.cantidadVertices());
        System.out.println("Cantidad de arcos: " + grafo.cantidadArcos());

        grafo.borrarArco(1, 2);
        System.out.println("Cantidad de vértices: " + grafo.cantidadVertices());
        System.out.println("Cantidad de arcos: " + grafo.cantidadArcos());

        Iterator<Integer> vertices = grafo.obtenerVertices();
        System.out.println("Vertices del grafo: ");
        while (vertices.hasNext()){
            System.out.print(vertices.next() + " | ");
        }*/

        HashSet<Integer> visitados = new HashSet<>();
        bfsRecursivo(grafo, 1, visitados);
        dfsRecursivo(grafo, 1, visitados);


    }

}