package ejyoutube.BusquedaBinaria;

public class BusquedaRecursiva {
    public int BinariaRecursiva ( int[] a, int x, int ini, int fin ) {
        int medio;
        if ( ini > fin ) return -1; //sucede si no se encuentra el elemento
        else {
            medio = ( ini + fin ) / 2; //al ser medio un int, se realiza un truncado (pierde la parte decimal)
            if ( x > a[medio] )
                return BinariaRecursiva(a,x, medio + 1 , fin );
            else
                if ( x < a[medio] )
                    return BinariaRecursiva( a, x, ini,medio - 1 );
                else return medio;
        }
    }

    public static void main(String[] args) {
        /**
         *  Donde A es el array de enteros ordenado de menor a mayor.
         * • X es el número buscado.
         * • inicio se inicializa en 0.
         * • fin se iniciaiza en A.length-1
         */

        int[] arr = new int[]{1,2,3,42,444}; // sin coma después de 3
        int fin = arr.length-1;
        BusquedaRecursiva busq = new BusquedaRecursiva();
        System.out.println(busq.BinariaRecursiva(arr,444,0,fin));
    }
}
