package Cursada2025.tp5.Ejercicio5;

import java.util.ArrayList;

public class Procesador {
    ArrayList<Tarea> tareasAsignadas;


    public Procesador() {
        tareasAsignadas = new ArrayList<>();
    }

    public void asignarTarea(Tarea tt){
        if (!tareasAsignadas.contains(tt)){ // esto hace falta o es redundate?
            tareasAsignadas.add(tt);
        }
    }

    @Override
    public String toString() {
        return "Procesador{" +
                "tareasAsignadas=" + tareasAsignadas +
                '}';
    }

    public void quitarTarea(Tarea tt){
        tareasAsignadas.remove(tt);
    }

    public ArrayList<Tarea> getTareasAsignadas() {
        return tareasAsignadas;
    }

    public void setTareasAsignadas(ArrayList<Tarea> tareasAsignadas) {
        this.tareasAsignadas = tareasAsignadas;
    }

    public int getTiempoTareas(){
        int count = 0;
        for (Tarea tt : tareasAsignadas){
            count += tt.getTiempoTarea();
        }
        return count;
    }
}
