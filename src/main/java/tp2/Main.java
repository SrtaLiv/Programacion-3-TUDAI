package tp2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Ejercicio1 ej = new Ejercicio1();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(10);

        boolean orden = ej.estaOrdenado(list, 0);
        System.out.println(orden);

        System.out.println("---------------------");
        ej.buscar(10, null, list);

        ArrayList<Integer> bin = ej.convertirDecimalABinario(26);
        for (Integer num : bin){
            System.out.println(num);
        }

        ArrayList<Integer> list2 = new ArrayList<>();
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(3);
        list.add(4);

        boolean hayValor = ej.hayValorIgualPosicion(list, 4, 0);
        System.out.println(hayValor);
    }
}
