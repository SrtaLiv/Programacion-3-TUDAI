package practico4;

import java.util.Iterator;
import java.util.ArrayList;

public class IteradorArcos<T> implements Iterator<Arco<T>> {
    private ArrayList<Arco<T>> arcos;
    private int indiceActual;

    public IteradorArcos() {
        this.arcos = arcos;
        this.indiceActual = 0;
    }

    @Override
    public boolean hasNext() {
        return indiceActual < arcos.size();
    }

    @Override
    public Arco<T> next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        return arcos.get(indiceActual++);
    }
}
