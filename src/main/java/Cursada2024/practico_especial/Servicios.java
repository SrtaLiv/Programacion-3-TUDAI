package Cursada2024.practico_especial;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Servicios {

    private List<Tarea> tareas;
    private List<Procesador> procesadores;
    private HashMap<String, Tarea> hashmapTareas;

    private List<Tarea> tareasCriticas;
    private List<Tarea> tareasNoCriticas;

    //List<List<Tarea>> mejorSolucion = new ArrayList<>();

    private HashMap<Procesador, List<Tarea>> mejorSolucion;

    //Completar con las estructuras y métodos privados que se requieran.
    /*
     * Expresar la complejidad temporal del constructor.
     */
    public Servicios(String pathProcesadores, String pathTareas) {

        this.hashmapTareas = new HashMap<>();
        this.tareasCriticas = new ArrayList<>();
        this.tareasNoCriticas = new ArrayList<>();

        this.cargarProcesadores(pathProcesadores);
        this.cargarTareas(pathTareas);

        this.mejorSolucion = new HashMap<>();

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

    private void cargarTareas(String pathTareas) {

        List<String> csv = this.leerArchivo(pathTareas);                                // leo el archivo csv

        for(String line: csv) {                                                         // recorro linea x linea

            String[] datos = line.split(";");                                     // split de las columnas en cada ;

            String idTarea =            datos[0];
            String nombreTarea =        datos[1];
            double tiempoEjecucion =    Double.parseDouble(datos[2]);
            Boolean esCritica =         Boolean.parseBoolean(datos[3]);
            int nievlPrioridad =        Integer.parseInt(datos[4]);

            Tarea t = new Tarea(idTarea, nombreTarea, tiempoEjecucion, esCritica, nievlPrioridad);

            this.tareas.add(t);                             // agrego tarea a la lista simple
            hashmapTareas.put(t.getId(), t);                // agergo tarea al hashmap con clave tarea.id

            if(t.esCritica()){
                tareasCriticas.add(t);                     // agrego a lista de critica o NOcritica
            }else{
                tareasNoCriticas.add(t);
            }

        }
    }

    private void cargarProcesadores(String pathProcesadores) {

        List<String> csv = this.leerArchivo(pathProcesadores);

        for(String line: csv) {

            String[] datos = line.split(";");

            int idProcesador =          Integer.parseInt(datos[0]);
            int codigoProcesador =      Integer.parseInt(datos[1]);
            Boolean estaRefrigerado =   Boolean.parseBoolean(datos[3]);
            int anioFuncionamiento =    Integer.parseInt(datos[4]);

            this.procesadores.add(new Procesador(idProcesador, codigoProcesador, estaRefrigerado, anioFuncionamiento));
        }
    }

    /*
     * Expresar la complejidad temporal del servicio 1.
     * O(1)
     */
    public Tarea servicio1(String ID) {
       return hashmapTareas.get(ID);
    }

    /*
     * Expresar la complejidad temporal del servicio 2.
     * O(1)
     */
    public List<Tarea> servicio2(boolean esCritica) {
        if(esCritica)
            return this.tareasCriticas;
        return this.tareasNoCriticas;
    }

    /*
     * Expresar la complejidad temporal del servicio 3.
     * O(N) -> en el peor de los casos es O(N), en el mejor O(prioridadSuperior)
     */
    public List<Tarea> servicio3(int prioridadInferior, int prioridadSuperior) {
        List<Tarea> nivelPrioridad = new ArrayList<>();
        for (Tarea t : tareas){
            if (t.getNivelPrioridad() >= prioridadInferior && t.getNivelPrioridad() <= prioridadSuperior){
                nivelPrioridad.add(t);
            }
        }
        return nivelPrioridad;
    }







    public void backtrack(){


        this.backtrack(mejorSolucion, 0);

        return;
    }

    // solucion = [ [ t0 ], [ ], [ ] ];


    private void backtrack(HashMap<Procesador, List<Tarea>> solucionParcial, int idxTarea){

        if(idxTarea+1 == this.tareas.size()){                     // llegamos al final de la lista de tareas

            return;
        }

        Tarea t = this.tareas.get(idxTarea);                    // toma una tarea del servicio

        for(Procesador p : this.procesadores) {
         //   if (esSolucionValida()){
           //     solucionParcial.put(p, t);

              //  List<Tarea> tareasCpu = this.backtrack(solucionParcial, idxTarea + 1);
                solucionParcial.remove(p, t);
            }
        }

    }


  /*  private boolean esSolucionValida(HashMap<Procesador, Tarea> solucion){

        for(Procesador p : this.procesadores){
            //List<Tarea> tareas = solucion.get(p);

        }
return true;

    }*/


