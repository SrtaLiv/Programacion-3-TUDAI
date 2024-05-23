package practico_especial;

import java.io.*;
import java.util.*;

public class Servicios {

    private List<Tarea> tareas;
    private List<Procesador> procesadores;

    //private HashMap<String, Procesador> hasmapProcesadores;
    private HashMap<String, Tarea> hashmapTareas;                   // para servicio1

    private List<Tarea> tareasCriticas;                             // para servicio2
    private List<Tarea> tareasNoCriticas;                           // para servicio2

    private Integer maxTiempoEjecucion;                             // para cpu no refrigerado

    public Servicios(String pathProcesadores, String pathTareas) {

        this.procesadores = new ArrayList<>();
        this.tareas = new ArrayList<>();

        this.hashmapTareas = new HashMap<>();
        //this.hasmapProcesadores = new HashMap<>();

        this.tareasCriticas = new ArrayList<>();
        this.tareasNoCriticas = new ArrayList<>();

        this.readProcessors(pathProcesadores);
        this.readTasks(pathTareas);

        this.maxTiempoEjecucion = 0;

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

    {
    /*private List<String> leerArchivo(String path) {
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
    }*/
    } // old implementation

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

    public void setMaxTiempoEjecucion(Integer m){
        this.maxTiempoEjecucion = m;
    }

    public void ejecutarTareas(){

        System.out.println("\nTiempo ejecucion maximo CPU NO refrigerado: "+this.maxTiempoEjecucion+"s");
        System.out.println("===========================================================\n");

        for(Tarea t : this.tareas){                                             // por cada tarea

            Procesador p = this.getBestCPU(t);                                  // busco el mejor cpu asignable
            p.pushTarea(t);                                                     // asigno la tarea a ese cpu

            // print tareas
            String crit = t.esCritica()?"SI":"NO";
            System.out.println(t.getNombre()+" - (critica: "+crit+", tiempo: "+t.getTiempoEjecucion()+"s) \t\t\tasignada a CPU '"+p.getId()+"'");

        }

        // print procesadores
        System.out.println("\n===========================================================\n");
        for(Procesador p : this.procesadores){
            String ref = p.esRefrigerado()?"SI":"NO";
            System.out.println("CPU "+p.getId()+" - (refrigerado: "+ref+")\t\t\tTiempo total: "+p.getTiempoEjecucionAcumulado()+" s");
        }

    }

    public boolean esAsignable(Procesador p, Tarea t){
        // si no es refrigerado, verifico que no sobrepase el max tiempo de ejecucion
        if(!p.esRefrigerado() && t.getTiempoEjecucion() > this.maxTiempoEjecucion){
            return false;
        }

        // si es critica, verifico que la ultima tarea asignada no sea critica (lo sacaron del tpe?)
        /*if(p.tieneTareas()){
            Tarea ultimaTarea = p.getUltimaTarea();
            if(ultimaTarea.esCritica() && t.esCritica())
                return false;
        }*/

        return true;
    }

    // obtengo el proximo mejor cpu:
    // itero sobre los procesadores y busco el que tenga menos tiempo de ejecucion acumulada
    // y que la tarea se pueda asignar a ese cpu
    public Procesador getBestCPU(Tarea t){
        Procesador best = this.procesadores.get(0);
        for(Procesador p : this.procesadores){
            if(p.getTiempoEjecucionAcumulado() < best.getTiempoEjecucionAcumulado())
                if(esAsignable(p, t))
                    best = p;
        }
        return best;

    }

}
