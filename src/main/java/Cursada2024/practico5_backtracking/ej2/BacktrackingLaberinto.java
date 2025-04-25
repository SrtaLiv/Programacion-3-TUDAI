package Cursada2024.practico5_backtracking.ej2;

import java.util.ArrayList;
import java.util.Iterator;

public class BacktrackingLaberinto {
    /*
        Ejercicio 2
        Dado un laberinto consistente en una matriz cuadrada que tiene en cada posición un valor natural y
        cuatro valores booleanos, indicando estos últimos si desde esa casilla se puede ir al norte, este, sur
        y oeste, encontrar un camino de longitud mínima entre dos casillas dadas, siendo la longitud de un
        camino la suma de los valores naturales de las casillas por las que pasa.

        Idea: podría representarse
        el laberinto como una matriz, de objetos, donde cada objeto tiene el valor natural, y cuatro
        booleanos, uno para cada dirección a la que se permite ir desde allí
     */
    private Casillero casillero;
    //Camino visitados = new Camino();
    Camino mejorCamino = new Camino();
    Camino visitados = new Camino();
    Casillero[][] matriz = new Casillero[4][4];

    public Camino getMejorCamino(Casillero c1, Casillero c2) {
        Camino caminoParcial = new Camino(); //Estado inicial, agregar casilleros

        caminoParcial.agregarAlCamino(c1);
        visitados.agregarAlCamino(c1);

        backtracking2(c1,c2,caminoParcial);
        return mejorCamino;
    }

    private void backtracking2(Casillero origen, Casillero destino, Camino caminoParcial) {
        if (origen.equals(destino)) {
            if (mejorCamino.getCamino().isEmpty() || caminoParcial.getCostoTotal() < mejorCamino.getCostoTotal()) {
                ArrayList<Casillero> copia =  new ArrayList<>(caminoParcial.getCamino());
                mejorCamino.setCamino(copia);
            }
            return;
        }

        for (Casillero vecino : origen.getVecinos()) {
            if (!visitados.getCamino().contains(vecino)) {
                caminoParcial.agregarAlCamino(vecino);
                visitados.agregarAlCamino(vecino);
                System.out.println(vecino.getCosto());
                backtracking2(vecino, destino, caminoParcial);

                caminoParcial.eliminarUltimoDelCamino();
                visitados.eliminarUltimoDelCamino();
            }
        }
    }
    }


//D: P E N S A R ! !
