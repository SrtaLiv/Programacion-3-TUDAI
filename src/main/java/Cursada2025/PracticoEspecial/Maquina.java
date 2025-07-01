package Cursada2025.PracticoEspecial;

import java.util.Comparator;

public class Maquina {
    private int pieza;
    private String nombre;

    public Maquina(int pieza, String nombre) {
        this.pieza = pieza;
        this.nombre = nombre;
    }

    public int getPieza() {
        return pieza;
    }

    public void setPieza(int pieza) {
        this.pieza = pieza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
