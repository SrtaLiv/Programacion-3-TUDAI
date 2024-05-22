package practico4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class GrafoDirigidoHASH<T> implements Grafo<T> {
    private HashMap<Integer, HashSet<Arco<T>>> vertices;
    public GrafoDirigidoHASH(){
        this.vertices = new HashMap<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if (!this.vertices.containsKey(verticeId)){ //Si no cintiene la clave..
            this.vertices.put(verticeId, new HashSet<>());
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        if (this.vertices.containsKey(verticeId)) {
            // Eliminar los arcos entrantes
            for (HashSet<Arco<T>> arcos : this.vertices.values()) {
                arcos.removeIf(arco -> arco.getVerticeDestino() == verticeId);
            }
            // Eliminar el vértice
            this.vertices.remove(verticeId);
        }
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        agregarVertice(verticeId1);
        agregarVertice(verticeId1);
        this.vertices.get(verticeId1).add(new Arco<>(verticeId1, verticeId1, etiqueta));
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        this.vertices.get(verticeId1);

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
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
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