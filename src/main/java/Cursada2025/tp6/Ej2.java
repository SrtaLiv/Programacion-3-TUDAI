package Cursada2025.tp6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Ej2 {
    /**
     * Ejercicio 2
     * Problema de la mochila: Se tienen n objetos y una mochila. Para i = 1,2,..n, el objeto i tiene un peso
     * positivo pi y un valor positivo vi. La mochila puede llevar un peso que no sobrepase P. El objetivo es
     * llenar la mochila de tal manera que se maximice el valor de los objetos transportados, respetando la
     * limitación de capacidad impuesta. Los objetos pueden ser fraccionados, si una fracción xi (0 ≤ xi ≤ 1)
     * del objeto i es ubicada en la mochila contribuye en xipi al peso total de la mochila y en xivi al valor
     * de la carga.
     * ¿Qué estrategia Greedy seguiría para resolver el problema? Esquematice la resolución mediante un
     * pseudocódigo en Java.
     */

    // v / p  →  valor dividido peso, pq queremos maximizar la cnatidad de VALOR

    ArrayList<Objeto> solucion = new ArrayList<>();

    public void particionarConjunto(ArrayList<Objeto> conjunto, int p){

        llenarMochila(conjunto, p);
    }

    private void llenarMochila(ArrayList<Objeto> conjunto, int p){
        ArrayList<Objeto> conjuntoAux = new ArrayList<>();

        for (Objeto o : conjunto) {
            double valor = o.getValor();
            double peso = o.getPeso();
            double maximoValor = valor / peso;

            conjuntoAux.add(new Objeto(peso, valor, maximoValor));
        }

        conjuntoAux.sort(new ComparadorValorPorPeso());

        double suma = 0;
        while (!conjuntoAux.isEmpty() && suma < p) {
            Objeto obj = conjuntoAux.getFirst();
            if (suma + obj.getPeso() <= p){
                solucion.add(obj);
                suma += obj.getPeso();
            }
            else {
                /**
                 * p es la capacidad total de la mochila.
                 * suma es el peso que ya hemos puesto en la mochila.
                 * (p - suma) es el espacio que queda disponible.
                 * obj.getPeso() es el peso total del objeto actual.
                 * Por eso, fraccion es la parte del objeto que podemos tomar (entre 0 y 1).
                 */
                double fraccion = (double)(p - suma) / obj.getPeso();
                double pesoFraccionado = p - suma;
                double valorFraccionado = (int)(obj.getValor() * fraccion);

                Objeto fraccionado = new Objeto(pesoFraccionado, valorFraccionado);
                solucion.add(fraccionado);
                suma += pesoFraccionado;
            }
            conjuntoAux.remove(obj);
            // cursor++; no hay q mover cursor pq siemppre tendremos el primer elemento!
        }
    }

    public ArrayList<Objeto> getSolucion() {
        return solucion;
    }

    public static void main(String[] args) {
        ArrayList<Objeto> objetos = new ArrayList<>();
        objetos.add(new Objeto(10, 60)); // v/p = 6
        objetos.add(new Objeto(20, 100)); // v/p = 5
        objetos.add(new Objeto(30, 120)); // v/p = 4

        int capacidad = 50;

        Ej2 mochila = new Ej2();
        mochila.particionarConjunto(objetos, capacidad);

        System.out.println("Objetos seleccionados:");
        for (Objeto obj : mochila.getSolucion()) {
            System.out.println(obj);
        }
    }
}




