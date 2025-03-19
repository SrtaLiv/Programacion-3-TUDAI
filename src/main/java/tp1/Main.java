package tp1;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> list = new MySimpleLinkedList<>();
        Node<Integer> n1 = new Node<>(5, null);
        Node<Integer> n2 = new Node<>(2, null);
        Node<Integer> n3 = new Node<>(1, null);

        MySimpleLinkedList<Integer> list2 = new MySimpleLinkedList<>();
        Node<Integer> n4 = new Node<>(5, null);
        Node<Integer> n5 = new Node<>(2, null);
        Node<Integer> n6 = new Node<>(9, null);

        list.insertFront(n1.getInfo());
        list.insertFront(n2.getInfo());
        list.insertFront(n3.getInfo()); // n3, n2, n1 -> 1, 2,5

        list2.insertFront(n4.getInfo());
        list2.insertFront(n5.getInfo());
        list2.insertFront(n6.getInfo());
       /*
        list.insertFront(n4.getInfo());
        list.insertFront(n5.getInfo());
        list.insertFront(n6.getInfo());*/

        System.out.println("Nodo" + list.get(0));

        System.out.println(list.indexOf(5)); // indice 2 -> info 5

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.print(i + " - ");

        }

        System.out.print("Lista 1: ");
        for (Integer num : list) {
            System.out.print(num + " - ");
        }
        System.out.println();

        System.out.print("Lista 2: ");
        for (Integer num : list2) {
            System.out.print(num + " - ");
        }
        System.out.println();

        MySimpleLinkedList<Integer> listResult = construirOtraLista(list2, list);

        System.out.print("Lista Resultante: ");
        for (Integer num : listResult) {
            System.out.print(num + " - ");
        }
    }

     /*
    Ejercicio 5
    Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
    suponiendo que:
    a) Las listas están desordenadas y la lista resultante debe quedar ordenada.
    b) Las listas están ordenadas y la lista resultante debe mantenerse ordenada.
     */

    // esta lista debe ordenarse si son letras o numeros?
    //implementar Comparator
    public static <T extends Comparable<T>> MySimpleLinkedList<T> construirOtraLista(MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2) {
        Iterator<T> tmp1 = l1.iterator();
        MySimpleLinkedList<T> result = new MySimpleLinkedList<>();

        while (tmp1.hasNext()) {
            T info1 = tmp1.next();
            Iterator<T> tmp2 = l2.iterator();

            while (tmp2.hasNext()) {
                T info2 = tmp2.next();
                if (info1.equals(info2)) { // Si son iguales lo agrego a la lista
                    result.insertarOrdenado(info1);
                }
            }
        }
        return result;
    }
}
