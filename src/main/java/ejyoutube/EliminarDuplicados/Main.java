package ejyoutube.EliminarDuplicados;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ListaVinculada<Integer> list = new ListaVinculada<>();
        list.insertFront(1);
        list.insertFront(2);
        list.insertFront(1);
        list.insertFront(2);

        Iterator<Integer> iterador = list.iterator();
        while (iterador.hasNext()){
            Integer i = iterador.next();
            System.out.println(i);

        }
    }
}
