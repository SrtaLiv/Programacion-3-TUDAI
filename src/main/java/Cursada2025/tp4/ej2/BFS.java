package Cursada2025.tp4.ej2;

import Cursada2025.tp4.GrafoDirigido;
import com.sun.source.tree.WhileLoopTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;

public class BFS<T> {
    private Queue<Integer> cola;
    //ArrayList<Integer> visitados; -> no eficiente
    //HashSet guarda oslo claves
    HashSet<Integer> visitados;
    // si lo hiciera con hashmap, guardaria integer y boolean d no visitado ejemplo.
    // hacer bfs
    public void BFS(GrafoDirigido<T> gr){
        cola.clear();
        Iterator<Integer> it = gr.obtenerVertices();

        // no esta visitado
        visitados = new HashSet<>();

        while (it.hasNext()){
            if (!visitados.contains(it.next())){ // si no es visitado
                recorrerBFS(gr, it.next());
                cola.clear();

            }
        }
    }

    private void recorrerBFS(GrafoDirigido<T> gr, Integer next) {
        visitados.add(next); // visito el vetice
        cola.add(next);

        while (!cola.isEmpty()){
            Iterator<Integer> ady = gr.obtenerAdyacentes(next);
            while (ady.hasNext()){
                if (!visitados.contains(ady.next())){ // si el ady no esta visitado
                    visitados.add(ady.next());
                    cola.add(ady.next());
                }
            }
            // tomamos vertice X de la fila
        }
    }

}
