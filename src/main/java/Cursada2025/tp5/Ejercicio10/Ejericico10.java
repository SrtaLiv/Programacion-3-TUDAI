package Cursada2025.tp5.Ejercicio10;

import java.util.ArrayList;
import java.util.Arrays;

public class Ejericico10 {
    /**
     * Ejercicio 10
     * Utilizando la técnica Backtracking, escriba un algoritmo que dado un conjunto de números enteros,
     * devuelva (si existen) todos los subconjuntos de tamaño N (dado como parámetro), cuyas sumas
     * sean exactamente cero. Por ejemplo dado el conjunto {-7, -3, -2, -1, 5, 8 } y N = 3, los subconjuntos
     * que suman cero son: {-7, -1, 8} y {-3, -2, 5}.
     */

    ArrayList<Integer> caminoParcial = new ArrayList<>();
    ArrayList<ArrayList<Integer>> soluciones = new ArrayList<>();
/*
    public void buscarSubConjuntos(int n, ArrayList<Integer> subconjubnto){
        for (Integer num : subconjubnto){
            backtracking(n, num, 0, subconjubnto);
        }
    }

    private void backtracking(int n, int actual, int contador, ArrayList<Integer> subconjubnto) {
        if (caminoParcial.size() == n){
            if (contador == 0){
                boolean sonIguales = buscarIgualdad(caminoParcial, soluciones); // busca si caminoParcial pertenece a soluciones
                // es true si [8, -1, 7] y tambien esta [-1, 7, 8]
                if (!sonIguales)
                    soluciones.add(new ArrayList<>(caminoParcial));
            }
            return;
        }
        else{
            if (!caminoParcial.contains(actual)){ // para no tener repetidos
                contador += actual;
                caminoParcial.add(actual);
                for (Integer num : subconjubnto){
                    backtracking(n, num, contador, subconjubnto);
                }
                contador-=actual; // este esta de mas pq el contador cuando termina el metodo es 0?
                caminoParcial.removeLast();
            }

        }
    }
*/

    //..........................................................................//
    public void buscarSubConjuntos(ArrayList<Integer> conjunto, int n) {
        backtrack(conjunto, n, 0, 0, new ArrayList<>());
    }

    private void backtrack(ArrayList<Integer> conjunto, int n, int startIndex, int sumaActual, ArrayList<Integer> camino) {
        if (camino.size() == n) {
            if (sumaActual == 0) {
                soluciones.add(new ArrayList<>(camino));
            }
            return;
        }

        for (int i = startIndex; i < conjunto.size(); i++) {
            int num = conjunto.get(i);
            camino.add(num);
            backtrack(conjunto, n, i + 1, sumaActual + num, camino);
            camino.removeLast(); // backtrack
        }
    }



    public static void main(String[] args) {
        Ejericico10 ej = new Ejericico10();
        ArrayList<Integer> conjunto = new ArrayList<>(Arrays.asList(-7, -3, -2, -1, 5, 8));
        int n = 3;
        ej.buscarSubConjuntos(conjunto, n);

        System.out.println("Subconjuntos de tamaño " + n + " que suman 0:");
        for (ArrayList<Integer> sol : ej.soluciones) {
            System.out.println(sol);
        }
    }
}
