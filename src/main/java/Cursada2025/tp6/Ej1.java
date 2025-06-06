package Cursada2025.tp6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Ej1 {
    /*
    Ejercicio 1
    Cambio de monedas: Dado un conjunto C de N tipos de monedas con un número ilimitado de
    ejemplares de cada tipo, se requiere formar, si se puede, una cantidad M empleando el mínimo
    número de ellas.

   Por ejemplo, un cajero automático dispone de billetes de distintos valores: 100$, 25$, 10$, 5$ y 1$,
    si se tiene que pagar 289$, la mejor solución consiste en dar 10 billetes: 2 de 100$, 3 de 25$, 1 de
    10$ y 4 de 1$.
*/

    ArrayList<Integer> conjunto = new ArrayList<>(Arrays.asList(100, 25, 10, 5, 1));
    ArrayList<Integer> conjuntoSolucion = new ArrayList<>();

    public void repartirBilletes(ArrayList<Integer> conjunto, int m){
        conjunto.sort(Comparator.reverseOrder()); // ordenar de mayor a menor
        greedy(conjunto, m);
    }

    private ArrayList<Integer> greedy(ArrayList<Integer> conjunto, int m ){
        int contador = 0;
        int cursor = 0;

        while (cursor < conjunto.size() && contador < m) { // si fueras menor o igual, seguiria cuando sea igual avanznado!
            int candidato = conjunto.get(cursor);
            if (contador + candidato <= m){ // si es factible
                contador += candidato;
                conjuntoSolucion.add((candidato));
            }
            else{
                cursor++;
            }
        }
        if (!conjuntoSolucion.isEmpty()){
            return conjuntoSolucion;
        }
        else {
            return null; // no hay solucion
        }
    }

    public static void main(String[] args) {
        Ej1 ej = new Ej1();
        ArrayList<Integer> conjunto = new ArrayList<>(Arrays.asList(100, 25, 10, 5, 1));
        int monto = 289;
        ej.repartirBilletes(conjunto, monto);

        System.out.println("Solución (billetes usados): " + ej.conjuntoSolucion);
        System.out.println("Cantidad de billetes: " + ej.conjuntoSolucion.size());
        System.out.println("Monto " + monto);
    }
}
