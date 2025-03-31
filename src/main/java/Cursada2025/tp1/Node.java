package Cursada2025.tp1;

public class Node<T> {
    private T info;
    private Node<T> next;
    private Node<T> back;

    public Node() {
        this.info = null;
        this.next = null;
        this.back = null;
    }

    public Node(T info, Node<T> next, Node<T> back) {
        this.setInfo(info);
        this.setNext(next);
        this.setBack(back);
    }

    public Node(T info, Node<T> next) {
        this.setInfo(info);
        this.setNext(next);
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

    public Node<T> getBack() {
        return back;
    }

    public void setBack(Node<T> back) {
        this.back = back;
    }
}
