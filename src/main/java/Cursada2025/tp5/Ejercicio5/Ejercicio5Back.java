package Cursada2025.tp5.Ejercicio5;

import java.util.ArrayList;

public class Ejercicio5Back {
    /*
    Ejercicio 5
    Asignación de tareas a procesadores. Se tienen m procesadores idénticos y n tareas con un tiempo
    de ejecución dado. Se requiere encontrar una asignación de tareas a procesadores de manera de
    minimizar el tiempo de ejecución del total de tareas.
    */

    // m procesoadores
    // n tareas con tiempo de ejecucion

    // procesadores: p1, p2, p3-
    // tareas: t1 -> tiempo 2,
    // t2 -> tiempo 3,
    // t3 tiempo 5,
    // t4 tiempo 7,
    // t5 tiempo 1,
    // t6 tiempo 4

    ArrayList<Procesador> visitados;
    ArrayList<Procesador> mejorSolucion;
    int mejorTiempo;

    public Ejercicio5Back() {
        this.visitados = new ArrayList<>();
        this.mejorSolucion = new ArrayList<>();
        this.mejorTiempo = 99;
    }

    public ArrayList<Procesador> getVisitados() {
        return visitados;
    }

    public void setVisitados(ArrayList<Procesador> visitados) {
        this.visitados = visitados;
    }

    public ArrayList<Procesador> getMejorSolucion() {
        return mejorSolucion;
    }

    public void setMejorSolucion(ArrayList<Procesador> mejorSolucion) {
        this.mejorSolucion = mejorSolucion;
    }

    public int getMejorTiempo() {
        return mejorTiempo;
    }

    public void setMejorTiempo(int mejorTiempo) {
        this.mejorTiempo = mejorTiempo;
    }

    public void asignatTareas(ArrayList<Tarea> tareas, ArrayList<Procesador> procesadors){
        // como ordenamos
        // ArrayList<Tarea> tareasOrdenadas = ordenarTareasDesc(tareas);
        asignarTareaPrivado(procesadors, tareas, 0);

    }

    //
//    private void asignarTareaPrivado( ArrayList<Procesador> procesadors, ArrayList<Tarea> tareas, int index){
//       if (index == tareas.size()){
//           int tiempoMax = calcularTiempoMax(procesadors);
//           if (tiempoMax < mejorTiempo){
//                mejorTiempo = tiempoMax;
//                mejorSolucion = clonarProcesadores(procesadors);
//           }
//       }
//       else {
//           Tarea actual = tareas.get(index);
//           for (Procesador pp : procesadors){
//                   pp.asignarTarea(actual);
//                   asignarTareaPrivado(procesadors, tareas,  index+1);
//                   pp.quitarTarea(actual);
//               }
//           }
//       }

    private void asignarTareaPrivado(ArrayList<Procesador> procesadors, ArrayList<Tarea> tareas, int index) {
        if (index == tareas.size()) {
            int tiempoMax = calcularTiempoMax(procesadors);
            if (tiempoMax < mejorTiempo) {
                mejorTiempo = tiempoMax;
                mejorSolucion = clonarProcesadores(procesadors);

                // Mostrar la mejor solución encontrada hasta ahora
                System.out.println("🌟 Nueva mejor solución con tiempo: " + mejorTiempo);
                for (int i = 0; i < mejorSolucion.size(); i++) {
                    System.out.println("P" + (i + 1) + ": " + mejorSolucion.get(i));
                }
                System.out.println("--------------------------------");
            }
        } else {
            Tarea actual = tareas.get(index);
            for (int i = 0; i < procesadors.size(); i++) {
                Procesador pp = procesadors.get(i);

                pp.asignarTarea(actual);
                System.out.println("Asigno tarea (" + actual.getTiempoTarea() + ") a P" + (i + 1));
                imprimirEstado(procesadors);

                asignarTareaPrivado(procesadors, tareas, index + 1);

                pp.quitarTarea(actual);
                System.out.println("Quito tarea (" + actual.getTiempoTarea() + ") de P" + (i + 1));
                imprimirEstado(procesadors);
            }
        }
    }

    private void imprimirEstado(ArrayList<Procesador> procesadors) {
        for (int i = 0; i < procesadors.size(); i++) {
            System.out.println("P" + (i + 1) + ": " + procesadors.get(i));
        }
        System.out.println("--------------");
    }


    // Busca los mejores tiempos de procesadores
    private int calcularTiempoMax(ArrayList<Procesador> procesadors){
        int max = 0;
        for (Procesador pp : procesadors){
            int tiempo = pp.getTiempoTareas();
            if (tiempo > max){
                max = tiempo;
            }
        }
        return max;
    }

private ArrayList<Procesador> clonarProcesadores(ArrayList<Procesador> original) {
    ArrayList<Procesador> copia = new ArrayList<>();
    for (Procesador p : original) {
        Procesador nuevo = new Procesador();
        for (Tarea t : p.getTareasAsignadas()) {
            nuevo.asignarTarea(new Tarea(t.getTiempoTarea())); // copio tarea también
        }
        copia.add(nuevo);
    }
    return copia;
}



private void backtracking(ArrayList<Procesador> procesadors, ArrayList<Tarea> tareas, int contadorMaximo){
        // si mis tareas ya esta vacia
        //si tengo mejor solucion, contadorParcial con el del atirbuto
        // mejor solucion la lista de procesadores, y reemplazo el mejor tiempo.

        // else recorriod,
        // ir sacando las tareas
        // for d procesadores, asigno tareas sumo al tiempo parcial, y despues deshago
    }


    public static void main(String[] args) {
        Ejercicio5Back ejercicio5 = new Ejercicio5Back();
        ArrayList<Procesador> procesadors = new ArrayList<>();

        Procesador p1 = new Procesador();
        Procesador p2 = new Procesador();
        procesadors.add(p1);
        procesadors.add(p2);

        // procesadores: p1, p2, p3-
        // tareas: t1 -> tiempo 2,
        // t2 -> tiempo 3,
        // t3 tiempo 5,
        // t4 tiempo 7,
        // t5 tiempo 1,
        // t6 tiempo 4

        ArrayList<Tarea> tareas = new ArrayList<>();

        Tarea t1 = new Tarea(2);
        Tarea t2 = new Tarea(3);
        Tarea t3 = new Tarea(5);

        tareas.add(t1);
        tareas.add(t2);
        tareas.add(t3);

        ejercicio5.asignatTareas(tareas, procesadors);

    }
}
