package practico6_greedy.ej4;

import java.util.ArrayList;

public class Grafo {
    //ArrayList<Vertice>
    ArrayList<Integer> vertices = new ArrayList<>();

    public void addVertice(int i){
        //crear arcos tamb
        if (!vertices.contains(i)){
            vertices.add(i);
        }
    }

    public ArrayList<Integer> obtenerVertices(){
        ArrayList<Integer> vertices = new ArrayList<>(this.vertices);
        return vertices;
    }


}
