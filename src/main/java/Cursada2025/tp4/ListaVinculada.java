package Cursada2025.tp4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaVinculada<T> implements Iterable<T> {

    private Nodo<T> primero;

    public ListaVinculada() {
        this.primero = null;
    }

    public void insertarAlInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setSiguiente(primero);
        primero = nuevo;
    }

    public void insertarAlFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public void eliminar(T dato) {
        if (primero == null) return;

        if (primero.getDato().equals(dato)) {
            primero = primero.getSiguiente();
            return;
        }

        Nodo<T> actual = primero;
        while (actual.getSiguiente() != null && !actual.getSiguiente().getDato().equals(dato)) {
            actual = actual.getSiguiente();
        }

        if (actual.getSiguiente() != null) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
        }
    }

    public void imprimir() {
        for (T dato : this) {
            System.out.print(dato + " -> ");
        }
        System.out.println("null");
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorLista();
    }

    private class IteradorLista implements Iterator<T> {
        private Nodo<T> actual = primero;

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T dato = actual.getDato();
            actual = actual.getSiguiente();
            return dato;
        }
    }

    private class Nodo<E> {
        private E dato;
        private Nodo<E> siguiente;

        public Nodo(E dato) {
            this.dato = dato;
            this.siguiente = null;
        }

        public E getDato() {
            return dato;
        }

        public Nodo<E> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }
    }
}
