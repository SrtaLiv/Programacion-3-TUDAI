package practico1.ej5;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T> {

    private Node<T> first;
    int size;

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
        return null; // Retorna null si la lista está vacía
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

    /*public MySimpleLinkedList<T> obtenerComunes(MySimpleLinkedList<T> uno, MySimpleLinkedList<T> dos) {
        MySimpleLinkedList<T> tmp = new MySimpleLinkedList<>();

        MyIterator<T> itListaUno = new MyIterator<>(uno.getFirst());
        MyIterator<T> itListaDos = new MyIterator<>(dos.getFirst());

        while (itListaUno.hasNext() && itListaDos.hasNext()) {
            T infoUno = itListaUno.next();
            T infoDos = itListaDos.next();
            if (infoUno.equals(infoDos)) {
                tmp.insertFront(infoUno);
            }
        }
        return tmp;
    }*/

    @Override
    public Iterator<T> iterator() {
        return new practico1.ej5.MyIterator<>(this.first);
    }

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
