package practico_especial;

public class Tarea {
    private String idTarea;
    private String nombreTarea;
    private double tiempoEjecucion;
    private Boolean esCritica;
    private int nivelPrioridad; //del 1 al 100

    public Tarea(String idTarea, String nombreTarea, double tiempoEjecucion, Boolean esCritica, int nivelPrioridad) {
        this.idTarea = idTarea;
        this.nombreTarea = nombreTarea;
        this.tiempoEjecucion = tiempoEjecucion;
        this.esCritica = esCritica;
        this.setNivelPrioridad(nivelPrioridad);
    }

    public String getId() {
        return idTarea;
    }

    public void setId(String idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombre() {
        return nombreTarea;
    }

    public void setNombre(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public double getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(double tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public Boolean esCritica() {
        return esCritica;
    }

    public void setEsCritica(Boolean esCritica) {
        this.esCritica = esCritica;
    }

    public int getNivelPrioridad() {
        return nivelPrioridad;
    }

    public void setNivelPrioridad(int nivelPrioridad) {
        if (nivelPrioridad >= 1 && nivelPrioridad <= 100) {
            this.nivelPrioridad = nivelPrioridad;
        }
    }
}
