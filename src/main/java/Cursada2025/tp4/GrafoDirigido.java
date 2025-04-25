package Cursada2025.tp4;

import java.util.ArrayList;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
    // LISTA DE ADYACENCIA
    // relacione cada ID de vértice con su lista de adyacencia
    private ArrayList<Vertice<T>> vertices; // guardamos los id, no el Vertice?
    private ListaVinculada<Arco<T>> adyacentes;

    @Override
    public void agregarVertice(int verticeId) {
        Vertice v = new Vertice<>(verticeId, null);
        vertices.add(v);
    }

    @Override
    public void borrarVertice(int verticeId) {
        // buscar su adyacente y ssacar arcos que apunten tambien
        Vertice v = vertices.get(verticeId);
        // y borrar arco
        for (Arco arc : v.getAdyacentes()){
            borrarArco(verticeId, arc.getVerticeDestino());
        }

        vertices.remove(verticeId);

    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        Arco<T> arco = new Arco<>();
        arco.setVerticeOrigen(verticeId1);
        arco.setVerticeDestino(verticeId2);
        arco.setEtiqueta(etiqueta);

        Vertice<T> v1 = vertices.get(verticeId1);
        v1.addAdyacente(arco);
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        vertices.get(verticeId1).getAdyacentes().remove(verticeId2);
    }


    @Override
    public boolean contieneVertice(int verticeId) {
        return false;
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        Vertice<T> v1 = vertices.get(verticeId1); // si tiene de adyacente a v2 hay arco
        Vertice<T> v2 = vertices.get(verticeId2); // si tiene de adyacente a v2 hay arco

       if (v1.getAdyacentes().get(verticeId2) != null ||
               v2.getAdyacentes().get(verticeId1) != null){
           return true;
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
