package Cursada2025.tp6;

public class Actividad {
    int tiempoComienzo;
    int tiempoFinalizacion;
    int totalTiempo;

    public Actividad(int tiempoComienzo, int tiempoFinalizacion) {
        this.tiempoComienzo = tiempoComienzo;
        this.tiempoFinalizacion = tiempoFinalizacion;
        this.totalTiempo = this.tiempoFinalizacion - tiempoComienzo;
    }

    public int getTiempoComienzo() {
        return tiempoComienzo;
    }

    public void setTiempoComienzo(int tiempoComienzo) {
        this.tiempoComienzo = tiempoComienzo;
    }

    public int getTiempoFinalizacion() {
        return tiempoFinalizacion;
    }

    public void setTiempoFinalizacion(int tiempoFinalizacion) {
        this.tiempoFinalizacion = tiempoFinalizacion;
    }

    public int getTotalTiempo() {
        return totalTiempo;
    }

    public void setTotalTiempo(int totalTiempo) {
        this.totalTiempo = totalTiempo;
    }
}
