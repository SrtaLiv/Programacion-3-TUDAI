package Cursada2025.tp4;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        // Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
        GrafoDirigido<Float> grafito = new GrafoDirigido<>();

        // Agrego los vertices 1 y 2
        grafito.agregarVertice(1);
        grafito.agregarVertice(2);
        grafito.agregarVertice(3);

        // Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
        grafito.agregarArco(1, 2, 3F);

        Iterator<Integer> it = grafito.obtenerVertices();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        boolean existe = grafito.existeArco(1, 2);
        System.out.println(existe);

      /*  System.out.println("otra iteracion");
        Iterator<Integer> it2 = grafito.obtenerVertices();
        while (it.hasNext()){
            System.out.println(it2.next());
        }
*/

        // Obtengo el arco entre 1 y 2, y le pido la etiqueta
      //  Float etiqueta = grafito.obtenerArco(1, 2).getEtiqueta();

    //    System.out.println(etiqueta); // Debería imprimir 3
    }

}
