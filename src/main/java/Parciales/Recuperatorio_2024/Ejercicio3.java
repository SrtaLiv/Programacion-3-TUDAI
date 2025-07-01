package Parciales.Recuperatorio_2024;

import java.util.ArrayList;

public class Ejercicio3 {
    /*
Ejercicio 3
Dada una cuadrícula de tamaño N x M y una lista con N • M números enteros (positivos y negativos)
se desea encontrar. si extste, una configuración de la cuadrícula dónde, luego de colocar todos
 los números de la bolsa, se cumplan tas siguientes restricciones:
Si tomamos el valor de una fila como la suma de tos valores que contiene,
ninguna fila puede tener un valor superior a un valor F. dado por parámetro.
Si tomamos ej valor de una columna como la suma de los valores que contiene,
 ninguna columna puede tener un valor inferior a un valor C, dado por parámetro.

a) Dibuje el árbol de exploración del algoritmo, Indicando qué decisiones se
toman en cada paso y qué información se lleva en los estados

b) Escriba un algoritmo en pseudo•java que resuelva el problema mediante la técnica de Backtracking.
     */
    // ArrayList<Integer> visitados = new ArrayList<>();
    /* Arraylist
    No es buena opcion, debido a que si hay numeros repetidos va a fallar! pq preguntara si contiene,
    y a lo mejor no es el mismo numero
     */
    boolean[] usados = new boolean[lista.size()];

    Tablero solucion = new Tablero();

    public void buscarCongifuracion(Tablero tt, ArrayList<Integer> lista, int c, int f){
        backtacking(tt, lista, c, f);
    }

    private void backtacking(Tablero tt, ArrayList<Integer> lista, int c, int f) {
        if (tt.estaLleno()){
            // Si las sumas de las filas no sobrepasan f, y de columnas no sobrepasan f
            if (verificarSumaPorFilasYColumnas(tt, c, f)){
                solucion = new Tablero(tt);
            }
        }
        else{
            for (int i = 0; i < lista.size(); i++){
                if (!usados[i]) {
                    usados[i] = true;
                    visitados.add(lista.get(i));
                    tt.agregarTablero(lista.get(i));

                    if (podaFila(tt, f) && podaColumna(tt, c)){
                        backtacking(tt, lista, c, f);
                    }
                    tt.removeTablero(lista.get(i));
                    usados[i] = false;
                }
            }
        }
    }
}
