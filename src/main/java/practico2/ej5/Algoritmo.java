package practico2.ej5;

import java.util.ArrayList;

public class Algoritmo {
    /**
     * Ejercicio 5
     * Dado un arreglo ordenado de números distintos A se desea construir un algoritmo que
     * determine si alguno de los elementos de dicho arreglo contiene un valor igual a la posición en la
     * cuál se encuentra, es decir, A[i] = i.
     * 1. Construir un algoritmo recursivo que responda a dicha verificación.
     * 2. Mostrar la pila de ejecución para la invocación algoritmo([-3, -1, 0, 2, 4, 6, 10])
     */

    public ArrayList<Integer> numeros(int[]arr, int pos, ArrayList<Integer> ints){
        if (ints == null) {
            ints = new ArrayList<>(); // Crear la lista si es nula
        }
        if (pos < arr.length){
            if (arr[pos] == pos){
                System.out.println("el valor" + arr[pos]+ " esta en la posicion " +  pos);
            }
            ints.add(arr[pos]);
            numeros(arr, pos+1, ints);
        }
        return ints;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{-3, -1, 0, 2, 4, 6, 10};
        Algoritmo algo = new Algoritmo();
        ArrayList<Integer> resultado = algo.numeros(arr, 0, null);
        System.out.println(resultado);
    }
}
