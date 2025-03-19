package tp1;

public class MyIterator<T> implements java.util.Iterator<T> {
    // un iterador pregunta si hay un siguiente y si lo hay devuelve ese sig

    private Node<T> cursor;

    public MyIterator(Node<T> cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean hasNext() {
        return cursor != null;
    }

    @Override
    public T next() { // por que debe devolver un T y no un NODE
        T info = cursor.getInfo(); // Captura la info del cursor
        cursor = cursor.getNext(); // Pasa al siguiente
        return info;
    }

}
