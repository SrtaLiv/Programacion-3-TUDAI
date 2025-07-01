package EjerciciosExtra.Recuperatorio2019;

import java.util.ArrayList;

public class MergeSort {
    public ArrayList<Integer> mergeSort(ArrayList<Integer> list, int n){
        // caso base: una sola posición, ya está ordenada
        if (list.size() <= 1) {
            return list;
        }
        // dividir en dos mitades
        int mitad = list.size() / 2;
        ArrayList<Integer> izquierda = new ArrayList<>(list.subList(0, mitad));
        ArrayList<Integer> derecha = new ArrayList<>(list.subList(mitad, list.size()));

        // ordenar cada mitad
        izquierda = mergeSort(izquierda);
        derecha = mergeSort(derecha);

        // combinar mitades ordenadas
        return merge(izquierda, derecha);
    }

    private ArrayList<Integer> merge(ArrayList<Integer> izquierda, ArrayList<Integer> derecha) {

        ArrayList<Integer> solucuion = new ArrayList<>();
        int i = 0, j = 0, k=0;
        // comparar y agregar el menor
        while (i < izquierda.size() && j < derecha.size()) { //Recorremos ambas listas al mismo tiempo:
            //✔️ Luego, avanzamos el índice (i o j) de la lista de donde se sacó ese valor.
            if (izquierda.get(i) < derecha.get(j)) {
                solucuion.add(izquierda.get(i));
                i++;
            } else {
                solucuion.add(derecha.get(j));
                j++;
            }
        }

        // agregar lo que quedó en izquierda
        while (i < izquierda.size()) {
            solucuion.add(izquierda.get(i));
            i++;
        }

        // agregar lo que quedó en derecha
        while (j < derecha.size()) {
            solucuion.add(derecha.get(j));
            j++;
        }

        return solucuion;

    }
}
