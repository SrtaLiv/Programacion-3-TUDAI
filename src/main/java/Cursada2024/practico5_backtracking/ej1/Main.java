package Cursada2024.practico5_backtracking.ej1;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        GrafoDirigido gr = new GrafoDirigido();
        gr.addSala(0);
        gr.addSala(1);
        gr.addSala(2);
        gr.addSala(3);
        gr.addSala(4);
        gr.addSala(5);
        gr.addSala(6);
        gr.addSala(7);


        gr.addPuerta(0, 1, "ENTRADA COMUN");

        gr.addPuerta(1, 2, "puerta 1");
        gr.addPuerta(2, 3, "puerta 2");
        gr.addPuerta(3, 4, "puerta ante");
        gr.addPuerta(4, 7, "PUERTA SALIDA");

        gr.addPuerta(1, 5, "puerta 1");
        gr.addPuerta(5, 6, "puerta 1");
        gr.addPuerta(6, 7, "PUERTA SALIDA");

       /* Iterator<Integer> it = gr.obtenerTodasLasSalas();
        while (it.hasNext()){
            Integer ady = it.next();
            System.out.println(ady);
        }*/

        ArrayList<Integer> caminoMasLargo = gr.backtracking(0,7);
        for (Integer it : caminoMasLargo){
            System.out.println(it);
        }
        //OBTENER CAMINO MAS LARGO
    }
}
