package practico5_backtracking.ej2;

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
    ArrayList<Casillero> visitados = new ArrayList<>();
    Casillero[][] matriz = new Casillero[4][4];

    public Camino getMejorCamino(Casillero c1, Casillero c2) {
        Camino caminoParcial = new Camino(); //Estado inicial, agregar casilleros
        backtracking2(0, 0, c1, c2, caminoParcial);
        return mejorCamino;
    }

    private void backtracking2(int pos, int posC, Casillero origen, Casillero destino, Camino caminoParcial) {
        Casillero cc = matriz[pos][posC];

        if (cc.equals(destino)) {
            if (mejorCamino.getCamino().isEmpty() || caminoParcial.getCostoTotal() < mejorCamino.getCostoTotal()) {
                ArrayList<Casillero> copia =  new ArrayList<>(caminoParcial.getCamino());
                mejorCamino.setCamino(copia);
            }
            return;
        }

        if (!visitados.contains(cc)){
            visitados.add(cc);
            caminoParcial.agregarAlCamino(cc);


            if (pos > 0 && cc.up) {
                backtracking2(pos - 1, posC, origen, destino, caminoParcial);
            }
            if (posC < matriz.length - 1 && cc.right) {
                backtracking2(pos, posC + 1, origen, destino, caminoParcial);
            }
            if (pos < matriz.length - 1 && cc.down) {
                backtracking2(pos + 1, posC, origen, destino, caminoParcial);
            }
            if (posC > 0 && cc.left) {
                backtracking2(pos, posC - 1, origen, destino, caminoParcial);
            }
            caminoParcial.eliminarCasillero(cc);
            visitados.remove(cc);
        }

    }
}

//D: P E N S A R ! !
