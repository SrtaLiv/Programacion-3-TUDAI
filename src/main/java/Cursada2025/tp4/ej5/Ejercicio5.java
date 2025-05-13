package Cursada2025.tp4.ej5;

import Cursada2025.tp4.GrafoDirigido;
import Cursada2025.tp4.GrafoDirigidoMap;
import Cursada2025.tp4.ej4.Ejercicio4;

import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio5 {
    /**
     * Ejercicio 5
     * Escriba un algoritmo que dado un grafo G y un vértice v de dicho grafo, devuelva una lista
     * con todos los vértices a partir de los cuales exista un camino en G que termine en v.
     */
    ArrayList<Integer> caminoActual = new ArrayList<>();
    ArrayList<Integer> solucion = new ArrayList<>();

    public ArrayList<Integer> buscarCaminoDeUnVertice(GrafoDirigidoMap<Integer> gr, int vertice){
        Iterator<Integer> it = gr.obtenerVertices();
        solucion.add(vertice); //4

        while (it.hasNext()){
            buscarCamino(gr,vertice, it.next());
        }

    return solucion;
    }


    private void buscarCamino(GrafoDirigidoMap<Integer> gr, int destino, int actual ){
        /*if (actual == destino){ // si llego a destino
            solucion.addAll(caminoActual);
            return;
        }*/

        if (solucion.contains(actual)){
            solucion.addAll(caminoActual);
            return;
        }

        caminoActual.add(actual);

        Iterator<Integer> adyacentes = gr.obtenerAdyacentes(actual);
        while (adyacentes.hasNext()){
            Integer adyacente = adyacentes.next();
            if (!solucion.contains(actual)) { // si no esta en la lista final, lo agrego a la posibilidad
                buscarCamino(gr, destino, adyacente);
            }
        }

        //caminoActual.remove(actual); // el indice este no es valido
        // Estás usando actual como si fuera un índice (posición en la lista), pero actual representa el número del vértice, no su posición.
        caminoActual.remove((Integer) actual); // correcto: elimina el objeto 'actual', no la posición
    }

    public static void main(String[] args) {
        GrafoDirigidoMap<Integer> grafoDirigidoMap = new GrafoDirigidoMap<>();
        grafoDirigidoMap.agregarVertice(1);
        grafoDirigidoMap.agregarVertice(2);
        grafoDirigidoMap.agregarVertice(3);
        grafoDirigidoMap.agregarVertice(4);
        grafoDirigidoMap.agregarVertice(5);
        grafoDirigidoMap.agregarVertice(6);

        grafoDirigidoMap.agregarArco(1, 5, 0);
        grafoDirigidoMap.agregarArco(2, 5, 0);
        grafoDirigidoMap.agregarArco(1, 2, 0);
        grafoDirigidoMap.agregarArco(2, 3, 0);
        grafoDirigidoMap.agregarArco(3, 6, 0);
        grafoDirigidoMap.agregarArco(1, 4, 0);

        Ejercicio5 ej5 = new Ejercicio5();
        ArrayList<Integer> caminoLargo = ej5.buscarCaminoDeUnVertice(grafoDirigidoMap, 4);

        System.out.println("Camino con vertices a 4:");
        for (Integer nodo : caminoLargo) {
            System.out.print(nodo + " ");
        }
    }
}
