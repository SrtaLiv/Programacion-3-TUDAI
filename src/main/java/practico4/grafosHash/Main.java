package practico4.grafosHash;

import practico4.ej2.ServicioDFS;
import practico4.ej3.GrafoTieneCiclo;

public class Main {
    public static void main(String[] args) {
        GrafoDirigidoHASH<String> grafo = new GrafoDirigidoHASH<>();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);

        grafo.agregarArco(1, 2, "ruta 3");
        grafo.agregarArco(1, 3, "ruta 4");
        grafo.agregarArco(2, 1, "ruta 4");

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


    }

}