package practico_especial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Solucion {

    private HashMap<Procesador, List<Tarea>> solucion;
    private List<Procesador> procesadores;
    private int maxTiempoEjecucion;

    public Solucion(List<Procesador> procesadores, int maxTiempoEjecucion){

        this.procesadores = procesadores;
        this.maxTiempoEjecucion = maxTiempoEjecucion;

        // inicializamos el hashmap, usando los cpu como clave
        // por cada cpu inicalizamos una List<Tarea> vacia
        // para guardar las tareas de cada cpu
        this.solucion = new HashMap<>();
        for(Procesador p : procesadores){
            List<Tarea> t = new ArrayList<>();
            this.solucion.put(p, t);
        }

    }

    // asignar (tarea t) a (procesador p)
    public void add(Procesador p, Tarea t){
        this.solucion.get(p).add(t);
    }

    // remover la (tarea t) de (procesador p)
    public void remove(Procesador p, Tarea t){
        this.solucion.get(p).remove(t);
    }

    // shallow copy del hashmap con sus tareas
    // esto es necesario para poder reasignar la mejorSolucion con la nueva solucion parcial encontrada
    // si no, cuando hagamos parcial.remove(), tambien estariamos borrando de la mejorSolucion referenciada
    public Solucion getCopy() {

        Solucion copia = new Solucion(procesadores, maxTiempoEjecucion);            // creo nueva instancia de Solucion
        HashMap<Procesador, List<Tarea>> copiaHashmap = new HashMap<>();            // creo un nuevo hashmap
        for(Procesador p : procesadores){                                           // itero los procesadores
            List<Tarea> tareas = new ArrayList<>(this.solucion.get(p));             // clono la lista de tareas de cada cpu
            copiaHashmap.put(p, tareas);                                            // y las inserto en el nuevo hashmap
        }
        copia.setSolucion(copiaHashmap);                                            // asigno el nuevo hashmap a la nueva instancia de Solucion
        return copia;                                                               // y devuelvo la nueva copia profunda
    }

    private void setSolucion(HashMap<Procesador, List<Tarea>> s){
        this.solucion = s;
    }


    // obtengo el tiempo maximo de la solucion en general
    // osea el tiempo del cpu que tarde mas
    public int getTiempoMaximo(){

        int tiempoMax = 0;
        for(Procesador p : this.procesadores) {                             // itero sobre cada cpu

            int tiempoAcumulado = 0;                                        // reinicio el tiempo acumulado para cada cpu
            List<Tarea> tareas = this.solucion.get(p);                      // obtengo la lista de tareas de ese cpu
            for (Tarea t : tareas)
                tiempoAcumulado += t.getTiempoEjecucion();                  // y por cada tarea acumulo los tiempos

            if (tiempoAcumulado > tiempoMax)                                // si el tiempo acumulado del cpu es mayor al tiempo maximo, asigno tiempo maximo con el tiempo acumulado de ese cpu
                tiempoMax = tiempoAcumulado;
        }
        if (tiempoMax == 0)                                                 // si el tiempo maximo es 0, (probablemente porque no hay tareas), le asigno un numero muy grande, para no confundir el algoritmo
            return Integer.MAX_VALUE;

        return tiempoMax;
    }

    // checkeo si la solucion es valida
    // es decir que cumple con las restricciones
    // (tiempo acumulado x cpu no refrigerado, no supera tiempo de ejecucion maxima)
    // (no hay mas de 2 tareas criticas asignadas a un mismo cpu)
    public boolean esValida(){

        for(Procesador p : this.procesadores){

            List<Tarea> tareas = this.solucion.get(p);
            int critCount = 0;
            int tiempoAcumulado = 0;

            for(Tarea t : tareas){

                if(t.esCritica())
                    critCount++;

                tiempoAcumulado += t.getTiempoEjecucion();

                if(critCount >= 2)
                    return false;

                if(!p.esRefrigerado() && tiempoAcumulado >= maxTiempoEjecucion)
                    return false;

            }

        }

        return true;

    }

    public boolean isEmpty(){
        for(Procesador p : this.procesadores){
            if (!solucion.get(p).isEmpty()){
                return false;
            }
        }
        return true;
    }

    public void show(){

        System.out.println("\n===================================================");
        System.out.println("! = tarea critica, # = cpu refrigerado");
        System.out.println("Maximo tiempo ejecucion cpu NO refrigerado: ("+maxTiempoEjecucion+"s)");
        System.out.println("===================================================\n");
        for(Procesador p : this.procesadores){

            String refri = p.esRefrigerado() ? "#":"-";
            String data = "CPU "+p.getId() + " "+ refri +" : [";

            int tiempoAcum = 0;

            List<Tarea> tareas = this.solucion.get(p);

            for(Tarea t : tareas){
                tiempoAcum += t.getTiempoEjecucion();
                String esCrit = t.esCritica() ? "!":"";
                data += t.getId()+esCrit+", ";
            }

            data = data.substring(0, data.length()-2);
            data += "]\t\t(t: "+tiempoAcum+"s)";

            System.out.println(data);

        }
        System.out.println("\n[ Tiempo maximo: "+getTiempoMaximo()+"s ]");
    }


}
