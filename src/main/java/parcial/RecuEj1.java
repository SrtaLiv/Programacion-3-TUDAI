package parcial;

import java.util.ArrayList;

public class RecuEj1 {
/**
 * b) Dado un array D de números ordenados de menor a mayor.
 * Escriba un algoritmo recursivo en JAVA que agregue todos los
 * números de D a un árbol binario de búsqueda que inicialmente estará vacio,
 * de inanera que resulte en un árbol balanceado. Puede suponerse que la clase Arbol ya se encuontra implementada
 */
    public Arbol() {
        raiz = null;
    }
// Método para construir un árbol balanceado a partir de un array ordenado
    public void construirArbolBalanceado(ArrayList<Integer> arrayD) {
        raiz = construirArbolBalanceadoRec(arrayD, 0, arrayD.size() - 1);
    }

    private Nodo construirArbolBalanceadoRec(ArrayList<Integer> arrayD, int inicio, int fin) {
        if (inicio > fin) {
            return null;
        }

        int medio = (inicio + fin) / 2;
        Nodo nodo = new Nodo(arrayD.get(medio));

        nodo.izquierda = construirArbolBalanceadoRec(arrayD, inicio, medio - 1);
        nodo.derecha = construirArbolBalanceadoRec(arrayD, medio + 1, fin);

        return nodo;
    }

}
