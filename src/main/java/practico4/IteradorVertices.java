package practico4;

import java.util.ArrayList;
import java.util.Iterator;

public class IteradorVertices implements Iterator<Integer> {
    private ArrayList<GrafoDirigido.Vertice> vertices;
    private int indiceActual;
    @Override
    public boolean hasNext() {
        return indiceActual < vertices.size();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        return vertices.get(indiceActual++).id;
    }

}
