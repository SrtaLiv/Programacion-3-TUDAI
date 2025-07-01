package Cursada2025.tp6;

import Cursada2024.practico5_backtracking.ej6.PosibleSolucion.Casilla;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ej9 {
    /**
     * Ejercicio 9
     * Se posee una matriz cuadrada de tamaño N x N donde en cada celda de la matriz se aloja un
     * número entero NO negativo (es decir, >= 0). Dada una celda de origen y una celda de destino, se
     * desea encontrar, de ser posible, el camino de mayor costo entre el origen y el destino. El costo del
     * camino será medido por la suma de los valores de las celdas que conforman dicho camino. Los
     * movimientos válidos desde una celda son arriba, abajo, derecha e izquierda, un camino no puede
     * pasar dos veces por una misma celda, y siempre que nos movemos de una celda C1 a una celda C2,
     * el valor de la celda C2 debe ser mayor al valor de la celda C1. Por ejemplo, si estoy en una celda
     * con valor 10, no puedo ir a una celda de valor 8, pero si puedo ir a una de valor 12.
     * Se pide plantear un algoritmo mediante estrategia Greedy
     * a) ¿Cuál sería la estrategia Greedy que seguiría?.
     * b) Escriba un pseudo-java que lo resuelva mediante la estrategia Greedy.
     */

    ArrayList<Integer> solucion = new ArrayList<>();
    ArrayList<Integer> visitados = new ArrayList<>();
    public void buscarCamino(Tablero tt, int origen, int destino){
        solucion.add(origen);
        buscarCaminoMayor(tt, origen, destino, origen);
    }

    private void buscarCaminoMayor(Tablero tt, int origen, int destino, int sumaCamino){
        if (origen == destino){ // Se encontro el destino
            System.out.println("se encontro el destino");
            return;
        }

        ArrayList<Integer> ady = tt.getAdyacentes(origen);

        int mejorPos = -1;
        int mejorValor = -1;

        // buscar el mayor adyacnete
        for (Integer pos : ady){
            int valor = tt.get(pos);

            if (!visitados.contains(pos) && valor > tt.get(actual)){
                if (valor > mejorValor){
                    mejorValor = valor;
                    mejorPos = pos;
                }
            }
        }

        // Si encontramos una opción válida, avanzamos
        if (mejorPos != -1){
            sumaCamino = mejorPos;
            solucion.add(mejorPos);
            visitados.add(mejorPos);
            buscarCaminoMayor(tt, mejorPos, destino, sumaCamino + mejorValor);
        }

        else{
            System.out.println("No se puede avanzar más. Camino terminado.");        }
    }

    public void buscarCaminoMayor(Tablero tt, Casilla origen, Casilla destino){
        solucion.add(origen);
        visitados.add(origen);
        greedy(tt, origen, destino, origen.getValue());
    }

    private void greedy(Tablero tt, Casilla actual, Casilla destino, int contador) {
        if (destino == actual){
            solucion.add(actual);
        }
        else{
            List<Casilla> adyacentes = tt.getAdyacentes(actual);
            int mejorValor = -1;
            Casilla elegidaMayor = null;

            for (Casilla ady : adyacentes){
                if (!visitados.contains(ady) && ady.getValue() > actual.getValue()){
                    if (ady.getValue() > mejorValor)  {
                        mejorValor = ady.getValue();
                        elegidaMayor = ady;
                    }
                }
            }

            if (elegidaMayor == null) return;

            contador += elegidaMayor.getValue();
            visitados.add(elegidaMayor);
            solucion.add(elegidaMayor);
            greedy(tt, ady, tt.obtener(elegidaMayor), destino, contador);
        }
    }

}
