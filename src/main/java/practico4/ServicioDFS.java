package practico4;

import java.util.*;

public class ServicioDFS {
//METODO ENCARGADO DE VER QUE SE HAYAN PASADO POR TDOSOS LOS VERTICES
//el primer for recorre los vertices y los inicializa en blanco
//el tiempo es opcional
// el segundo for va a llamar a el dfs visitado

    private Hashtable<Integer, String> colores;

    public LinkedList<Integer> DFS(Grafo<?> grafo){
        LinkedList<Integer> resultado = new LinkedList<Integer>();

        colores = new Hashtable<Integer, String>();

        Iterator<Integer> it = grafo.obtenerVertices();
        while (it.hasNext()){
            colores.put(it.next(), "blanco");
        }

        it = grafo.obtenerVertices();
        while (it.hasNext()){
            Integer adyacente = it.next();
            if (colores.get(adyacente) == "blanco"){
                DFS_Visitado(grafo, adyacente, resultado);
            }
        }
    }

    public void dfs(GrafoDirigido<?> grafo) {
        ArrayList<Integer> visitados = new ArrayList<>();
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        if (!visitados.contains(itVertices)) {
            grafo.getVertices();
            DFS_Visitado(vertice);
        }

        return DFS_Visitado();
    }


    //Marcar como visitados
  public boolean DFS_Visitado(GrafoDirigido.Vertice v) {
        boolean recorrido = false;
      return true;
  }
}
