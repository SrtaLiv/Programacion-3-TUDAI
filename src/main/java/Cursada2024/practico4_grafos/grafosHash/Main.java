package Cursada2024.practico4_grafos.grafosHash;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        GrafoDirigidoHASH<String> grafo = new GrafoDirigidoHASH<>();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);
        grafo.agregarVertice(7);
        grafo.agregarVertice(8);
        grafo.agregarVertice(9);


        grafo.agregarArco(1, 2, "ruta 3");
        grafo.agregarArco(2, 5, "ruta 3");
        grafo.agregarArco(1, 5, "ruta 4");
        grafo.agregarArco(1, 6, "ruta 4");
        grafo.agregarArco(2, 6, "ruta 4");
        grafo.agregarArco(6, 7, "ruta 2");
        grafo.agregarArco(2, 9, "ruta 2");
        grafo.agregarArco(9, 7, "ruta 2");
        grafo.agregarArco(3, 7, "ruta 2");

        //grafo.agregarArco(2, 5, "ruta 4");
        //grafo.agregarArco(3, 5, "ruta 4");
        //grafo.agregarArco(5, 1, "ruta 4");

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

        //HashSet<Integer> visitados = new HashSet<>();
        ServicioDFS sdfs = new ServicioDFS();
        //bfsRecursivo(grafo, 1, visitados);
        sdfs.dfsRecursivo(grafo, 2);

        GrafoTieneCiclo consigna3 = new GrafoTieneCiclo();
        boolean ciclo = consigna3.tieneCiclo(grafo);
        System.out.println(ciclo);

        /*ArrayList<Integer> caminoMayor = grafo.caminoMayor(1,5);
        Iterator<Integer> it = caminoMayor.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }*/

        ArrayList<Integer> tieneCaminoAlVertice = grafo.verticesQueLleguenADestino(1,7,grafo);
        Iterator<Integer> iterator = tieneCaminoAlVertice.iterator();
        System.out.println("Vertices que tienen camino a 7");
        while (iterator.hasNext()){
            System.out.println( + iterator.next());
        }

    }

}