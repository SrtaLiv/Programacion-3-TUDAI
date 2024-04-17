package ejyoutube.EliminarDuplicados;

import java.util.Iterator;

public class MyIterador<T> implements Iterator {
    Nodo<T> cursor;

    public MyIterador(Nodo<T> cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean hasNext() {
        return cursor!=null;
    }

    @Override
    public T next() {
        T info = cursor.getInfo();
        cursor = cursor.getNext();
        return info;
    }
}
