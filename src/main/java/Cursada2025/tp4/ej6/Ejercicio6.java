package Cursada2025.tp4.ej6;

import Cursada2025.tp4.GrafoDirigidoMap;
import Cursada2025.tp4.ej5.Ejercicio5;

import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio6 {

    /**
     * Ejercicio 6
     * Supongamos que una ciudad se encuentra modelada mediante un grafo, donde cada nodo
     * es una esquina, y las aristas representan las calles. Diseñe un algoritmo tal que dadas dos
     * esquinas, devuelva el camino más corto entre ambas de manera de caminar la menor
     * cantidad de cuadras posible.
     */
    ArrayList<Integer> caminoActual = new ArrayList<>();
    ArrayList<Integer> solucion = new ArrayList<>();

    public ArrayList<Integer> getCaminoActual() {
        return caminoActual;
    }

    public void setCaminoActual(ArrayList<Integer> caminoActual) {
        this.caminoActual = caminoActual;
    }

    public ArrayList<Integer> getSolucion() {
        return solucion;
    }

    public void setSolucion(ArrayList<Integer> solucion) {
        this.solucion = solucion;
    }

    public ArrayList<Integer> caminoMasCorto(GrafoDirigidoMap gr, int esq1, int esq2){

        buscarCaminoMasCorto(gr, esq1, esq2);
        Iterator<Integer> it = gr.obtenerAdyacentes(esq1);
        solucion.add(esq1);

        while (it.hasNext()){
            buscarCaminoMasCorto(gr, it.next(), esq2);
        }
        return solucion;
    }

    private void buscarCaminoMasCorto(GrafoDirigidoMap gr, int actual, int destino) {
        caminoActual.add(actual);

        if (actual == destino){
            // como hago para comparar la solucion con la posible solucion actual
            if (solucion.isEmpty()){ // es la primer solucion
                solucion.addAll(caminoActual);
            }
            else if (caminoActual.size() < solucion.size()){
                solucion.addAll(caminoActual);
            }
            return;
        }

        Iterator<Integer> adyacentes = gr.obtenerAdyacentes(actual);

        while (adyacentes.hasNext()){
            Integer ady = adyacentes.next();
            /*if (!solucion.contains(ady)){
                caminoActual.add(ady);
            }*/
            buscarCaminoMasCorto(gr, ady, destino);
            //REVISAR QUE HAGO SI EL GRAFO ES CICLICO!!!
        }

        caminoActual.remove((Integer) actual);

    }

    public static void main(String[] args) {
        GrafoDirigidoMap<Integer> grafoDirigidoMap = new GrafoDirigidoMap<>();
        grafoDirigidoMap.agregarVertice(1);
        grafoDirigidoMap.agregarVertice(2);
        grafoDirigidoMap.agregarVertice(3);
        grafoDirigidoMap.agregarVertice(4);
        grafoDirigidoMap.agregarVertice(5);
        grafoDirigidoMap.agregarVertice(6);

        grafoDirigidoMap.agregarArco(1, 2, 0);
        grafoDirigidoMap.agregarArco(2, 5, 0);
        grafoDirigidoMap.agregarArco(2, 3, 0);
        grafoDirigidoMap.agregarArco(3, 6, 0);
        grafoDirigidoMap.agregarArco(1, 4, 0);

        Ejercicio6 ej6 = new Ejercicio6();
         ej6.buscarCaminoMasCorto(grafoDirigidoMap, 1, 5);

        System.out.println("Camino con vertices a 1 a 5:");
        for (Integer nodo : ej6.getSolucion()) {
            System.out.print(nodo + " ");
        }
    }
}
