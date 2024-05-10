package practico4;

import java.util.Iterator;

public class GrafoDirigidoMatriz<T> implements Grafo<T> {
    //Matriz de Adyacencia
    int vertices = this.cantidadVertices();
    int[][] matrizAdyacencia = new int[vertices][vertices];

    public GrafoDirigidoMatriz() {

    }

    /** los arcos de un grafo G=(V,A) se representan como elementos de una matriz de
     * n x n, donde n es |V| (la cardinalidad de V, o sea la cantidad de vértices del conjunto V).
     *
     * Para un grafo no ponderado, el valor (i,j) de la matriz será 1 (o verdadero) si el arco (i,j) pertenece a A. Si el
     * arco no pertenece, el valor será 0 (o falso).
     *
     * Si el grafo es ponderado, se sustituyen los 1 por el valor de los rótulos y los 0 (o sea cuando no hay arco) por
     * un valor especial (∞, o un valor que no tenga sentido para nuestro problema).
     *
     * Cuando el grafo en no dirigido: si existe la arista (i,j) entonces también existe la (j,i).
     *
     * */

    public void imprimirMatriz(){
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = 0; j < matrizAdyacencia[i].length; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }


    @Override
    public void agregarVertice(int verticeId) {
        vertices++;
        for (int i = 0; i < vertices; i++){
            matrizAdyacencia[i][vertices-1] = 0;
            matrizAdyacencia[vertices-1][i] = 0;
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        this.obtenerArcos(); //Lista de mis arcos
        this.obtenerVertices(); //Lista de mis vertices

        this.borrarVertice(verticeId);
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {

    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        if (this.matrizAdyacencia != null){
            for (int i = 0; i < cantidadVertices(); i++){
                if (matrizAdyacencia[i][i] == 1){
                    System.out.println("Existe arco");
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int cantidadVertices() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int cantidadArcos() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
        return null;
    }
}