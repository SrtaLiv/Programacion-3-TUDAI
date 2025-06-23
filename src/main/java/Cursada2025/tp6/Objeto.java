package Cursada2025.tp6;

public class Objeto {
    double peso;
    double valor;
    double maximoValor;

    public Objeto(double peso, double valor) {
        this.peso = peso;
        this.valor = valor;
    }

    public Objeto(double peso, double valor, double maximoValor) {
        this.peso = peso;
        this.valor = valor;
        this.maximoValor = maximoValor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public double getValorPorPeso() {
        return maximoValor;
    }

    public void setMaximoValor(int maximoValor) {
        this.maximoValor = maximoValor;
    }

    @Override
    public String toString() {
        return "Objeto{" +
                "peso=" + peso +
                ", valor=" + valor +
                ", maximoValor=" + maximoValor +
                '}';
    }
}
