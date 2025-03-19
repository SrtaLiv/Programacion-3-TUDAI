// Si no se puede formar la cantidad exacta, devolver una lista vacía
package practico6_greedy;

import java.util.ArrayList;
import java.util.Collections;

public class CambioMonedas {

    /*
    Ejercicio 1
    Cambio de monedas: Dado un conjunto C de N tipos de monedas con un número ilimitado de
    ejemplares de cada tipo, se requiere formar, si se puede, una cantidad M empleando el mínimo
    número de ellas.
    Por ejemplo, un cajero automático dispone de billetes de distintos valores: 100$, 25$, 10$, 5$ y 1$,
    si se tiene que pagar 289$, la mejor solución consiste en dar 10 billetes: 2 de 100$, 3 de 25$, 1 de
    10$ y 4 de 1$.
     */
    ArrayList<Integer> mejorSolucion = new ArrayList<>() ;

    public ArrayList<Integer> buscarCambioMonedas(ArrayList<Integer> conjuntoMonedas, int billete){
        // Ordenar las monedas en orden descendente
        Collections.sort(conjuntoMonedas, Collections.reverseOrder());
        ArrayList<Integer> resultado = new ArrayList<>();
        int sumaActual = 0;

        for (int moneda : conjuntoMonedas){
            while (sumaActual + moneda <= billete){
                resultado.add(moneda);
                sumaActual+=moneda;
            }
            if (sumaActual == billete){
                break;
            }
        }

        if (sumaActual != billete){
            // Si no se puede formar la cantidad exacta, devolver una lista vacía
            return new ArrayList<>();
        }
        return resultado;
    }

    public static void main(String[] args) {
        CambioMonedas cambioMonedas = new CambioMonedas();

        ArrayList<Integer> conjuntoMonedas = new ArrayList<>();
        conjuntoMonedas.add(100);
        conjuntoMonedas.add(25);
        conjuntoMonedas.add(10);
        conjuntoMonedas.add(5);
        conjuntoMonedas.add(1);

        int cantidad = 101;

        ArrayList<Integer> resultado = cambioMonedas.buscarCambioMonedas(conjuntoMonedas, cantidad);

        System.out.println("Monedas utilizadas: " + resultado);
    }
}
