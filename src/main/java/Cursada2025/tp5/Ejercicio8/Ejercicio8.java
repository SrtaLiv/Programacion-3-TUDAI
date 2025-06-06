package Cursada2025.tp5.Ejercicio8;

import Cursada2025.tp5.Ejercicio6.Casillero;

import java.util.ArrayList;

public class Ejercicio8 {
    /**
     * Ejercicio 8
     * Colocar un entero positivo (menor que un cierto valor entero k dado) en cada casilla de una
     * pirámide de base B (valor entero dado) de modo que cada número sea igual a la suma de las
     * casillas sobre las que está apoyado. Los números de todas las casillas deben ser diferentes
     */

    ArrayList<Casillero> camino;
    ArrayList<ArrayList<Casillero>> solucion;

    /*
    public void armarPiramide(ArrayList<ArrayList<Casillero>> piramide, int k, int b){
        // B = tamaño de la base
        // k = límite superior para los números
        int totalCasilleros = b * (b + 1) / 2;
        backtracking(piramide, k, b, totalCasilleros);
    }

   private void backtracking(ArrayList<ArrayList<Casillero>> piramide, int k, int b, int totalCasilleros) {
        // Total = B * (B + 1) / 2

        if (camino.size() == totalCasilleros){ // la base 3 tiene 12 elementos
            piramde = construirPiramide(camino, b);
            if (sumaK(piramide)) { // sumaK(...) verifica si la suma de cada fila da ≤ k , y da true.
                solucion.add(new ArrayList<>(camino));
            }
        }
        else{
            for (int i = 0; i < k; i++){
                if (!camino.contains(i)){
                    camino.add(i);

                    if (esValido(camino, b)) {
                        backtracking(piramide, k, b, totalCasilleros);
                    }

                    camino.removeLast(); // backtrack
                }
            }

        }
    }

    private boolean esValido(ArrayList<Integer> camino, int baseSize) {
        int index = camino.size() - 1;

        // Convertir la lista lineal a coordenadas de nivel y posición
        int nivel = 0;
        int acumulado = 0;

        while (acumulado + (baseSize - nivel) <= index) {
            acumulado += (baseSize - nivel);
            nivel++;
        }

        // Si estamos en un nivel superior a la base y no en la punta
        if (nivel < baseSize - 1) {
            int posEnNivel = index - acumulado;
            int indexAbajoIzq = acumulado + (baseSize - nivel) + posEnNivel;
            int indexAbajoDer = indexAbajoIzq + 1;

            if (indexAbajoIzq >= camino.size() || indexAbajoDer >= camino.size()) {
                return true; // Aún no están agregados los hijos, no se puede validar
            }

            int esperado = camino.get(indexAbajoIzq) + camino.get(indexAbajoDer);
            return camino.get(index) == esperado;
        }

        return true; // Si está en la base, siempre es válido
    }


}
*/
}
