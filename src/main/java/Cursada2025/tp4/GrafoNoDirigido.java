package Cursada2025.tp4;

import java.util.Iterator;

public class GrafoNoDirigido<T> implements Grafo<T>{
    @Override
    public void agregarVertice(int verticeId) {

    }

    @Override
    public void borrarVertice(int verticeId) {

    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, Object etiqueta) {

    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {

    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return false;
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        return false;
    }

    @Override
    public Arco obtenerArco(int verticeId1, int verticeId2) {
        return null;
    }

    @Override
    public int cantidadVertices() {
        return 0;
    }

    @Override
    public int cantidadArcos() {
        return 0;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return null;
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        return null;
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        return null;
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        return null;
    }
}
