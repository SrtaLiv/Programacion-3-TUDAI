package Cursada2025.tp5.Ejercicio2;

import java.util.ArrayList;
/**
 * Ejercicio 2
 * Dado un laberinto consistente en una matriz cuadrada que tiene en cada posición un valor natural y
 * cuatro valores booleanos, indicando estos últimos si desde esa casilla se puede ir al norte, este, sur
 * y oeste, encontrar un camino de longitud mínima entre dos casillas dadas, siendo la longitud de un
 * camino la suma de los valores naturales de las casillas por las que pasa. Idea: podría representarse
 * el laberinto como una matriz, de objetos, donde cada objeto tiene el valor natural, y cuatro
 * booleanos, uno para cada dirección a la que se permite ir desde allí.
 */
public class Camino {
    ArrayList<Casillero> casilleros;

    public Camino(Camino visitados) {
    }

    public void addCasillero(Casillero cas){
        casilleros.add(cas);
    }
    
}
