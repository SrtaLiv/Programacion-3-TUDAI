package Cursada2024.practico2_1.ej1;

public class TreeNode {
    TreeNode derecha;
    TreeNode izquierda;
    int valor;

    public TreeNode(int valor) {
        this.derecha = null;
        this.izquierda = null;
        this.valor = valor;
    }


    public TreeNode getDer() {
        return derecha;
    }

    public void setDer(TreeNode derecha) {
        this.derecha = derecha;
    }

    public TreeNode getIzq() {
        return izquierda;
    }

    public void setIzq(TreeNode izquierda) {
        this.izquierda = izquierda;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
