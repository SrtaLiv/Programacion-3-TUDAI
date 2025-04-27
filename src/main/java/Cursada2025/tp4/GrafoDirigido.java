package Cursada2025.tp4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GrafoDirigido<T> implements Grafo<T> {
    // LISTA DE ADYACENCIA
    // relacione cada ID de vértice con su lista de adyacencia
    private List<Vertice<T>> vertices; // guardamos los id, no el Vertice?
   // private List<Arco<T>> adyacentes;

    public GrafoDirigido() {
        this.vertices = new ArrayList<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        Vertice<T> v = new Vertice<>(verticeId);
        if (!vertices.contains(verticeId)) // o(n)
            vertices.add(v);
    }

    @Override
    public void borrarVertice(int verticeId) {
        // buscar su adyacente y ssacar arcos que apunten tambien
        Vertice<T> v = vertices.get(verticeId);
        // y borrar arco
        for (Arco<T> arc : v.getAdyacentes()){
            borrarArco(verticeId, arc.getVerticeDestino());
            borrarArco(arc.getVerticeDestino(), verticeId);
        }
        vertices.remove(v);
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
        if (existeArco(verticeId1, verticeId2)){
            vertices.get(verticeId1).getAdyacentes().remove(verticeId2);
            vertices.get(verticeId2).getAdyacentes().remove(verticeId1);
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) { // o(n)
        for (Vertice<T> vertice: vertices) {
            if (vertice.getId() == verticeId){
                return true;
            }
        }
        return false;
    }

    //O(n) cuadrado
    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        // si existe el vertice
        if (contieneVertice(verticeId1) && contieneVertice(verticeId2)) {
            Vertice<T> v1 = vertices.get(verticeId1); // si tiene de adyacente a v2 hay arco

            // si son adyacentes, deberia preguntar si existe arco desde verticeId1 a verticeId2 o al reves?
            // o si existe arco entre ambos sin importar el orden de direccion?(eso pal gnd)
            return v1.esAdyacente(verticeId2);
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if (existeArco(verticeId1, verticeId2)){
            return vertices.get(verticeId1).getAdyacentes().get(verticeId2);
        }
        return null;
    }

    @Override
    public int cantidadVertices() {
        return vertices.size();
    }

    @Override
    public int cantidadArcos() {
        int count = 0;
        for (Vertice<T> v : vertices){
            count += v.getAdyacentes().size();
        }
        return count;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        List<Integer> result = new ArrayList<>();

        for (Vertice v : vertices)
            result.add(v.getId());

        return result.iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        ArrayList<Integer> adyacentesIds = new ArrayList<>();
        for (Arco<T> arco : vertices.get(verticeId).getAdyacentes()) {
            adyacentesIds.add(arco.getVerticeDestino());
        }
        return adyacentesIds.iterator();
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
