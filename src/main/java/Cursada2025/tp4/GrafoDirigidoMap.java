package Cursada2025.tp4;

import java.util.*;

public class GrafoDirigidoMap<T> implements Grafo<T> {

    // Cada vértice tiene una lista de arcos salientes
    private Map<Integer, List<Arco<T>>> adyacencias;

    public GrafoDirigidoMap() {
        this.adyacencias = new HashMap<>();
    }



    @Override
    public void agregarVertice(int verticeId) {
        adyacencias.putIfAbsent(verticeId, new ArrayList<>());
    }

    @Override
    public void borrarVertice(int verticeId) {
        if (adyacencias.containsKey(verticeId)) {
            adyacencias.remove(verticeId); // Borra los arcos salientes

            // Borra todos los arcos que tenían como destino verticeId
            for (List<Arco<T>> lista : adyacencias.values()) {
                lista.removeIf(arco -> arco.getVerticeDestino() == verticeId);
            }
        }
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if (adyacencias.containsKey(verticeId1) && adyacencias.containsKey(verticeId2)) {
            Arco<T> arco = new Arco<>(verticeId1, verticeId2, etiqueta);
            adyacencias.get(verticeId1).add(arco);
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        if (adyacencias.containsKey(verticeId1)) {
            adyacencias.get(verticeId1).removeIf(arco -> arco.getVerticeDestino() == verticeId2);
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return adyacencias.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        if (adyacencias.containsKey(verticeId1)) {
            for (Arco<T> arco : adyacencias.get(verticeId1)) {
                if (arco.getVerticeDestino() == verticeId2) return true;
            }
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if (adyacencias.containsKey(verticeId1)) {
            for (Arco<T> arco : adyacencias.get(verticeId1)) {
                if (arco.getVerticeDestino() == verticeId2) return arco;
            }
        }
        return null;
    }

    @Override
    public int cantidadVertices() {
        return adyacencias.size();
    }

    @Override
    public int cantidadArcos() {
        int count = 0;
        for (List<Arco<T>> lista : adyacencias.values()) {
            count += lista.size();
        }
        return count;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return adyacencias.keySet().iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        List<Integer> lista = new ArrayList<>();
        if (adyacencias.containsKey(verticeId)) {
            for (Arco<T> arco : adyacencias.get(verticeId)) {
                lista.add(arco.getVerticeDestino());
            }
        }
        return lista.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        List<Arco<T>> todos = new ArrayList<>();
        for (List<Arco<T>> lista : adyacencias.values()) {
            todos.addAll(lista);
        }
        return todos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        if (adyacencias.containsKey(verticeId)) {
            return adyacencias.get(verticeId).iterator();
        }
        return Collections.emptyIterator();
    }
}
