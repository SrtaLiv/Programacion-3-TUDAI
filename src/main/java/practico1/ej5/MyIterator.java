package practico1.ej5;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {
    Node<T> cursor;

    public MyIterator(Node<T> first) {
        this.cursor = first;
    }

    @Override
    public boolean hasNext() {
        return cursor != null;
    }

    @Override
    public T next() {
        T info = cursor.getInfo();
        cursor = cursor.getNext();
        return info;
    }

    public T get(){
        return cursor.getInfo();
    }

}
