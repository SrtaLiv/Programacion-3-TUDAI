package Cursada2025.tp6;

import Cursada2025.tp4.Grafo;
import Cursada2025.tp4.Vertice;

import java.util.ArrayList;
import java.util.Iterator;

public class Ej8 {
    /*+
    Ejercicio 8
Coloreo de un grafo. Dado un grafo se desea colorear cada uno de sus vértices utilizando la menor
cantidad posible de colores totales, sabiendo que dos vértices adyacentes no podrán utilizar el
mismo color
     */

    ArrayList<String> colors;
    public void colorearGrafo(Grafo grafo){
        ArrayList<Vertice> verticesList = new ArrayList<>();
        Iterator<Vertice> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()){
            Vertice vv = vertices.next();
            verticesList.add(vv);
            vv.setColor("Blanco");
        }
        greedy(grafo, verticesList);
    }

    private void greedy(Grafo gr, ArrayList<Vertice> vertices){
        // Mientras haya vértices sin colorear (en la lista)
        while (!vertices.isEmpty()){
            Vertice actual = vertices.getFirst();
            Iterator<Vertice> ady = gr.obtenerAdyacentes(actual.getId());

            // Buscamos un color válido para el vértice actual
            String color = buscarColor(ady, this.colors);

            // Asignamos el color encontrado al vértice
            actual.setColor(color);
            vertices.removeFirst();
        }
    }

    private String buscarColor(Iterator<Vertice> ady, ArrayList<String> colors){
        // Para cada color disponible en la lista de colores
        for (String color : colors){
            boolean valido = true;

            // Recorremos los adyacentes para ver si alguno tiene ese color
            while (ady.hasNext()){
                if (ady.next().getColor().equals(color)){
                    valido = false;
                    break;
                }
            }
            if (valido){
                // Si ningún adyacente tiene ese color, lo devolvemos para usarlo
                return color;
            }
        }
        return null;
    }

}
