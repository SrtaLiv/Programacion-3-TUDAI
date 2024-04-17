package practico2.ej2;

public class AlgoritmoRecursivo2 {
    /**
     * Implemente un algoritmo recursivo para buscar un elemento en un arreglo ordenado
     * ascendentemente.
     */
    //4
    public int buscarElemento(int arr[], int n, int ini,int fin){
        if (n != arr[ini]){
            return buscarElemento(arr,n, ini+1, fin);
        }
        if (arr[ini] == n){
            return ini;
        }
        if (ini <= fin){
            System.out.println("Termine de recorrer");
            if (arr[ini] == n){
                return ini;
            }
            return -1; //no esta
        }
        return -1;
    }

    //5
    public int buscarElementoOptimizado(int arr[], int n, int ini, int fin){
        if (ini >= fin){
            return -1; //no se encontro
        }
        int medio = (ini + fin) / 2;

        if (n == arr[medio]){ //se encontro en el medio
            return medio;
        }
        if (n < arr[medio]){
            return buscarElementoOptimizado(arr, n, ini, medio-1);
        }
        else if (n > arr[medio]){
            return buscarElementoOptimizado(arr, n, medio+1, fin);
        }
        else return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,6,7,8,123,321};
        AlgoritmoRecursivo2 algo = new AlgoritmoRecursivo2();
        int elem = algo.buscarElementoOptimizado(arr, 3, 0, arr.length);
        System.out.println("El elemento esta en la posicion: " + elem);
    }
}
