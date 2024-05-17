package practico_especial;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        //procesar archivos e informacion.
        List<Tarea> listaTareas = new ArrayList<>();

    }

    private List<Tarea> cargarTareas(String pathTareas) {
        List<Tarea> listaTareas = new ArrayList<>();

    }

    private String leerArchivo(String path) throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                //String line = br.read();
            } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    /*
     * Expresar la complejidad temporal del servicio 1.
     * O(N)
     */
    public Tarea servicio1(String ID) {
        for (Tarea t : tareas){
            if (t.getId_tarea().equals(ID)){
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
            if (t.getEs_critica() == esCritica){
                tareasCriticas.add(t);
            }
        }
        return tareasCriticas;
    }
    //If false == false return true
    //True == true return true

    /*
     * Expresar la complejidad temporal del servicio 3.
     * O(N)
     */
    public List<Tarea> servicio3(int prioridadInferior, int
            prioridadSuperior) {
        List<Tarea> nivelPrioridad = new ArrayList<>();
        for (Tarea t : tareas){
            if (t.getNivel_prioridad() >= prioridadInferior &&
                    t.getNivel_prioridad() <= prioridadSuperior){
                nivelPrioridad.add(t);
            }
        }
        return nivelPrioridad;
    }


}
