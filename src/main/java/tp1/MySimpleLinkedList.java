package tp1;

import Cursada2024.practico1.ej4.MyIterador;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T>{

    private int size;
    private Node<T> first;

    public MySimpleLinkedList() {
        this.first = null;
        this.size = 0;
    }

    // Inserta en el primer lugar
    public void insertFront(T info) {
        Node<T> tmp = new Node<>(info, null);
        tmp.setNext(first);
        first = tmp;
        size += 1;
    }

    // debe eliminar y devolver el primer elemento de la lista
    public T extractFront() {
        if (first == null){
            return null;
        }
        Node<T> eliminar = this.first;
        System.out.println(eliminar.getInfo());

        eliminar.setNext(eliminar.getNext().getNext());
        eliminar.setInfo(eliminar.getNext().getInfo());
        size -= 1;
        return this.first.getInfo();
    }

    public boolean isEmpty() {
        return this.first == null || this.size == 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        if (index == 0){
            return this.first.getInfo();
        }

        Node<T> tmp = this.first;
        for (int i = 0; i < index; i++){
                tmp = tmp.getNext();
        }
        return tmp.getInfo();
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String info = "" + this.first.getInfo();
        return info;
    }

    /*A la implementación de la clase Lista realizada en el ejercicio 1, agregue un método
int indexOf(T), que reciba un elemento y retorne el índice donde está almacenado ese
elemento, o -1 si el elemento no existe en la lista.
*
     */
    public int indexOf(T info){
        Node<T> first = this.first;
        for (int i = 0 ; i < size ; i++){
            if (first.getInfo().equals(info)){
                System.out.println("Hay misma info en el indice: " + i +
                        " de info " + first.getInfo());
                return i;
            }
            first = first.getNext();
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(this.first);
    }

    /*
    Ejercicio 5
    Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
    suponiendo que:
    a) Las listas están desordenadas y la lista resultante debe quedar ordenada.
    b) Las listas están ordenadas y la lista resultante debe mantenerse ordenada.
     */

    // esta lista debe ordenarse si son letras o numeros?
    public MySimpleLinkedList<T> construirOtraLista(MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2){
        Iterator<T> tmp1 = l1.iterator();
        Iterator<T> tmp2 = l2.iterator();
        MySimpleLinkedList<T> result = new MySimpleLinkedList<>();

        while (tmp1.hasNext()) {
            T info1 = tmp1.next();
            while (tmp2.hasNext()){
                if (info1.equals(tmp2.next())){
                    if (result.first.getInfo() == null ){
                        result.insertFront(tmp2.next());
                    }
                    // Sino recorro hasta encontrar uno que sea mayor a Tmp.next()
                    // Eejmplo lista guardada: 1, 2, 5
                    // Tmp.info es  =  4
                    // 1 es < 4? si, next. 2 es < 4 si, next. 5 < 4 NO, agrego ahi.
                    for (int i = 0; i < result.size; i++){
                        T infoTemp = result.get(i);
                        if (infoTemp < tmp2.next()){
                            tmp2.next();
                        }
                        else {
                            // agrego el ej 4
                        }
                        }

                }
                tmp2.
                }
                tmp2.next();
               tmp1.next();
            }

            if (info1.equals(info2)){
                result.insertFront(info1);
            }
        }
    }
}
