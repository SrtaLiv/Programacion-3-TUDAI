package Cursada2025.PracticoEspecial;

import java.util.*;

public class Fabrica_greedy {
    private List<Maquina> recorridoActual;
    private List<Maquina> solucion;
    private int contadorGlobal;

    public Fabrica_greedy() {
        recorridoActual = new LinkedList<>();
        solucion = new LinkedList<>();
        contadorGlobal = 0;
    }

    public int getContadorGlobal() {
        return contadorGlobal;
    }

    public List<Maquina> secuenciarMaquinas(List<Maquina> maquinas, int piezasRequeridas) {
        solucion.clear();
        recorridoActual.clear();
        maquinas.sort(Comparator.comparingInt(Maquina::getPieza).reversed());
        secuenciarMaquinasGreedy(maquinas, piezasRequeridas, 0);
        return solucion;
    }

    private void secuenciarMaquinasGreedy(List<Maquina> maquinas, int piezasRequeridas, int contadorPiezasActuales) {
        while (!maquinas.isEmpty()) {
            if(piezasRequeridas==contadorPiezasActuales) {
                solucion = new LinkedList<>(recorridoActual);
                maquinas.clear();
            }
            else {
                if ((contadorPiezasActuales + maquinas.getFirst().getPieza()) <= piezasRequeridas){ // si es factible
                    recorridoActual.add(maquinas.getFirst());
                    contadorPiezasActuales+=maquinas.getFirst().getPieza();
                }
                else {
                    // si no es factible, es mayor a cant de piezas
                    maquinas.removeFirst();
                }
            }
            contadorGlobal++;
        }

    }

        public static void main(String[] args) {
            // Crear lista de máquinas
            List<Maquina> maquinas = new ArrayList<>();
            maquinas.add(new Maquina(7, "Cortadora"));
            maquinas.add(new Maquina(3, "Pulidora"));
            maquinas.add(new Maquina(2, "Torno"));
            maquinas.add(new Maquina(1, "Fresadora"));
            maquinas.add(new Maquina(4, "Taladro"));
            // Caramelin, 7;
            // Coco, 8;

            //streams
            // Cantidad de piezas requeridas
            int piezasRequeridas = 9;

            // Crear objeto de Fabrica_greedy
            Fabrica_greedy fabrica = new Fabrica_greedy();

            // Ejecutar secuenciación
            List<Maquina> resultado = fabrica.secuenciarMaquinas(maquinas, piezasRequeridas);

            // Mostrar resultado
            if (resultado != null && !resultado.isEmpty()) {
                System.out.println("Máquinas seleccionadas:");
                for (Maquina m : resultado) {
                    System.out.println(m.getNombre() + " - Piezas: " + m.getPieza());
                }
            } else {
                System.out.println("No se encontró una secuencia válida.");
            }
            System.out.println(fabrica.getContadorGlobal());


    }
}
