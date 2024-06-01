package practico5_backtracking.ej1;

import java.util.ArrayList;
import java.util.Iterator;

public class ej1 {
    /*
    Ejercicio 1
    Se tiene un conjunto de salas comunicadas entre sí a través de puertas que se abren solamente en
    un sentido. Una de las salas se denomina entrada y la otra salida. Construir un algoritmo que
    permita ir desde la entrada a la salida atravesando la máxima cantidad de salas. Idea: podría
    representar el problema mediante un grafo dirigido, donde cada nodo es una habitación, y cada
    puerta es un arco dirigido hacia otra habitación.
     */


    ArrayList<Sala> salas = new ArrayList<>();

    public ej1() {
        this.salas = new ArrayList<>();
    }

    public void addSala(int vertice){
        Sala sala = new Sala(vertice);
        if (!salas.contains(sala)){
            sala.puertasAdyacentes = new ArrayList<>();
            salas.add(sala);
        }
        else System.out.println("Ya existe esa sala");
    }

    public void removeSala(int vertice){
        Sala sala = salas.get(vertice);
        sala.getPuertasAdyacentes();
        salas.remove(sala);
    }

    public void removePuertas(int sala){
        Sala salaPorEliminar = salas.get(sala);
        ArrayList<Sala> salasAdyacentes = salasAdyacentes(sala); //a cada sala adyacnete le quito la puerta

        for (Sala salAdy : salasAdyacentes) {
            Integer salaId = salAdy.getId();
            if (hayPuerta(sala, salaId)){
                Puerta puerta = obtenerPuerta(sala, salaId);

                salAdy.removePuerta(puerta); //eliminada del adyacente
                salaPorEliminar.removePuerta(puerta); //eliminada de mi sala
            }
        }
    }

    public Puerta obtenerPuerta(int salaOrigen, int salaDestino){ //OBTIENE PUERTA ENTRE 2 SALAS
        //recorre todas las puertas hasta coincidir con la de sala destino
        ArrayList<Puerta> puertasDelOrigen = salas.get(salaOrigen).getPuertasAdyacentes();
        Iterator<Puerta> it = puertasDelOrigen.iterator();

        while (it.hasNext()){
            Puerta p1 = it.next();
            if (hayPuerta(salaOrigen, salaDestino)) {
                return p1;
            }
        }
        return null;
    }

    public boolean hayPuerta(int salaOrigen, int salaDestino){
        Iterator<Puerta> puertaIterator = obtenerPuertas(salaOrigen);
        while (puertaIterator.hasNext()){
            Puerta ady = puertaIterator.next();
            if (ady.getDestino() == salaDestino){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Sala> salasAdyacentes(int vertice) {
        ArrayList<Sala> adyacentes = new ArrayList<>();
        Iterator<Sala> it = obtenerTodasLasSalas();

        while(it.hasNext()){
            Sala ady = it.next();
            adyacentes.add(ady);
        }

        return adyacentes;
    }

    public Iterator<Sala> obtenerTodasLasSalas(){
        return salas.iterator();
    }

    public Iterator<Puerta> obtenerPuertas(int vertice){
        return salas.get(vertice).getPuertasAdyacentes().iterator();
    }

    public void addPuerta(int indiceOrigen, int destino, T etiqueta) {
        Puerta p1 = new Puerta(indiceOrigen, destino, etiqueta);
        salas.get(indiceOrigen).addPuerta(p1);
    }



    public class Sala{
        private ArrayList<Puerta> puertasAdyacentes; //lista de arcos
        private int id;
        public Sala(int id) {
            this.id = id;
            this.puertasAdyacentes = new ArrayList<>();
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

    public class Puerta{
        private int origen;
        private int destino;
        private T etiqueta;

        public Puerta(int origen, int destino, T etiqueta) {
            this.origen = origen;
            this.destino = destino;
            this.etiqueta = etiqueta;
        }

        public int getOrigen() {
            return origen;
        }

        public void setOrigen(int origen) {
            this.origen = origen;
        }

        public int getDestino() {
            return destino;
        }

        public void setDestino(int destino) {
            this.destino = destino;
        }

        public T getEtiqueta() {
            return etiqueta;
        }

        public void setEtiqueta(T etiqueta) {
            this.etiqueta = etiqueta;
        }
    }
}
