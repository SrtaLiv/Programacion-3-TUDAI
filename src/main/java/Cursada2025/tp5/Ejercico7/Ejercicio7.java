package Cursada2025.tp5.Ejercico7;

import java.util.ArrayList;

public class Ejercicio7 {

    ArrayList<Integer> tablero; // Almacena los números a colocar
    ArrayList<Integer> camino;  // Almacena el camino (una solución parcial)
    ArrayList<ArrayList<Integer>> soluciones; // Almacena las soluciones completas

    public Ejercicio7() {
        tablero = new ArrayList<>();
        camino = new ArrayList<>();
        soluciones = new ArrayList<>();
    }

    public void armarTablero(int n) {
        // Llenar el tablero con los números del 1 al n*n
        for (int i = 1; i <= n * n; i++) {
            tablero.add(i);
        }

        // Comenzamos a hacer backtracking
        backtracking(tablero, camino);
    }

    private void backtracking(ArrayList<Integer> tablero, ArrayList<Integer> camino) {
        // Si hemos llenado todas las casillas del tablero
        if (camino.size() == tablero.size()) {
            if (esTableroMagico(camino)) {
                soluciones.add(new ArrayList<>(camino)); // Guardamos la solución
            }
        } else {
            // Intentamos colocar cada número del tablero en la siguiente casilla
            for (Integer num : tablero) {
                if (!camino.contains(num)) { // Evitar duplicados
                    camino.add(num); // Agregar el número al camino
                    backtracking(tablero, camino); // Llamada recursiva
                    camino.remove(camino.size() - 1); // Eliminar el último número (backtrack)
                }
            }
        }
    }

    // Función para verificar si el tablero es mágico (suma de filas y columnas igual)
    private boolean esTableroMagico(ArrayList<Integer> camino) {
        int n = (int) Math.sqrt(camino.size()); // Calculamos el tamaño del tablero (n x n)
        int constanteMagica = (n * (n * n + 1)) / 2; // La constante mágica esperada

        // Convertir la lista plana en una matriz n x n
        int[][] matriz = new int[n][n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = camino.get(index++);
            }
        }

        // Verificar filas
        for (int i = 0; i < n; i++) {
            int sumaFila = 0;
            for (int j = 0; j < n; j++) {
                sumaFila += matriz[i][j];
            }
            if (sumaFila != constanteMagica) {
                return false; // Si la suma de alguna fila no es igual a la constante mágica, no es un tablero mágico
            }
        }

        // Verificar columnas
        for (int j = 0; j < n; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < n; i++) {
                sumaColumna += matriz[i][j];
            }
            if (sumaColumna != constanteMagica) {
                return false; // Si la suma de alguna columna no es igual a la constante mágica, no es un tablero mágico
            }
        }

        return true; // Si todas las filas y columnas suman lo mismo, es un tablero mágico
    }

    // Método para mostrar todas las soluciones encontradas
    public void mostrarSoluciones() {
        for (ArrayList<Integer> solucion : soluciones) {
            int n = (int) Math.sqrt(solucion.size());
            System.out.println("Solución:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(solucion.get(i * n + j) + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Ejercicio7 ejercicio = new Ejercicio7();
        ejercicio.armarTablero(2); // Ejemplo con un tablero de 3x3
        ejercicio.mostrarSoluciones(); // Mostrar las soluciones encontradas
    }
}
