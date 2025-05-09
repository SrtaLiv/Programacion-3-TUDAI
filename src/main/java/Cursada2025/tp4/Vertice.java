package Cursada2025.tp4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Vertice<T>{

    //if (!vertices.contains(vertieId)) o(n)
    // no es buena opcion tener lista de arcos pq si me piden de Xvertice tendria q recorrer TODOS los arcos

    private int id;
    private ArrayList<Arco<T>> adyacentes;

    public Vertice(int id) {
        this.id = id;
        this.adyacentes = new ArrayList<>();
    }

    public void addAdyacente(Arco arco){
        adyacentes.add(arco);
    }

    // A -> B, B es adyacente de A
    public boolean esAdyacente(int verticeId) {
        for (Arco<T> adyacente : this.getAdyacentes()) {
            if (adyacente.getVerticeDestino() == verticeId) {
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Arco<T>> getAdyacentes() {
        return new ArrayList<>(this.adyacentes);
    }


    public void setAdyacentes() {
        this.adyacentes = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Vertice{" +
                "id=" + id +
                ", adyacentes=" + adyacentes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertice<?> vertice = (Vertice<?>) o;
        return id == vertice.id && Objects.equals(adyacentes, vertice.adyacentes);
    }

}