package Cursada2025.tp1;

import java.util.Iterator;

// t extiende comparable
public class MySimpleLinkedDoubleList<T extends Comparable<T>> implements Iterable<T> {

    private int size;
    private Node<T> first;
    private Node<T> last;

    public MySimpleLinkedDoubleList() {
        this.first = null;
        this.size = 0;
        this.last = null;
    }

    // Inserta en el primer lugar, costo constante
    public void insertFront(T info) {
        Node<T> tmp = new Node<>(info, null, null);
        tmp.setNext(first);
        if (first != null)
            first.setBack(tmp);
        else
            last = tmp;
        first = tmp;
        size += 1;
    }

    // debe eliminar y devolver el primer elemento de la lista
    public T extractFront() {
        if (first == null){
            return null;
        }
        size -= 1;
        return this.first.getInfo();
    }

    // debe eliminar y devolver el ultimo elemento de la lista
    public T extractLast() {
        if (last == null){
            return null;
        }
        size -= 1;
        return this.last.getInfo();
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

    // indice de cierta info
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "MySimpleLinkedDoubleList{" +
                "size=" + size +
                ", first=" + first +
                ", last=" + last +
                '}';
    }
}
