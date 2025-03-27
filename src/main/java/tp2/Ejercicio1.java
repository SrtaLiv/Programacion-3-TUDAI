package tp2;

import java.util.ArrayList;

public class Ejercicio1 {

    int size;

    public boolean estaOrdenado(ArrayList<Integer> arr, int indice) {
        int aux = arr.get(indice);
        boolean ordenado = false;
        int size = arr.size() - 1;

        if (aux < arr.get(indice + 1) && indice < size) {
            ordenado = true;
            if (arr.get(indice + 1) != null) {
                return ordenado;
            }
            estaOrdenado(arr, aux + 1);
        }
        return ordenado;
    }

    //1. Tiene complejidad O(N)
    // 2. El unico problema es que hay que chequear que no pase de indice
    // y puede ser mas complejo de entender
    // 3. no se

    // ejercicio 2
    public void buscar(Integer num, Integer aux, ArrayList<Integer> arr) {
        int indice = arr.size() - 1; //empieza en el ultimo
        aux = arr.get(indice);
        if (aux == num) {
            System.out.println("Encontre el numero " +
                    num + " en el indice" + indice);
            return;
        }
        if (indice == 0) {
            System.out.println("El numero no esta");
            return;
        }
        buscar(num, indice - 1, arr);
    }

    // Ejercicio 3 convertir de decimal a binario
    // 26 y este me tome 11010
    public ArrayList<Integer> convertirDecimalABinario(int decimal) {
        ArrayList<Integer> result = new ArrayList<>();

        if (decimal == 0 || decimal == 1) { // no se puede dividir mas
            result.add(decimal);
            return result;
        }

        int resultado = decimal / 2;
        int resto = decimal - (resultado * 2);

        //result.add(resto);
        decimal = resultado;

        ArrayList<Integer> list = convertirDecimalABinario(decimal); // vuelve aca recursivamente en cada return
        list.add(resto);
        return list;
    }

    /*Implemente un algoritmo recursivo que presente los primeros N términos de la secuencia de
    Fibonacci.
    Por ej. los 6 primeros términos son: 0 1 1 2 3 5 8*/
  /*  public ArrayList<Integer> fibonacci(int aux){
        int num1 = aux; // 0, 1

        ArrayList<Integer> list = new ArrayList<>(); // 0
        list.add(num1);
        int num2 = list.get(num1);

        fibonacci(num1+1);
    }


   */

    /*
    Ejercicio 5
    Dado un arreglo ordenado de números distintos A se desea construir un algoritmo que
    determine si alguno de los elementos de dicho arreglo contiene un valor igual a la posición en la
    cuál se encuentra, es decir, A[i] = i.
    1. Construir un algoritmo recursivo que responda a dicha verificación.
    2. Mostrar la pila de ejecución para la invocación algoritmo([-3, -1, 0, 2, 4, 6, 10])
     */
    // 0, 1, 2, 3
    // aux = 3
    // va por el tercer indice y retorna true
    public boolean hayValorIgualPosicion(ArrayList<Integer> arr, int aux, int indice){
        if (indice <= arr.size()-1){
            if (aux == indice){
                 return true;
            }
            else{
                return hayValorIgualPosicion(arr, aux, indice+1);
            }
        }
        return false;
    }

    /* Ejercicio 6
    Implemente un algoritmo de ordenamiento por selección en un arreglo.
I   Implemente un algoritmo de ordenamiento por burbujeo en un arreglo.
    ¿Qué complejidad big-O tienen estos algoritmos?
    */
    

}