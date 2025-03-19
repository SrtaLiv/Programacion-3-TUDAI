package tp1;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> list = new MySimpleLinkedList<>();
        Node<Integer> n1 = new Node<>(5, null);
        Node<Integer> n2 = new Node<>(2, null);
        Node<Integer> n3 = new Node<>(1, null);
        Node<Integer> n4 = new Node<>(4, null);
        Node<Integer> n5 = new Node<>(5, null);
        Node<Integer> n6 = new Node<>(6, null);

        list.insertFront(n1.getInfo());
        list.insertFront(n2.getInfo());
        list.insertFront(n3.getInfo()); // n3, n2, n1 -> 1, 2,5
       /*
        list.insertFront(n4.getInfo());
        list.insertFront(n5.getInfo());
        list.insertFront(n6.getInfo());*/

        System.out.println("Nodo" + list.get(0));

        System.out.println(list.indexOf(5)); // indice 2 -> info 5

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            System.out.print(i + " - ");

        }
    }
}
