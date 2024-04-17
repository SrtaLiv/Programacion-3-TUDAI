package practico1.ej6;


import java.util.Iterator;

public class MyIterador<T> implements Iterator<T> {
    Node<T> cursor;

    public MyIterador(Node<T> cursor) {
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
