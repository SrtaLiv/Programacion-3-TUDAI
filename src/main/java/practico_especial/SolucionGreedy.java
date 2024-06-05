package practico_especial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolucionGreedy {


    private HashMap<Procesador, List<Tarea>> solucion;
    private List<Procesador> procesadores;
    private int maxTiempoEjecucion;

    public SolucionGreedy(List<Procesador> procesadores, int maxTiempoEjecucion){

        this.procesadores = procesadores;
        this.maxTiempoEjecucion = maxTiempoEjecucion;

        this.solucion = new HashMap<>();
        for(Procesador p : procesadores){
            List<Tarea> t = new ArrayList<>();
            this.solucion.put(p, t);
        }

    }
    public void add(Procesador p, Tarea t){
        this.solucion.get(p).add(t);
    }

    public void remove(Procesador p, Tarea t){
        this.solucion.get(p).remove(t);
    }

    public Procesador getMejorProcesador(Tarea t){
        Procesador mejor = null;
        for(Procesador p : this.procesadores){
            if(mejor == null){
                if (this.esAsignable(p, t))
                    mejor = p;
            }else {
                if (this.getTiempoAcumulado(p) < this.getTiempoAcumulado(mejor)) {
                    if (this.esAsignable(p, t))
                        mejor = p;
                }
            }
        }
        return mejor;
    }

    private int getTiempoAcumulado(Procesador p){
        int tiempoAcumulado = 0;
        for(Tarea t : this.solucion.get(p)){
            tiempoAcumulado += t.getTiempoEjecucion();
        }
        return tiempoAcumulado;
    }

    private boolean esAsignable(Procesador p, Tarea t){

        List<Tarea> tareas = this.solucion.get(p);

        int critCount = 0;
        int tiempoAcumulado = 0;

        for (Tarea tarea : tareas){
            if(tarea.esCritica())
                critCount++;
            tiempoAcumulado += tarea.getTiempoEjecucion();
        }

        if(critCount >= 2 && t.esCritica())
            return false;

        if(!p.esRefrigerado() && ((tiempoAcumulado + t.getTiempoEjecucion()) > maxTiempoEjecucion))
            return false;

        return true;
    }

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
        System.out.println("\n[ Tiempo maximo: "+getTiempoMaximo()+"s ]\n");
    }

}
