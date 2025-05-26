package Cursada2025.tp5.Ejercicio5;

import java.util.ArrayList;

public class Ejercicio5 {
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

    // primero tareas mas pesadas, para asegurar repartir bien las cargas mas pesadas y
    // equilibrar mejor

    // ORDENADAS: 7, 5, 4, 3, 2, 1

    // p1 [ 7 ] =
    // p2 [ 5, 3 ]
    // p3 [ 4, 2, 1]

    // ya distribui los mas pesaos 7, 5, 4. Entonces uspo
    // Como se a cual repartir por ejemplo el 3? pq va en p2

//    public void asignatTareas(ArrayList<Tarea> tareas, ArrayList<Procesador> procesadors){
//        // como ordenamos
//        ArrayList<Tarea> tareasOrdenadas = ordenarTareasDesc(tareas);
//        asignarTareaPrivado(procesadors, tareasOrdenadas);
//    }
//
//    private void asignarTareaPrivado(ArrayList<Procesador> pp, ArrayList<Tarea> tareas){
//            for (int j = 0; j < tareas.size(); j++){
//                for (int i = 0; i < pp.size()-1; i++){
//                    pp.get(i).asignarTarea(tareas.get(j));
//                    // no estoy entendiendo como cortar y seguir con el siguiente procesador
//                    // y si tengo que asignar tareas al procesador
//                    // o al procesador tareas, afecta el orden?
//                }
//            }
//    }
//
//    public static void main(String[] args) {
//        Ejercicio5 ejercicio5 = new Ejercicio5();
//        ArrayList<Procesador> procesadors = new ArrayList<>();
//
//        // procesadores: p1, p2, p3-
//        // tareas: t1 -> tiempo 2,
//        // t2 -> tiempo 3,
//        // t3 tiempo 5,
//        // t4 tiempo 7,
//        // t5 tiempo 1,
//        // t6 tiempo 4
//
//        ArrayList<Tarea> tareas = new ArrayList<>();
//        Tarea t1 = new Tarea(1);
//        Tarea t2 = new Tarea(3);
//        Tarea t3 = new Tarea(5);
//        Tarea t4 = new Tarea(7);
//        Tarea t5 = new Tarea(1);
//        Tarea t6 = new Tarea(4);
//
//        tareas.add(t1);
//        tareas.add(t2);
//        tareas.add(t3);
//        tareas.add(t4);
//        tareas.add(t5);
//        tareas.add(t6);
//
//        ejercicio5.asignatTareas(tareas, procesadors);
//
//
//    }
}
