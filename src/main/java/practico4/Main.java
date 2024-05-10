package practico4;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("************************************************");
        System.out.println("GRAFO DIRIGIDO CON LISTA DE ADYACENCIA");
        // Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
        GrafoDirigido<Float> grafito = new GrafoDirigido<>();

        // Agrego los vertices 1 y 2
        grafito.agregarVertice(1);
        grafito.agregarVertice(2);

        // Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
        grafito.agregarArco(1, 2, 3F);

        // Obtengo el arco entre 1 y 2, y le pido la etiqueta
        Float etiqueta = grafito.obtenerArco(1, 2).getEtiqueta();

        System.out.println(etiqueta); // Debería imprimir 3

        System.out.println("Cantidad de vertices: " + grafito.cantidadVertices());
        System.out.println("Cantidad de arcos: " + grafito.cantidadArcos());


        System.out.println("**************** OBTENER VERTICES ****************");
        Iterator<Integer> it = grafito.obtenerVertices();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("**************** OBTENER ADYACENTES ****************");
        Iterator<Integer> itAdyacentes = grafito.obtenerAdyacentes(2);
        while (itAdyacentes.hasNext()) {
            System.out.println(itAdyacentes.next());
        }

        System.out.println("************************************************");
        System.out.println("GRAFOS NO DIRIGIDOS");
        GrafoNoDirigido<Float> grafitoNoDirigido = new GrafoNoDirigido<>();

    }

}