package Cursada2025.PracticoEspecial;

import Cursada2025.tp4.GrafoDirigido;

import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Stream;
import java.util.*;

public class Fabrica {
    private List<Maquina> recorridoActual;
    private List<Maquina> soluciones; // solo necesitamos 1
    private int contadorGlobal;

    public Fabrica() {
        recorridoActual = new LinkedList<>();
        soluciones = new LinkedList<>();
        contadorGlobal = 0;
    }

    public int getContadorGlobal() {
        return contadorGlobal;
    }

    public List<Maquina> secuenciarMaquinas(List<Maquina> maquinas, int piezasRequeridas) {
        recorridoActual.clear();
        secuenciarMaquinasBacktraking(maquinas, piezasRequeridas, 0);
        return soluciones;
    }

    private void secuenciarMaquinasBacktraking(List<Maquina> maquinas, int piezasRequeridas, int contadorPiezasActuales) {
        // contador global + 1
        // consutlar
        contadorGlobal++;
        if(contadorPiezasActuales==piezasRequeridas) {
            // tengo que comparar contra la solucion actual si el size es mas chico es mejor
            // o el size actual es vacio
            if (soluciones.isEmpty() || soluciones.size() > recorridoActual.size()){
                soluciones.clear();
                soluciones.addAll(recorridoActual); // preguntar
            }

        } else {
            for (Maquina maq : maquinas){
                contadorPiezasActuales += maq.getPieza();

                // hay que podar los que ya usamos y se pasan de piezasRequeridas...

                // RESTRICCION
                if (contadorPiezasActuales <= piezasRequeridas) {

                    // PODA
                    // si el tamanio.size es mayor, si ya tengo solucion y sigue sinedo mas chcia e la q voy avanzando avanzo, SIZE + 1
                    // O q la solucion sea cero
                    recorridoActual.add(maq);
                    secuenciarMaquinasBacktraking(maquinas, piezasRequeridas, contadorPiezasActuales);
                    recorridoActual.removeLast(); // para linkedlist
                }
                contadorPiezasActuales -= maq.getPieza();
                //recorridoActual.remove(maquinas.size()-1); // este para arraylist
            }
        }
    }

    public static void main(String[] args) {
        Fabrica fabrica = new Fabrica();
        List<Maquina> maquinas = new LinkedList<>();
        // guardar las maquinas


        try (Stream<String> lineas = Files.lines(Paths.get("archivo.txt"))) {
            lineas.forEach(System.out::println);
            // convertir M1 a objeto maquina con la cant de piezas

            //ineas.forEach();
            // agarrar el q no tiene M
            // agarrar los que tienen M
            //maquinas.add(// lineas.maquina);
            // llamas al metodo en fabrica
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*List<Maquina> maquinas = new ArrayList<>();
        maquinas.add(new Maquina(7, "Torno"));
        maquinas.add(new Maquina(3, "Fresadora"));
        maquinas.add(new Maquina(4, "Taladro"));
        maquinas.add(new Maquina(1, "Cortadora"));

        // Crear instancia de Fabrica
        Fabrica fabrica = new Fabrica();

        // Probar con un requerimiento de 5 piezas
        int piezasRequeridas = 10;
        List<Maquina> resultado = fabrica.secuenciarMaquinas(maquinas, piezasRequeridas);

        // Mostrar resultado
        System.out.println("Mejor secuencia de máquinas para " + piezasRequeridas + " piezas:");
        for (Maquina maq : resultado) {
            System.out.println(maq.getNombre() + " (" + maq.getPieza() + ")");
        }

        System.out.println(fabrica.getContadorGlobal());*/
    }
}
