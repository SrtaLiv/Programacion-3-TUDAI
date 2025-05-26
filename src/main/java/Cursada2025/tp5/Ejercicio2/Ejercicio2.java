package Cursada2025.tp5.Ejercicio2;

import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio2 {
//    Camino visitados = new Camino();
//    Camino solucion = new Camino();
//    Casillero[][] laberinto = new Casillero[3][3];

    /**
     * Ejercicio 2
     * Dado un laberinto consistente en una matriz cuadrada que tiene en cada posición un valor natural y
     * cuatro valores booleanos, indicando estos últimos si desde esa casilla se puede ir al norte, este, sur
     * y oeste, encontrar un camino de longitud mínima entre dos casillas dadas, siendo la longitud de un
     * camino la suma de los valores naturales de las casillas por las que pasa. Idea: podría representarse
     * el laberinto como una matriz, de objetos, donde cada objeto tiene el valor natural, y cuatro
     * booleanos, uno para cada dirección a la que se permite ir desde allí.
     */



//    public void buscarCaminoMinimaLongitud(Casillero[][] laberinto, Casillero c1, Casillero c2){
//        Iterator<Integer> it = laberinto.buscarAdyacentes(c1);
//        visitados.addCasillero(c1);
//
//        while (it.hasNext()){
//            buscarCaminoMinimo(laberinto, c1, c2, 0, 0);
//        }
//    }
//
//    private void buscarCaminoMinimo(Casillero[][] laberinto, Casillero actual, Casillero destino, int sumaTotal, int contador) {
//        visitados.addCasillero(actual); //2, 3
//        // es solucion
//        if (actual == destino){
//            if (contador < sumaTotal){
//                solucion = new Camino(visitados);
//            }
//        }
//        else{
//            //if (laberinto.puedeSeguir(actual)){ // ejemplo: el top es true, hay un casillero
//                contador += actual.getValue();
//
//                Iterator<Integer> it = laberinto.buscarAdyacentes(actual);
//                Integer next = it.next();
//
//                while (it.hasNext()){
//                    buscarCaminoMinimo(laberinto, next, destino);
//                }
//            //}
//        }
//
//        visitados.remove(actual);
//
//
//    }
//

    public static void main(String[] args) {

    }
}
