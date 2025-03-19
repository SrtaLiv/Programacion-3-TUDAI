package practico2.ej4;

import java.util.ArrayList;

public class Fibonacci {
    /**
     * Ejercicio 4
     * Implemente un algoritmo recursivo que presente los primeros N términos de la secuencia de
     * Fibonacci.
     *
     * Por ej. los 6 primeros términos son: 0 1 1 2 3 5 8 13
     * a=0, b=1 (0 1)
     * a=1, b=1 (1 1)
     * a=1, b=2 (1 2)
     * a=2, b=3 (2 3)
     * a=3, b=5 (3 5)
     * a=5, b=8 (5 8)
     * a=8, b=13 (8 13)
     * a=13, b=21 (13 21)
     * a=21, b=34 (21 34)
     * a=34, b=55 (34 55)
     */


    public void secuencia(int fin){
        int a = 0;
        int b = 1;

        for (int i = 0; i<fin;i++){
            System.out.println(a);
            int temp = a + b;
            a = b;
            b = temp;
       }
    }

    public void fiboRecursivo(int a, int b, int n){
       if (n>0){
            System.out.println(a);
            fiboRecursivo(b, a+b, n-1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        Fibonacci fb = new Fibonacci();
        System.out.println("FIBONACCI");
        //fb.secuencia(10);

        fb.fiboRecursivo(0, 1,10);


    }
}
