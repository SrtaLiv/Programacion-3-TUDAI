package practico4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

//puedo hacer los get y set de mis vertices?
public class GrafoDirigidoHASH<T> implements Grafo<T> {
    private HashMap<Integer, HashSet<Arco<T>>> vertices;
    public GrafoDirigidoHASH(){
        this.vertices = new HashMap<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        this.vertices.put(verticeId, new HashSet<>());
    }

    @Override
    public void borrarVertice(int verticeId) {
        this.vertices.remove(verticeId);
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {

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
        Iterator<Arco<T>> arcoIterator = this.obtenerArcos(verticeId);

        if (this.vertices.containsKey(verticeId)){
            HashSet<Integer> verticesAdyacentes = new HashSet<>();
            while (obtenerArcos().hasNext()){
                verticesAdyacentes.add(obtenerArcos().next().getVerticeDestino());

                return verticesAdyacentes.iterator();
            }
            return null;
        }
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