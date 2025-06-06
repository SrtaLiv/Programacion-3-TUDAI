package Cursada2025.tp5.Ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class Casillero {
    int fila, columna;
    int value; // opcional
    boolean top, right, bottom, left;

    public Casillero(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public Casillero(int value) {
        this.value = value;
    }

    public int getFila() { return fila; }
    public int getColumna() { return columna; }

    // equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Casillero)) return false;
        Casillero other = (Casillero) o;
        return fila == other.fila && columna == other.columna;
    }

    @Override
    public int hashCode() {
        return 31 * fila + columna;
    }

    public List<Casillero> getVecinos(Casillero[][] tablero, int n) {
        List<Casillero> vecinos = new ArrayList<>();
        if (fila > 0) vecinos.add(tablero[fila - 1][columna]);
        if (fila < n - 1) vecinos.add(tablero[fila + 1][columna]);
        if (columna > 0) vecinos.add(tablero[fila][columna - 1]);
        if (columna < n - 1) vecinos.add(tablero[fila][columna + 1]);
        return vecinos;
    }
}
