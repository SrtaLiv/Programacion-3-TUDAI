package practico_especial;

import java.io.*;
import java.util.*;

public class Servicios {

    private List<Tarea> tareas;
    private List<Procesador> procesadores;

    private HashMap<String, Tarea> hashmapTareas;                   // para servicio1

    private List<Tarea> tareasCriticas;                             // para servicio2
    private List<Tarea> tareasNoCriticas;                           // para servicio2

    private SolucionBacktrack mejorSolucionBacktrack;               // para llevar registro de la mejor solucion encontrada
    private SolucionGreedy mejorSolucionGreedy;
    private int maxTiempoEjecucion;

    private List<Integer> otrosTiempos;                             // solo para mostrar los tiempos de otras soluciones

    public Servicios(String pathProcesadores, String pathTareas) {

        this.procesadores = new ArrayList<>();                      // init lista cpus
        this.tareas = new ArrayList<>();                            // init lista tareas

        this.hashmapTareas = new HashMap<>();                       // init hasmap para servicio1

        this.tareasCriticas = new ArrayList<>();                    // init listas auxiliares para servicio2
        this.tareasNoCriticas = new ArrayList<>();

        this.readProcessors(pathProcesadores);                      // cargar procesadores
        this.readTasks(pathTareas);                                 // cargar tareas

        //this.maxTiempoEjecucion = 75; // temporal;

        Scanner reader = new Scanner(System.in);
        int input = 0;
        while(input <= 0) {
            System.out.print("Ingrese tiempo de ejecucion maxima para CPUs NO refrigerados: ");
            input = reader.nextInt();
            if(input <= 0) {
                System.out.println("Ingrese un numero mayor a 0");
            }
        }
        this.maxTiempoEjecucion = input;


        this.mejorSolucionBacktrack = new SolucionBacktrack(this.procesadores, maxTiempoEjecucion);
        this.mejorSolucionGreedy = new SolucionGreedy(this.procesadores, maxTiempoEjecucion);

        this.otrosTiempos = new ArrayList<>();

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

    public SolucionBacktrack backtrack(){
        System.out.println("[ Solucion Backtrack ]");
        SolucionBacktrack parcial = new SolucionBacktrack(this.procesadores, this.maxTiempoEjecucion);        // new solucion parcial vacia inicial
        this.backtrack(parcial, 0);     // magia

        if(mejorSolucionBacktrack.isEmpty()){
            System.out.println("Backtrack: No hay solucion :(");
            return null;
        }

        System.out.print("\nOtros tiempos encontrados: ");
        Collections.sort(this.otrosTiempos);
        System.out.println(this.otrosTiempos);

        this.mejorSolucionBacktrack.show();
        return this.mejorSolucionBacktrack;         // return mejor solucion encontrada
    }

    /*

    En este enfoque, suponiendo que tenemos una lista con 3 procesadores, y una lista con n tareas,
    una representacion visual de la estructura seria algo asi [ [ t0 ], [ t1 ], [ t2 ] ]
    donde la lista padre es la solucion, y cada sub-lista es una lista de tareas asignada a cada cpu.

    Con este algorimo de backtracking, generamos todas las posibles combinaciones y permutaciones de estas 3 listas
    sin repetir la misma tarea en mas de 1 procesador distinto.

    Cuando llegamos a un caso base (hoja), verificamos que esta solucion sea valida, es decir que cada sub-lista
    de tareas cumpla con las restricciones de su procesador, y si es una solucion valida, comparamos con la
    solucion previamente encontrada (si es que hay una), y si es mejor, se reemplaza por la nueva.

    */

    private void backtrack(SolucionBacktrack parcial, int idxTarea){

        if( idxTarea+1 == this.tareas.size()){                                                      // llegamos al final de la lista de tareas (leaf)
            if(parcial.esValida()) {                                                                // es solucion valida? (cumple con las restricciones)
                this.otrosTiempos.add(parcial.getTiempoMaximo());                                   // agrego el tiempo maximo de la solucion encontrada, solo para comparar tiempos
                if (parcial.getTiempoMaximo() <= mejorSolucionBacktrack.getTiempoMaximo()) {        // la solucion encontrada es mejor que la solucion previa
                    mejorSolucionBacktrack = parcial.getCopy();                                     // shallow copy de la nueva solucion
                }
            }
            return;
        }

        Tarea t = this.tareas.get(idxTarea);                                                // toma una tarea de la lista de tareas por indice
        for(Procesador p : this.procesadores) {
            parcial.add(p, t);                                                              // agrego la tarea a la solucion parcial
            this.backtrack(parcial, idxTarea + 1);                                  // magia x2
            parcial.remove(p, t);                                                           // remuevo la tarea de la solucion parcial
        }

    }

    /*
    En este otro enfoque, utilizamos un algoritmo Greedy,
    iteramos sobre cada tarea, y elegimos el procesador al que mejor se adapte en ese momento.

    Por cada tarea, se busca el proximo mejor procesador, se verifica que la tarea sea asignable a ese procesador,
    es decir que cumpla con las restricciones del mismo, y si es valido, se agrega.
    Continuamos asi hasta acabar con las tareas
    */

    public SolucionGreedy greedy(){
        System.out.println("[ Solucion Greedy ]");
        for(Tarea t : this.tareas){

            Procesador p = mejorSolucionGreedy.getMejorProcesador(t);
            if(p == null) {
                System.out.println("Greedy: No hay solucion :(");
                return null;
            }
            mejorSolucionGreedy.add(p, t);

        }
        mejorSolucionGreedy.show();
        return mejorSolucionGreedy;
    }



}
