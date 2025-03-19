package practico1.ej6;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> list1 = new MySimpleLinkedList<>();
        list1.insertFront(1);
        list1.insertFront(5);
        list1.insertFront(9);
        list1.insertFront(8);
        list1.insertFront(6);


        MySimpleLinkedList<Integer> list2 = new MySimpleLinkedList<>();
        list2.insertFront(5);
        list2.insertFront(8);
        list2.insertFront(2);
        list2.insertFront(4);
        list2.insertFront(3);


        MySimpleLinkedList lista = soloPrimeraNoSegunda(list1, list2);
        Iterator<Integer> iterador = lista.iterator();

        while (iterador.hasNext()) {
            Integer i = iterador.next();
            System.out.println(i);
        }
    }

    //si mi elemento en l1 no esta en la l2 lo agrego
    public static MySimpleLinkedList soloPrimeraNoSegunda(MySimpleLinkedList<Integer> l1,
                                                                   MySimpleLinkedList<Integer> l2){
        MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<Integer>();
        Iterator<Integer> it1 = l1.iterator();

        while (it1.hasNext()){
            Integer info1 = it1.next();
            boolean encontrado = false;
            Iterator<Integer> it2 = l2.iterator();
            while (it2.hasNext()){
                Integer info2 = it2.next();
                if (info1.equals(info2)){
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                lista.insertFront(info1);
            }
        }
        return lista;
    }

}
