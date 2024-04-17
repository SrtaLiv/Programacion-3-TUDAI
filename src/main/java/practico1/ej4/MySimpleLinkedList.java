package practico1.ej4;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T> {
    /*
    Ejercicio 4
    A partir de la clase Lista implementada en el ejercicio 1, implemente el patrón
    iterator-iterable, para que la lista sea iterable. ¿Existe alguna ventaja computacional a la hora
    de recorrer la lista de principio a fin si se cuenta con un iterador?
     */

    private Node<T> first;
    private int size;

    public MySimpleLinkedList() {
        this.first = null;
        this.size = 0;
    }

    //METODOS
    public int size(){
        return this.size;
    }

    public void insertFront(T info){
        Node<T> tmp = new Node<T>(info, null);
        tmp.setNext(this.first);
        this.first = tmp;
        size++;
    }


    //Acción de eliminar y devolver el primer elemento de la lista
    public T extractFront() {
        if (!this.isEmpty()) { // Verifica si la lista no está vacía
            T info = first.getInfo(); // Obtiene la información del primer nodo
            first = first.getNext(); // Actualiza el primer nodo al siguiente nodo, para que apunte al siguiente nodo en la lista
            this.size--; // Decrementa el tamaño de la lista
            return info; // Retorna la información del primer nodo extraído
        }
        return null;
    }

    public boolean isEmpty(){
        return this.size == 0 && this.first == null;
    }


    public T get(int index) {
        if (!isEmpty() && size() > index) {
            Node<T> tmp = this.first;
            for (int i = 0; i <= index && tmp != null; i++) {
                if (i == index) {
                    return tmp.getInfo();
                }
                tmp = tmp.getNext();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "MySimpleLinkedList{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterador<>(this.first);
    }

    public Node<T> getFirst() {
        return first;
    }
}
