package practico4.grafosHash;

import java.util.Iterator;

public class Main {
    /*public static void main(String[] args) {
        GrafoDirigidoHASH<String> grafo = new GrafoDirigidoHASH<>();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);


        grafo.agregarArco(1,2, "A");
        grafo.agregarArco(2,3, "B");

        System.out.println("Cantidad de vértices: " + grafo.cantidadVertices());
        System.out.println("Cantidad de arcos: " + grafo.cantidadArcos());

        // Verificar si un vértice está en el grafo
        System.out.println("Contiene el vértice 1: " + grafo.contieneVertice(1));
        System.out.println("Contiene el vértice 5: " + grafo.contieneVertice(5));

        // Verificar si un arco existe
        System.out.println("Existe arco de 1 a 2: " + grafo.existeArco(1, 2));
        System.out.println("Existe arco de 2 a 4: " + grafo.existeArco(2, 4));


        // Obtener y mostrar todos los vértices
        System.out.print("Vértices en el grafo: ");
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            System.out.print(vertices.next() + " ");
        }
        System.out.println();

        // Obtener y mostrar todos los arcos
        System.out.println("Arcos en el grafo:");
        Iterator<practico4.grafosHash.Arco<String>> arcos = grafo.obtenerArcos();
        while (arcos.hasNext()) {
            Arco<String> a = arcos.next();
            System.out.println("Arco de " + a.getVerticeOrigen() + " a " + a.getVerticeDestino() + " con etiqueta " + a.getEtiqueta());
        }

        // Obtener y mostrar adyacentes de un vértice
        System.out.print("Adyacentes del vértice 2: ");
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(2);
        while (adyacentes.hasNext()) {
            System.out.print(adyacentes.next() + " ");
        }
        System.out.println();

    }*/

    public static void main(String[] args) {
        GrafoDirigidoHASH<String> grafo = new GrafoDirigidoHASH<>();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);

        grafo.agregarArco(1, 2, "ruta 3");
        grafo.agregarArco(2, 3, "ruta 4");
        grafo.agregarArco(1, 2, "ruta 4");

        System.out.println("Cantidad de vértices: " + grafo.cantidadVertices());
        System.out.println("Cantidad de arcos: " + grafo.cantidadArcos());

        grafo.borrarArco(1, 2);
        System.out.println("Cantidad de vértices: " + grafo.cantidadVertices());
        System.out.println("Cantidad de arcos: " + grafo.cantidadArcos());

        Iterator<Integer> vertices = grafo.obtenerVertices();
        System.out.println("Vertices del grafo: ");
        while (vertices.hasNext()){
            System.out.print(vertices.next() + " | ");
        }


    }

}