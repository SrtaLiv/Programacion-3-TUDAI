package practico_especial;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Servicios servicios = new Servicios(
                "./src/main/java/practico_especial/datasets/Procesadores.csv",
                "./src/main/java/practico_especial/datasets/Tareas.csv"
        );

        //servicios.setMaxTiempoEjecucion(75);

        SolucionBacktrack sb = servicios.backtrack();
        SolucionGreedy sg = servicios.greedy();

    }

}
