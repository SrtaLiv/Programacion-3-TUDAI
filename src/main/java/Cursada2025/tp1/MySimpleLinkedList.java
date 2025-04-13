package Cursada2025.tp1;

import java.util.Iterator;

// t extiende comparable
public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T> {

    private int size;
    private Node<T> first;

    public MySimpleLinkedList() {
        this.first = null;
        this.size = 0;
    }

    // Insertar ordenando
    public void insertarOrdenado(T info){
        Node<T> newNode = new Node<>(info, null);

        // Caso 1: Lista vacia o el nuevo nodo es menor que el primero
        if (first == null || info.compareTo(first.getInfo()) == 0) {
            this.insertFront(newNode.getInfo());
        }
        else {
                Node<T> aux = this.first;
                // si no se quedo sin numeros y el siguiente es < a info
                while (aux.getNext() != null && info.compareTo(aux.getNext().getInfo()) < 0) {
                    aux = aux.getNext();
                }
                    if (aux.getNext() == null) { // si no hay proximo inserto ultimo al next aux
                        aux.setNext(newNode);
                    } else { // aux es < info
                        // al 4 le seteo el 5 como next, al 3 le seteo como proximo el 4
                        newNode.setNext(aux.getNext());
                        aux.setNext(newNode);
                    }
                }
    }


    // Inserta en el primer lugar, costo constante
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
      //    todo
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

    /*A la implementación de la clase Lista realizada en el ejercicio 1, agregue un método
int indexOf(T), que reciba un elemento y retorne el índice donde está almacenado ese
elemento, o -1 si el elemento no existe en la lista.
*
     */
    public int indexOf(T info){
        Node<T> first = this.first;
        for (int i = 0 ; i < size ; i++){
            if (first.getInfo().equals(info)){
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = this.first;
        while (current != null) {
            sb.append(current.getInfo());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

}
