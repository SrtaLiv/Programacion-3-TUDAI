package Parciales.Recuperatorio_2024;

import Cursada2024.practico2_1.ej1.Tree;
import Cursada2024.practico2_1.ej1.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {
    /*•
Ejercicio 2
Escriba en JAVA el código del método de la clase Tree (que representa
árboles binamos) que tiene 'a siguiente declaración:

private List<T> obtenerNivel (TreeNode<T> n, ínt k)

El metodo  al ser invocado con el nodo raiz del árbol binario, debe retornar una
lista con los elementos del nivel k de dicho árbol en orden de derecha a izquierda.

SI k es mayor a la altura del árbol deberá retornar una lista vacía.
Suponga que la clase Lista (simplemente vinculada) y TreeNode (nodo de árbol
btnano) tienen los métodos usuales.
Por ejemplo para el árbol de la derecha. y k=2. debe retornar la lista <O.S.N.L>
     */

    public List<T> obtenerNivel(TreeNode<T> n, int k) {
        List<T> resultado = new ArrayList<>();
        obtenerNivelRec(n, k, resultado);
        return resultado;
    }

    // k == 2
    private void obtenerNivelRec(TreeNode<T> nodo, int nivel, List<T> resultado) {
        if (nodo == null)
            return;

        if (nivel == 0) {
            resultado.add(nodo.getValor());
        } else {
            // Primero derecha, luego izquierda
            obtenerNivelRec(nodo.getDer(), nivel - 1, resultado);
            obtenerNivelRec(nodo.getIzq(), nivel - 1, resultado);
        }
    }


}
