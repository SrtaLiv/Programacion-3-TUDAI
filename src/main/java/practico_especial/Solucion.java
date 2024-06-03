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
        //this.tiempoMaximo = Integer.MAX_VALUE;

        // inicializamos la lista
        this.solucion = new HashMap<>();
        for(Procesador p : procesadores){
            List<Tarea> t = new ArrayList<>();
            this.solucion.put(p, t);
        }


    }

    public void add(Procesador p, Tarea t){
        List<Tarea> tareas = this.solucion.get(p);
        tareas.add(t);
        //this.solucion.get(p).add(t);
    }

    public void remove(Procesador p, Tarea t){
        List<Tarea> tareas = this.solucion.get(p);
        tareas.remove(t);
        //this.solucion.get(p).remove(t);
    }

    public Solucion getCopy() {
        Solucion copy = new Solucion(this.procesadores, this.maxTiempoEjecucion);
        copy.setSolucion(new HashMap<>(this.solucion));

        return copy;
    }

    private void setSolucion(HashMap<Procesador, List<Tarea>> s){
        this.solucion = s;
        System.out.println(this.solucion);
    }


    public int getTiempoMaximo(){

        int tiempoMax = 0;
        for(Procesador p : this.procesadores) {

            int tiempoAcumulado = 0;
            List<Tarea> tareas = this.solucion.get(p);
            for (Tarea t : tareas)
                tiempoAcumulado += t.getTiempoEjecucion();

            if (tiempoAcumulado > tiempoMax)
                tiempoMax = tiempoAcumulado;

        }
        if (tiempoMax == 0)
            return Integer.MAX_VALUE;

        return tiempoMax;
    }

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


    public String toString(){
        String output = "";

        for(Procesador p : this.procesadores){

            output += p.getId() + " [ ";

            List<Tarea> tareas = this.solucion.get(p);

            for(Tarea t : tareas){
                output += t.getId()+", ";
            }

            output += "], \n";

        }

        return output;
    }



}
