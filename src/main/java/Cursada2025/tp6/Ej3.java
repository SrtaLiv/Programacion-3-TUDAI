package Cursada2025.tp6;

import java.util.ArrayList;
import java.util.Collections;

public class Ej3 {
    /**
     * Ejercicio 3
     * Maximizar el número de actividades compatibles. Se tienen n actividades que necesitan utilizar un
     * recurso, tal como una sala de conferencias, en exclusión mutua. Cada actividad i tiene asociado un
     * tiempo de comienzo ci y un tiempo de finalización fi de utilización del recurso, con ci < fi. Si la
     * actividad i es seleccionada se llevará a cabo durante el intervalo [ci, fi). Las actividades i y j son
     * compatibles si los intervalos [ci, fi) y [cj, fj) no se superponen (es decir, ci > fj o cj > fi). El problema
     * consiste en encontrar la cantidad máxima de actividades compatibles entre sí.
     */

    // act1, act2
    ArrayList<Actividad> solucion;

    public void buscarActividadesCompatibles(ArrayList<Actividad> actividades){
        ArrayList<Actividad> actividads = ComparadorMejorTiempo.sort(actividades); // ordenar por totalTiempo de menor a mayor
        greedy(actividads);
    }

    public void greedy(ArrayList<Actividad> actividades){
        int ultimoTiempo = 0;
        while (!actividades.isEmpty()){
            Actividad actual = actividades.getFirst();
            if (solucion.isEmpty()){
                solucion.add(actual);
            }
            else if (ultimoTiempo ){

            }
        }
    }

}
