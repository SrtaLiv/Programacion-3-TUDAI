package practico4.grafosHash;

import javafx.scene.shape.Arc;

import java.util.*;

public class GrafoDirigidoHASH<T> implements Grafo<T> {

    private Hashtable<Integer, HashSet<Arco<T>>> vertices;
    private ArrayList<Integer> visitados;

    public GrafoDirigidoHASH() {
        vertices = new Hashtable<>();
        visitados = new ArrayList<>();
    }


    @Override
    public void agregarVertice(int verticeId) {
        vertices.putIfAbsent(verticeId, new HashSet<>()); //solo agrega el vertice si no existe
    }

    @Override
    public void borrarVertice(int verticeId) {
        if (vertices.containsKey(verticeId)) {
            vertices.remove(verticeId);
            for (HashSet<Arco<T>> arcos : vertices.values()) {
                arcos.removeIf(arco -> arco.getVerticeDestino() == verticeId);
            }
        }
    }
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        //if (vertices.get(verticeId1) != null && vertices.get(verticeId1) != null){
        if (vertices.containsKey(verticeId1) && vertices.containsKey(verticeId1)){

            Arco<T> arcoCreado = new Arco(verticeId1, verticeId2, etiqueta);

            //Agrego Clave - Valor
            vertices.get(verticeId1).add(arcoCreado); //Crear un arco para el verticeId 1
        }
    }

    @Override //vertice1.getDestino == verticeId2 si mi vertice tiene de destino v2 lo borro
    public void borrarArco(int verticeId1, int verticeId2) {
       if (vertices.containsKey(verticeId1)){
           Iterator<Arco<T>> arcosV1 = obtenerArcos(verticeId1);
           while (arcosV1.hasNext()){
               Arco<T> arcoSiguiente = arcosV1.next();
               if (arcoSiguiente.getVerticeDestino() == verticeId2){
                   arcosV1.remove();
               }
           }
       }
    }
    @Override
    public boolean contieneVertice(int verticeId) {
        return vertices.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
//        HashSet<Arco<T>> arcosV1 = vertices.get(verticeId1);
        if (vertices.containsKey(verticeId1)) {
            Iterator<Arco<T>> arcosV1 = obtenerArcos(verticeId1);
            while (arcosV1.hasNext()) {
                Arco<T> arcoSiguiente = arcosV1.next();
                if (arcoSiguiente.getVerticeDestino() == verticeId2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
       if (vertices.containsKey(verticeId1)){
           for (Arco<T> arco : vertices.get(verticeId1)){
               if (arco.getVerticeDestino() == verticeId2){
                   return arco;
               }
           }
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
        for (HashSet<Arco<T>> arcos : vertices.values()) {
            count += arcos.size();
        }
        return count;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return vertices.keySet().iterator(); //Iterador de las claves, es decir los vertices.
    }

    @Override //necesito encontrar todos los vertice.getVerticeDestino
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        if (vertices.containsKey(verticeId)){
            HashSet<Integer> adyacentes = new HashSet<>(); //Inicializo donde se guardaran los vertices Adyacentes.

            for (Arco<T> arco : vertices.get(verticeId)){ //Recorro arcos del vertice id
                adyacentes.add(arco.getVerticeDestino()); //Agrego los destinos de mi vertice
            }
        return adyacentes.iterator();
        }
    return null;
        //return Collections.emptyIterator(); 2da alternativa
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        HashSet<Arco<T>> todosArcos = new HashSet<>();
        for (HashSet<Arco<T>> arcos : vertices.values()) {
            todosArcos.addAll(arcos);
        }
        return todosArcos.iterator();
    }

@Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        HashSet<Arco<T>> arcosV1 = vertices.get(verticeId);

        if (vertices.containsKey(verticeId)) {
            return vertices.get(verticeId).iterator();
        }
        return Collections.emptyIterator();
    }

    //EJERCICIO 4:
    public ArrayList<Integer> caminoMayor(int origen, int destino) {
        ArrayList<Integer> caminoMayor = new ArrayList<Integer>();
        this.visitados.add(origen);

        if (origen == destino) {
            caminoMayor.add(origen);
        } else {
            Iterator<Integer> it_ady = this.obtenerAdyacentes(origen);
            while (it_ady.hasNext()) {
                Integer ady = it_ady.next();
                if (!this.visitados.contains(ady)) {
                    ArrayList<Integer> camino = caminoMayor(ady, destino);

                    if (!camino.isEmpty() && (camino.size() >= caminoMayor.size())) {
                        caminoMayor.clear();
                        caminoMayor.add(origen);
                        caminoMayor.addAll(camino);
                    }
                }
            }
        }

        this.visitados.remove(origen);
        return caminoMayor ;
    }

}
