package Cursada2025.ej8;

public class Ej8 {
    /**
     * Ejercicio 8
     * Se dispone de un conjunto de tareas, donde cada tarea tiene un nombre, una descripción y
     * una duración (medida en horas). Se sabe también que hay una dependencia en el orden
     * posible en el cual se pueden ejecutar estas tareas y un tiempo de espera entre dos tareas
     * consecutivas (también medido en horas). Por ejemplo, si la tarea B depende de la tarea A y
     * tiene un tiempo de espera de 5 horas; significa que:
     * ● B no puede ejecutarse antes que A y,
     * ● B debe ejecutarse 5 horas después de haber finalizado la ejecución de A.
     * Objetivo
     * Implementar un algoritmo que obtenga la secuencia de ejecución crítica de estas tareas, es
     * decir, la secuencia de tareas que resulta en el máximo tiempo empleado para su ejecución.
     * Por ejemplo: si partimos de la siguiente configuración podemos encontrar el camino crítico en
     * la secuencia de tareas [0, 2, 5, 6, 10], ya que su tiempo de ejecución es la duración de cada
     * tarea más el tiempo de espera entre cada par de tareas: 70 horas.
     */
}
