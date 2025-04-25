package Cursada2024.practico5_backtracking.ej1;

import java.util.ArrayList;
import java.util.Iterator;


public class GrafoDirigido {
    /*
    Ejercicio 1
    Se tiene un conjunto de salas comunicadas entre sí a través de puertas que se abren solamente en
    un sentido. Una de las salas se denomina entrada y la otra salida. Construir un algoritmo que
    permita ir desde la entrada a la salida atravesando la máxima cantidad de salas. Idea: podría
    representar el problema mediante un grafo dirigido, donde cada nodo es una habitación, y cada
    puerta es un arco dirigido hacia otra habitación.
     */

    ArrayList<Integer> visitados = new ArrayList<>();
    ArrayList<Integer> caminoMayor = new ArrayList<>();

    ArrayList<Sala> salas = new ArrayList<>();

    public GrafoDirigido() {
        this.salas = new ArrayList<>();
    }

    public ArrayList<Integer> backtracking(int entrada, int salida){
        this.visitados.clear();
        this.caminoMayor.clear();

        //Configurar estado inicial
        ArrayList<Integer> caminoParcial = new ArrayList<Integer>();
        caminoParcial.add(entrada);
        visitados.add(entrada);

        this.caminoMayorBack(entrada, salida, caminoParcial);

        return this.caminoMayor;
    }

    private void caminoMayorBack(int entrada, int salida, ArrayList<Integer> caminoParcial){
        if (entrada == salida){ //ya se recorrio todo el camino parcial
            if (caminoParcial.size() >= caminoMayor.size()){
                caminoMayor.clear();
                caminoMayor.addAll(caminoParcial);
            }
        }
        else {
            Iterator<Integer> it = this.obtenerSalasAdyacentes(entrada);
            while (it.hasNext()){
                Integer ady = it.next();

                if (!visitados.contains(ady)){
                    caminoParcial.add(ady);
                    this.visitados.add(ady);
                    caminoMayorBack(ady, salida, caminoParcial);

                    caminoParcial.remove(ady);
                    this.visitados.remove(ady);
                }
            }
        }
    }

    public void addSala(int vertice){
        Sala sala = new Sala(vertice);
        if (!salas.contains(sala)){
            salas.add(sala);
        }
        else System.out.println("Ya existe esa sala");
    }

    public void removeSala(int vertice){
        Sala sala = salas.get(vertice);
        removePuertas(vertice);
        salas.remove(sala);
    }

    public void removePuertas(int sala){
        Sala salaPorEliminar = salas.get(sala);
        Iterator<Integer> salasAdyacentes = obtenerSalasAdyacentes(sala); //a cada sala adyacnete le quito la puerta

        while (salasAdyacentes.hasNext()){
            Integer salAdy = salasAdyacentes.next();
            if (hayPuerta(sala, salAdy)){
                Puerta puerta = obtenerPuerta(sala, salAdy);

               salaPorEliminar.removePuerta(puerta);
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

    public Iterator<Integer> obtenerSalasAdyacentes(int vertice) {
        ArrayList<Integer> adyacentes = new ArrayList<>();

        Iterator<Puerta> itPuertas = obtenerPuertas(vertice);

        while(itPuertas.hasNext()){
            Puerta arco = itPuertas.next();
            Integer ady = arco.getDestino();
            adyacentes.add(ady);
        }
        return adyacentes.iterator();
    }

    public Iterator<Integer> obtenerTodasLasSalas(){
        ArrayList<Integer> idSalas = new ArrayList<>();
        for (Sala s:salas) {
            idSalas.add(s.getId());
        }
        return idSalas.iterator();
    }

    public Iterator<Puerta> obtenerPuertas(int vertice){
        return salas.get(vertice).getPuertasAdyacentes().iterator();
    }

    public void addPuerta(int indiceOrigen, int destino, String etiqueta) {
        Puerta p1 = new Puerta(indiceOrigen, destino, etiqueta);
        salas.get(indiceOrigen).addPuerta(p1);
    }






}
