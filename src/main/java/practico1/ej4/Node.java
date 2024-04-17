package practico1.ej4;

public class Node<T> {
    Node<T> next;
    T info;

    public Node(T info, Node<T> next) {
        setInfo(info);
        setNext(next);
    }

    public Node() {
        this.next = null;
        this.info = null;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
