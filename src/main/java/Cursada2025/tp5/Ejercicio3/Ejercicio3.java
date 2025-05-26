package Cursada2025.tp5.Ejercicio3;

import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio3 {

    // MAL :C MI SOLUCION ENCUNETRA TODOS LOS SUBCONJUNTOS, Y PIDE
    // HACER 1 PARTICION.

    ArrayList<Integer> visitados = new ArrayList<>();
    ArrayList<ArrayList<Integer>> soluciones = new ArrayList<>();

    public ArrayList<Integer> getVisitados() {
        return visitados;
    }

    public void setVisitados(ArrayList<Integer> visitados) {
        this.visitados = visitados;
    }

    public ArrayList<ArrayList<Integer>> getSoluciones() {
        return soluciones;
    }

    public void setSoluciones(ArrayList<ArrayList<Integer>> soluciones) {
        this.soluciones = soluciones;
    }

    public void recorrer(ArrayList<Integer> conjunto, int m){

        for (int i = 0; i < conjunto.size(); i++){
            visitados.clear();
            recorrerPrivado(conjunto, m, conjunto.get(i), 0);
        }

        // Mostrar soluciones
        for (ArrayList<Integer> s : soluciones) {
            System.out.println(s);
        }
    }

    private void recorrerPrivado(ArrayList<Integer> conjunto, int m, int actual,
                                 int contador){
        contador += actual;

        if (contador > m){
            return;
        }

        if (contador == m){ // si es solucion
            visitados.add(actual);
            if (compararListas(conjunto, visitados)){
                return;
            }
            else {
                soluciones.add(new ArrayList<>(visitados));
            }
            return;
            // if el conjunto ya esta en solucion break
            //else lo agrego a mis soluciones
        }
        else if (!visitados.contains(actual)){
            visitados.add(actual);

            int indice = conjunto.indexOf(actual); // busca el indice

            if (indice < conjunto.size()-1){ // recorro hasta el ultimo
                int siguiente = conjunto.get(indice+1); // obtiene el valor dle siguiente indice
                recorrerPrivado(conjunto, m, siguiente, contador);
            }

            visitados.remove((Integer) actual);
        }
    }

    public boolean compararListas(ArrayList<Integer> sol1, ArrayList<Integer> sol2){
        Collections.sort(sol1);
        Collections.sort(sol2);
        return sol1.equals(sol2);
    }

    public static void main(String[] args) {
        Ejercicio3 ej = new Ejercicio3();

        ArrayList<Integer> conjunto = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            conjunto.add(i);
        }

        int m = 5; // valor de prueba
        ej.recorrer(conjunto, m);
    }
}
