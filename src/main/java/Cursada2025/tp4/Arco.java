package Cursada2025.tp4;

public class Arco<T> {
    private int verticeOrigen;
    private int verticeDestino;
    private T etiqueta;

    public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.etiqueta = etiqueta;
    }

    public int getVerticeOrigen() {
        return verticeOrigen;
    }

    public void setVerticeOrigen(int verticeOrigen) {
        this.verticeOrigen = verticeOrigen;
    }

    public int getVerticeDestino() {
        return verticeDestino;
    }

    public void setVerticeDestino(int verticeDestino) {
        this.verticeDestino = verticeDestino;
    }

    public T getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(T etiqueta) {
        this.etiqueta = etiqueta;
    }
}
