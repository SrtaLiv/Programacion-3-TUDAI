package Cursada2025.tp4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GrafoDirigidoMap<T> implements Grafo<T> {
    private HashMap<Integer, Arco<T>> vertices; // guardamos los id, no el Vertice?

    public GrafoDirigidoMap(HashMap<Integer, Arco<T>> vertices) {
        this.vertices = vertices;
    }

    public HashMap<Integer, Arco<T>> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertice<T>> vertices) {
        this.vertices = vertices;
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
        if (contieneVertice(verticeId)){
            Vertice<T> v = vertices.get(verticeId);

            // y borrar arco
            Iterator<Integer> adyacentes = obtenerAdyacentes(verticeId);
            while (adyacentes.hasNext()){
                borrarArco(verticeId, adyacentes.next());
                borrarArco(adyacentes.next(), verticeId);
            }
            vertices.remove(v);
        }
        else{
            System.out.println("No se encontro el vertice");
        }
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
        ArrayList<Arco<T>> arcos = new ArrayList<>();

        for (Vertice<T> v : vertices){
            arcos.addAll(v.getAdyacentes());
        }
        return arcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        return vertices.get(verticeId).getAdyacentes().iterator();
    }
}
