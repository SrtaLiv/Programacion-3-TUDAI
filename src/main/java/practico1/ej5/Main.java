package practico1.ej5;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        MySimpleLinkedList<Integer> list = new MySimpleLinkedList<>();
        list.insertFront(1);
        list.insertFront(2);
        list.insertFront(3);

        MySimpleLinkedList<Integer> list2 = new MySimpleLinkedList<>();
        list2.insertFront(1);
        list2.insertFront(1);
        list2.insertFront(2);
        list2.insertFront(5);
        list2.insertFront(6);

        MySimpleLinkedList<Integer> listaComun = elementosComunes(list, list2);
        Iterator<Integer> iterador = listaComun.iterator();

        while (iterador.hasNext()) {
            Integer i = iterador.next();
            System.out.println(i);
        }
    }

        public static MySimpleLinkedList<Integer> elementosComunes(MySimpleLinkedList<Integer> l1, MySimpleLinkedList<Integer> l2){
            MySimpleLinkedList nueva = new MySimpleLinkedList<>();
            Iterator<Integer> it1 = l1.iterator();

            while (it1.hasNext()){
                Integer info1 = it1.next();
                Iterator<Integer> it2 = l2.iterator(); //pq tiene que recorrerse +1 vez se reinicia
                while (it2.hasNext()){
                    Integer info2 = it2.next();
                    if (!info1.equals(info2)){
                        nueva.insertFront(info1);
                    }
                }
            }
            return nueva;
        }

        public MySimpleLinkedList listasOrdAordenadas(MySimpleLinkedList l1, MySimpleLinkedList l2){
            MySimpleLinkedList nueva = new MySimpleLinkedList<>();
            return nueva;
        }
    }
