package practico1.ej6;

public class Node<T> {
    Node<T> next;
    T info;

    public Node() {
        this.info = null;
        this.next = null;
    }

    public Node(T info, Node<T> first) {
        setInfo(info);
        setNext(first);
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
