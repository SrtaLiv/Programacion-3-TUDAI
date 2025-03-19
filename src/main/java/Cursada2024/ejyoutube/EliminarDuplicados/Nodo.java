package ejyoutube.EliminarDuplicados;

public class Nodo<T>{
    Nodo<T> next;
    T info;

    public Nodo(Nodo<T> next, T info) {
        setNext(next);
        setInfo(info);
    }

    public Nodo() {
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
