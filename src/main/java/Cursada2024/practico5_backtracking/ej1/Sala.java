package Cursada2024.practico5_backtracking.ej1;

import java.util.ArrayList;

public class Sala{
    private ArrayList<Puerta> puertasAdyacentes; //lista de arcos
    private int id;

    public Sala(int id) {
        this.puertasAdyacentes = new ArrayList<>();
        this.id = id;
    }

    public void addPuerta(Puerta pp){
        puertasAdyacentes.add(pp);
    }

    public void removePuerta(Puerta pp){
        puertasAdyacentes.remove(pp);
    }

    public ArrayList<Puerta> getPuertasAdyacentes() {
        return puertasAdyacentes;
    }

    public void setPuertasAdyacentes(ArrayList<Puerta> puertasAdyacentes) {
        this.puertasAdyacentes = puertasAdyacentes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
