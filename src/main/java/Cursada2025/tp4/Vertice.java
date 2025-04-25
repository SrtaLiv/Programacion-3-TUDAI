package Cursada2025.tp4;

import java.util.ArrayList;

public class Vertice<T>{
    private int id;
    private ArrayList<Integer> adyacentes;
    private T etiqueta;

    public Vertice(int id, T etiqueta) {
        this.id = id;
        this.adyacentes = new ArrayList<>();
        this.etiqueta = etiqueta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Vertice> getAdyacentes() {
        return adyacentes;
    }

    public void setAdyacentes(ArrayList<Vertice> adyacentes) {
        this.adyacentes = adyacentes;
    }

    public T getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(T etiqueta) {
        this.etiqueta = etiqueta;
    }
}