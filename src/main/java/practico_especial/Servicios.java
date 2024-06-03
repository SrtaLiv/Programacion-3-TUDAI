package practico_especial;

import java.io.*;
import java.util.*;

public class Servicios {

    private List<Tarea> tareas;
    private List<Procesador> procesadores;

    private HashMap<String, Tarea> hashmapTareas;                   // para servicio1

    private List<Tarea> tareasCriticas;                             // para servicio2
    private List<Tarea> tareasNoCriticas;                           // para servicio2

    private Solucion mejorSolucion;
    private int maxTiempoEjecucion;

    public Servicios(String pathProcesadores, String pathTareas) {

        this.procesadores = new ArrayList<>();
        this.tareas = new ArrayList<>();

        this.hashmapTareas = new HashMap<>();
        //this.hasmapProcesadores = new HashMap<>();

        this.tareasCriticas = new ArrayList<>();
        this.tareasNoCriticas = new ArrayList<>();

        this.readProcessors(pathProcesadores);
        this.readTasks(pathTareas);

        this.maxTiempoEjecucion = 75; // temporal;
        //this.mejorSolucion = new Solucion(this.procesadores, maxTiempoEjecucion);

    }

    public void readTasks(String taskPath) {

        // Obtengo una lista con las lineas del archivo
        // lines.get(0) tiene la primer linea del archivo
        // lines.get(1) tiene la segunda linea del archivo... y así
        ArrayList<String[]> lines = this.readContent(taskPath);

        for (String[] line: lines) {
            // Cada linea es un arreglo de Strings, donde cada posicion guarda un elemento
            String id = line[0].trim();
            String nombre = line[1].trim();
            Integer tiempo = Integer.parseInt(line[2].trim());
            Boolean critica = Boolean.parseBoolean(line[3].trim());
            Integer prioridad = Integer.parseInt(line[4].trim());

            Tarea t = new Tarea(id, nombre, tiempo, critica, prioridad);
            this.tareas.add(t);                             // agrego tarea a la lista simple
            hashmapTareas.put(t.getId(), t);                // agergo tarea al hashmap con clave tarea.id

            if(t.esCritica()){
                tareasCriticas.add(t);                      // agrego a lista de critica o NOcritica
            }else{
                tareasNoCriticas.add(t);
            }

        }

    }

    public void readProcessors(String processorPath) {

        // Obtengo una lista con las lineas del archivo
        // lines.get(0) tiene la primer linea del archivo
        // lines.get(1) tiene la segunda linea del archivo... y así
        ArrayList<String[]> lines = this.readContent(processorPath);

        for (String[] line: lines) {
            // Cada linea es un arreglo de Strings, donde cada posicion guarda un elemento
            String id = line[0].trim();
            String codigo = line[1].trim();
            Boolean refrigerado = Boolean.parseBoolean(line[2].trim());
            Integer anio = Integer.parseInt(line[3].trim());

            Procesador p = new Procesador(id, codigo, refrigerado, anio);
            this.procesadores.add(p);
            //this.hasmapProcesadores.put(p.getId(), p);
        }

    }

    private ArrayList<String[]> readContent(String path) {
        ArrayList<String[]> lines = new ArrayList<String[]>();

        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                lines.add(line.split(";"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (bufferedReader != null)
                try {
                    bufferedReader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
        }

        return lines;
    }

    // GET TAREA BY idTarea, COMPLEJIDAD O(1)
    public Tarea servicio1(String ID) {
       return hashmapTareas.get(ID);
    }

    // GET TAREAS CRITICAS / NO-CRITICAS, COMPLEJIDAD O(1)
    public List<Tarea> servicio2(boolean esCritica) {
        if(esCritica)
            return this.tareasCriticas;
        return this.tareasNoCriticas;
    }

    // rango min/max prioridad, COMPLEJIDAD O(N)
    public List<Tarea> servicio3(int prioridadInferior, int prioridadSuperior) {
        List<Tarea> rangoTareas = new ArrayList<>();
        for (Tarea t : tareas){
            if (t.getNivelPrioridad() >= prioridadInferior && t.getNivelPrioridad() <= prioridadSuperior){
                rangoTareas.add(t);
            }
        }
        return rangoTareas;
    }

    public void setMaxTiempoEjecucion(int max){
        this.maxTiempoEjecucion = max;
    }

    public Solucion backtrack(){

        Solucion parcial = new Solucion(this.procesadores, this.maxTiempoEjecucion);
        this.backtrack(parcial, 0);
        return this.mejorSolucion.getCopy();
    }

    // solucion = [ [ t0 ], [ ], [ ] ];

    private void backtrack(Solucion parcial, int idxTarea){

        if( idxTarea+1 == this.tareas.size()){                     // llegamos al final de la lista de tareas

            if(parcial.esValida()){

                if(mejorSolucion == null){
                    mejorSolucion = parcial.getCopy();
                }else {


                    if (parcial.getTiempoMaximo() <= this.mejorSolucion.getTiempoMaximo()) {
                        this.mejorSolucion = parcial.getCopy();

                        System.out.println(parcial.getTiempoMaximo());
                        System.out.println(parcial);

                    }

                }
            }
            return;

        }

        Tarea t = this.tareas.get(idxTarea);                        // toma una tarea del servicio
        for(Procesador p : this.procesadores) {

            parcial.add(p, t);
            this.backtrack(parcial, idxTarea + 1);
            parcial.remove(p, t);

        }
        //return;
    }

}
