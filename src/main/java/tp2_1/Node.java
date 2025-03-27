package tp2_1;

public class Node<Integer> {
    private Node<java.lang.Integer> izq;
    private Node<java.lang.Integer> der;
    private java.lang.Integer info;

    public Node(Node<Integer> izq, Node<Integer> der, java.lang.Integer info) {
        this.izq = null;
        this.der = null;
        this.info = info;
    }

    public Node<java.lang.Integer> getIzq() {
        return izq;
    }

    public void setIzq(Node<java.lang.Integer> izq) {
        this.izq = izq;
    }

    public Node<java.lang.Integer> getDer() {
        return der;
    }

    public void setDer(Node<java.lang.Integer> der) {
        this.der = der;
    }

    public java.lang.Integer getInfo() {
        return info;
    }

    public void setInfo(java.lang.Integer info) {
        this.info = info;
    }
}
