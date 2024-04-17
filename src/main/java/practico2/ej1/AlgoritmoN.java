package practico2.ej1;

public class AlgoritmoN {

    public boolean verificarOrdenamiento(int[] arr, int n) {
        if (n == 1) {
            return true;
        }
        if (arr[n - 1] >= arr[n - 2]) {
            return verificarOrdenamiento(arr, n - 1);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        AlgoritmoN ver = new AlgoritmoN();

        boolean ordenado = ver.verificarOrdenamiento(arr, arr.length);
        System.out.println("¿El arreglo está ordenado? " + ordenado);
    }
}
