package practico_especial;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Servicios {

    private List<Tarea> tareas;
    private List<Procesador> procesadores;

    //Completar con las estructuras y métodos privados que se requieran.
    /*
     * Expresar la complejidad temporal del constructor.
     */
    public Servicios(String pathProcesadores, String pathTareas) {

        this.procesadores = this.cargarProcesadores(pathProcesadores);
        this.tareas = this.cargarTareas(pathTareas);

    }

    private List<String> leerArchivo(String path) {
        List<String> lines = new ArrayList<>();                                         // lista vacia
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {            // creo BufferReader con path
            String line;                                                                // temp string
            while ((line = br.readLine()) != null) {                                    // leo linea por linea si no es null
                lines.add(line);                                                        // la agrego a la lista de lineas
            }
        } catch (IOException e) {
            return null;                                                                // return null si hay error
        }
        return lines;                                                                   // return lista de lineas
    }

    private List<Tarea> cargarTareas(String pathTareas) {

        List<Tarea> tareas = new ArrayList<>();
        List<String> csv = this.leerArchivo(pathTareas);                                // leo el archivo csv

        for(String line: csv) {                                                         // recorro linea x linea

            String[] datos = line.split(";");                                     // split de las columnas en cada ;

            String idTarea =            datos[0];
            String nombreTarea =        datos[1];
            double tiempoEjecucion =    Double.parseDouble(datos[2]);
            Boolean esCritica =         Boolean.parseBoolean(datos[3]);
            int nievlPrioridad =        Integer.parseInt(datos[4]);

            tareas.add(new Tarea(idTarea, nombreTarea, tiempoEjecucion, esCritica, nievlPrioridad));
        }
        return tareas;
    }

    private List<Procesador> cargarProcesadores(String pathProcesadores) {

        List<Procesador> cpu = new ArrayList<>();
        List<String> csv = this.leerArchivo(pathProcesadores);

        for(String line: csv) {

            String[] datos = line.split(";");

            int idProcesador =          Integer.parseInt(datos[0]);
            int codigoProcesador =      Integer.parseInt(datos[1]);
            Boolean estaRefrigerado =   Boolean.parseBoolean(datos[3]);
            int anioFuncionamiento =    Integer.parseInt(datos[4]);

            cpu.add(new Procesador(idProcesador, codigoProcesador, estaRefrigerado, anioFuncionamiento));
        }
        return cpu;
    }

    /*
     * Expresar la complejidad temporal del servicio 1.
     * O(N)
     */
    public Tarea servicio1(String ID) {
        for (Tarea t : tareas){
            if (t.getId().equals(ID)){
                return t;
            }
        }
        return null;
    }

    /*
     * Expresar la complejidad temporal del servicio 2.
     * O(N)
     */
    public List<Tarea> servicio2(boolean esCritica) {
        List<Tarea> tareasCriticas = new ArrayList<>();
        for (Tarea t : tareas){
            if (t.esCritica() == esCritica){
                tareasCriticas.add(t);
            }
        }
        return tareasCriticas;
    }

    /*
     * Expresar la complejidad temporal del servicio 3.
     * O(N)
     */
    public List<Tarea> servicio3(int prioridadInferior, int
            prioridadSuperior) {
        List<Tarea> nivelPrioridad = new ArrayList<>();
        for (Tarea t : tareas){
            if (t.getNivelPrioridad() >= prioridadInferior &&
                    t.getNivelPrioridad() <= prioridadSuperior){
                nivelPrioridad.add(t);
            }
        }
        return nivelPrioridad;
    }
    
}
