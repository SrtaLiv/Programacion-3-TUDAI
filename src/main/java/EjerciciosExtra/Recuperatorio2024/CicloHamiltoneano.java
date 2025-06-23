package EjerciciosExtra.Recuperatorio2024;

import Cursada2025.tp4.GrafoNoDirigido;
import Cursada2025.tp4.Vertice;

import java.util.ArrayList;
import java.util.Iterator;

public class CicloHamiltoneano {
    ArrayList<Integer> visitados;
    ArrayList<Integer> mejorSolucion;
    public void obtenerVertices(GrafoNoDirigido gr){
        visitados.clear();
        mejorSolucion.clear();

        for (Integer v : gr.obtenerVertices()) {
            visitados.add(v);
            dfs(gr, v, v);
            visitados.removeLast();
        }
    }

    private void dfs(GrafoNoDirigido gr, Integer actual, Integer inicio){
        if (visitados.size() == gr.cantidadVertices()){
            if (gr.existeArco(actual, inicio)){ // verificar que es un ciclo
                if (obtenerMayorPeso(gr, mejorSolucion) < obtenerMayorPeso(gr, visitados)){
                    mejorSolucion = new ArrayList<>(visitados);
                }
            }
            return;
        }
        else{
            Iterator<Integer> adyacentes = gr.obtenerAdyacentes(actual);
            while (adyacentes.hasNext()){
                Integer sig = adyacentes.next();
                if (!visitados.contains(sig)){
                    visitados.add(sig);
                    dfs(gr, sig, inicio);
                    visitados.removeLast();
                }
            }
        }
    }

    public int obtenerMayorPeso(GrafoNoDirigido gr, ArrayList<Integer> list){
        int suma = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            Arco a = gr.obtenerArco(list.get(i), list.get(i + 1));
            suma += a.getPeso();
        }
        return suma;
    }
}
