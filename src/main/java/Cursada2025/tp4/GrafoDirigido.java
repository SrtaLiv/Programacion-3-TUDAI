package Cursada2025.tp4;

import Cursada2025.tp1.MySimpleLinkedList;

import java.util.ArrayList;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
    // LISTA DE ADYACENCIA
    private ArrayList<Integer> vertices; // guardamos los id, no el Vertice?
    private MySimpleLinkedList<Arco> listaDeAdyacentes;

    @Override
    public void agregarVertice(int verticeId) {
        vertices.add(verticeId);
    }

    @Override
    public void borrarVertice(int verticeId) {
        // buscar su adyacente y ssacar arcos que apunten tambien
        vertices.remove(verticeId);
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        Arco<T> arco = new Arco<>();
        arco.setVerticeOrigen(verticeId1);
        arco.setVerticeDestino(verticeId2);
        arco.setEtiqueta(etiqueta);
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
        int i = vertices.get(verticeId1); // si tiene de adyacente a v2 hay arco
        // if vertice . getVerticeDestino() == verticeId2 hay arco
        if (){

        }
        return false;
    }

    @Override
    public Arco obtenerArco(int verticeId1, int verticeId2) {

        return null;
    }

    @Override
    public int cantidadVertices() {
        return vertices.size();
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
