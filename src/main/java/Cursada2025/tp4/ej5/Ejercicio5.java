package Cursada2025.tp4.ej5;

import Cursada2025.tp4.GrafoDirigido;

import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio5 {
    /**
     * Ejercicio 5
     * Escriba un algoritmo que dado un grafo G y un vértice v de dicho grafo, devuelva una lista
     * con todos los vértices a partir de los cuales exista un camino en G que termine en v.
     */
    ArrayList<Integer> visitados = new ArrayList<>();
    ArrayList<Integer> camino = new ArrayList<>();

    public void buscarCaminoDeUnVertice(GrafoDirigido<Integer> gr, int vertice){
        Iterator<Integer> it = gr.obtenerAdyacentes(vertice);
        visitados.add(vertice);

        while (it.hasNext()){
            buscarCamino(gr, it.next(), vertice);
        }

    }


    private void buscarCamino(GrafoDirigido<Integer> gr, int destino, int ady ){
        Iterator<Integer> adyacentes = gr.obtenerAdyacentes(ady);

        /*while (adyacentes.hasNext()){
            // Si ya estaba el ady en el camino, significa que ese vertice puede llegar al destino
            // no hace falta seguir recorriendo
            if (camino.contains(adyacentes.next())){
                camino.add(ady);
                break;
            }

            if (!visitados.contains(ady.next())){
                visitados.add(ady.next());

                buscarCaminoDeUnVertice(gr, a);
            }

        }*/
    }

    public static void main(String[] args) {

    }
}
