package practico6_greedy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ProblemaMochila {

    /*public class Objeto implements{
        String nombre;
        public int peso;
        public int valor;

        public Objeto(int p, int v){
            this.peso = p;
            this.valor = v;
        }

    }

    private ArrayList<Objeto> objetos;
    private ArrayList<Integer> mochila;

    private int capacidad = 100;

    public double greedy(){

        Collections.sort(objetos);

        double valorTotal = 0.0;
        int pesoActual = 0;

        for (Objeto o : objetos) {

            if (pesoActual + o.peso <= capacidad) {
                pesoActual += o.peso;
                valorTotal += o.valor;

            } else {

                int pesoRestante = capacidad - pesoActual;
                valorTotal += o.valor * ((double) pesoRestante / o.peso);
                break;

            }
        }

        return valorTotal;

    }*/


    public static void main(String[] args) throws InterruptedException {

        int y = 0;
        int x = 0;

        while(true){
            x++;
            double sx = Math.sin(x);
            double sy = Math.cos(x);
            sx = 10+sx*5;
            String s = "";
            for(int i = 0; i < sx; i++) {
                s += " ";
            }
            System.out.println(s+"#");
            Thread.sleep(10);
        }

    }
}


