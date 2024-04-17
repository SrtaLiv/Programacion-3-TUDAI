package practico1.ej4;

import java.util.Iterator;

public class MyIterador<T> implements Iterator<T> {
    Node<T> cursor;

    public MyIterador(Node<T> first) {
        this.cursor = first;
    }


    @Override
    public boolean hasNext() { //Define cuando hay un nodo siguiente para recorrer
        return cursor != null;
    }

    @Override
    public T next() { //Devuelve el valor
        T info = cursor.getInfo();
        cursor = cursor.getNext();
        return info;
    }
}
