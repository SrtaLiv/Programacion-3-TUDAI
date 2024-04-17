package practico1.ej4;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<Integer>();

        lista.insertFront(1);
        lista.insertFront(2);
        lista.insertFront(3);

        Iterator<Integer> iterador = lista.iterator();
        while (iterador.hasNext()) {
            Integer i = iterador.next();
            System.out.println(i);
        }
    }
}
