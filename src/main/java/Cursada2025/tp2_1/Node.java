package Cursada2025.tp2_1;

public class Node<Integer> {
    private Node<Integer> izq;
    private Node<Integer> der;
    private Integer info;

    public Node(Node<Integer> izq, Node<Integer> der, Integer info) {
        this.izq = null;
        this.der = null;
        this.info = info;
    }

    public Node<Integer> getIzq() {
        return izq;
    }

    public void setIzq(Node<Integer> izq) {
        this.izq = izq;
    }

    public Node<Integer> getDer() {
        return der;
    }

    public void setDer(Node<Integer> der) {
        this.der = der;
    }

    public Integer getInfo() {
        return info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }
}
