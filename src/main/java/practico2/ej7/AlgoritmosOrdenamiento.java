package practico2.ej7;

public class AlgoritmosOrdenamiento {
    /**
     * Ejercicio 6
     * Implemente un algoritmo de ordenamiento por selección en un arreglo.
     * Implemente un algoritmo de ordenamiento por burbujeo en un arreglo.
     *
     * ● ¿Qué complejidad big-O tienen estos algoritmos?
     */

    public void ordenamientoPorBurbujeo(int[]arr){
        int n = arr.length;
        for (int j = 0; j < n-1; j++) {
            for (int i = 0; i < n-j-1; i++) {
               if (arr[i]>arr[i+1]){
                   int tmp = arr[i];
                   arr[i] = arr[i+1];
                   arr[i+1] = tmp;
               }
            }
        }
    }

    // 2 4 1 12
    public void ordenamientoPorSeleccion(int[]arr){
        for (int i = 0; i < arr.length-1; i++){
            int min = i; //almacenamos el menor
            for (int j = i + 1; j < arr.length; j++){  // Empezamos desde i + 1 para buscar desde el siguiente elemento
                if (arr[min] > arr[j]){
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }




    public void imprimir(int[]arr){
        for (int i =0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[]arr = new int[]{25,2,3,41,23,45,12};
        AlgoritmosOrdenamiento org = new AlgoritmosOrdenamiento();
        //org.ordenamientoPorSeleccion(arr);
        //org.ordenamientoPorBurbujeo(arr);

        org.imprimir(arr);


    }


}
