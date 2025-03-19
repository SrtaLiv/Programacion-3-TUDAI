package ejyoutube.EliminarDuplicados;

import java.util.Iterator;

public class ListaVinculada<T> implements Iterable<T> {
    Nodo<T> first;

    public ListaVinculada() {
        this.first = null;
    }

    public void insertFront(T info){
        Nodo<T> tmp = new Nodo<>(null, info);
        tmp.setNext(first);
        this.first = tmp;
    }

    public Nodo<T> getFirst() {
        return first;
    }

    public void setFirst(Nodo<T> first) {
        this.first = first;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterador<T>(this.first);
    }
}
