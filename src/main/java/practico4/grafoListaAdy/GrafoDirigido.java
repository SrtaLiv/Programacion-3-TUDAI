package practico4.grafoListaAdy;

import java.util.ArrayList;
import java.util.Iterator;

//puedo hacer los get y set de mis vertices?
public class GrafoDirigido<T> implements Grafo<T> {
    //GRAFO DIRIGIDO CON LISTA DE ADYACENCIA
    private ArrayList<Vertice> vertices; //Para mejorarlo podria ser una lista de nodos
    //La ventaja de la lista de nodos es q no debes conocer la cantidad de vertices previamente

    //Arcos?
    public GrafoDirigido() {
        vertices = new ArrayList<>();
    }

    public class Vertice {
        public Vertice() {
            this.id = getId();
            this.adyacentes = new ArrayList<>();
        }

        protected boolean visitado;
        protected int id;
        protected ArrayList<Arco<T>> adyacentes; //Vertices o arcos?

        public boolean isVisitado() {
            return visitado;
        }

        public void setVisitado(boolean visitado) {
            this.visitado = visitado;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public ArrayList<Arco<T>> getAdyacentes() {
            return adyacentes;
        }

        public void setAdyacentes(ArrayList<Arco<T>> adyacentes) {
            this.adyacentes = adyacentes;
        }

    }

    public ArrayList<Vertice> getVertices() {
        return new ArrayList<>(vertices);
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    //Un vertice necesita Arcos-relaciones
    @Override
    public void agregarVertice(int verticeId) {
        Vertice v = new Vertice();
        v.id = verticeId;
        v.adyacentes = new ArrayList<>();
        vertices.add(v);
    }

    //Elimino el arco, luego selecciono mis Arcos o busco mi Adyacente?
    @Override
    public void borrarVertice(int verticeId) {
        if (vertices != null && verticeId >= 0) {
            Vertice verticeAEliminar = vertices.get(verticeId);
            for (Vertice v : vertices) {
                Iterator<Arco<T>> iteradorArcos = v.adyacentes.iterator();

            }
            vertices.remove(verticeId);

        }
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        Vertice v1 = vertices.get(verticeId1);
        //Vertice v2 = vertices.get(verticeId2);
        Arco<T> nuevoArco = new Arco<>(verticeId1, verticeId2, etiqueta);

        // Desde v1 a v2 (v2 es adyacente a v1)
        v1.adyacentes.add(nuevoArco);
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        //busco adyacentes y arcos.
        if (existeArco(verticeId1, verticeId2)) {
            Arco<T> arcoBorrado = this.obtenerArco(verticeId1, verticeId2);
            Vertice v1 = vertices.get(verticeId1);
            v1.adyacentes.remove(arcoBorrado);
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return vertices.get(verticeId) != null;
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        return obtenerArco(verticeId1, verticeId2) != null;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        Vertice v1 = vertices.get(verticeId1);

        if (v1 != null && v1.getAdyacentes() != null) {
            for (Arco<T> arco : v1.getAdyacentes()) {
                if (arco.getVerticeDestino() == verticeId2) {
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
        int cant = 0;
        for (Vertice vertice : vertices) {
            if (vertice.adyacentes != null) {
                cant += vertice.getAdyacentes().size();
            }
        }
        return cant;
    }


    //no se como hacer este iteraor
    @Override
    public Iterator<Integer> obtenerVertices() {
        ArrayList<Integer> idsVertices = new ArrayList<>();
        for (Vertice v : vertices) {
            idsVertices.add(v.getId());
        }
        return idsVertices.iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        ArrayList<Integer> verticesAdyacentes = new ArrayList<>();

        if (verticeId >= 0 && verticeId < vertices.size()) {
            Vertice v = vertices.get(verticeId);

            if (v.getAdyacentes() != null) {
                for (Arco<T> arco : v.getAdyacentes()) {
                    verticesAdyacentes.add(arco.getVerticeDestino());
                }
            }
        }

        return verticesAdyacentes.iterator();
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