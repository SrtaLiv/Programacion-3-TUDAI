package practico_especial;

public class Tarea {
    private String id_tarea;
    private String nombre_tarea;
    private double tiempo_ejecucion;
    private Boolean es_critica;
    private int nivel_prioridad; //del 1 al 100

    public Tarea(String id_tarea, String nombre_tarea,
                 double tiempo_ejecucion, Boolean es_critica, int nivel_prioridad) {
        this.id_tarea = id_tarea;
        this.nombre_tarea = nombre_tarea;
        this.tiempo_ejecucion = tiempo_ejecucion;
        this.es_critica = es_critica;
        if (nivel_prioridad >= 1 && nivel_prioridad <= 100) {
            this.nivel_prioridad = nivel_prioridad;
        }
    }

    public String getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(String id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getNombre_tarea() {
        return nombre_tarea;
    }

    public void setNombre_tarea(String nombre_tarea) {
        this.nombre_tarea = nombre_tarea;
    }

    public double getTiempo_ejecucion() {
        return tiempo_ejecucion;
    }

    public void setTiempo_ejecucion(double tiempo_ejecucion) {
        this.tiempo_ejecucion = tiempo_ejecucion;
    }

    public Boolean getEs_critica() {
        return es_critica;
    }

    public void setEs_critica(Boolean es_critica) {
        this.es_critica = es_critica;
    }

    public int getNivel_prioridad() {
        return nivel_prioridad;
    }

    public void setNivel_prioridad(int nivel_prioridad) {
        this.nivel_prioridad = nivel_prioridad;
    }
}
