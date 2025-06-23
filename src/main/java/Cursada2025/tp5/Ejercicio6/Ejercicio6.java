package Cursada2025.tp5.Ejercicio6;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ejercicio6 {
    /*
    Ejercicio 6
    Caballo de Atila. Por donde pisa el caballo de Atila jamás vuelve a crecer el pasto. El caballo fue
    directamente hacia el jardín de n x n casillas. Empezó su paseo por una casilla cualquiera y volvió a
    ella, es decir hizo un recorrido cerrado. No visitó dos veces una misma casilla, se movió de una
    casilla a otra vecina en forma horizontal o vertical, pero nunca en diagonal. Por donde pisó el
    caballo, el pasto jamás volvió a crecer. Luego de terminado el recorrido en algunas casillas todavía
    había pasto (señal de que en ellas no había estado el caballo). Escriba un algoritmo que deduzca el
    recorrido completo que hizo el caballo.
     */


    ArrayList<Casillero> recorridoActual = new ArrayList<>();
    ArrayList<Casillero> solucion = new ArrayList<>();

    public void buscarRecorrido(ArrayList<Casillero> casilleros, Casillero origen) {
        backtracking(casilleros, origen, origen);
    }

    private void backtracking(ArrayList<Casillero> recorrido, Casillero actual, Casillero destino) {
        if (!recorridoActual.isEmpty() && actual == destino) {
            solucion = new ArrayList<>(recorridoActual);
            solucion.add(actual);
            return;
        }

        if (recorridoActual.contains(actual)) { // si ya lo recorri, no volver a pisar
            return;
        }

        recorridoActual.add(actual);
        for (Casillero vecino : obtenerVecinosValidos(actual, recorrido)) {
            backtracking(recorrido, vecino, destino);
            if (!solucion.isEmpty()) {
                return; // si encontre solucion corto
            }
        }

        recorridoActual.removeLast(); // remover una casilla para probar otro camino
    }

    private ArrayList<Casillero> obtenerVecinosValidos(Casillero actual, ArrayList<Casillero> casilleros) {
        ArrayList<Casillero> vecinos = new ArrayList<>();
        for (Casillero c : casilleros) {
            if (esVecino(actual, c) && !recorridoActual.contains(c)) {
                vecinos.add(c);
            }
        }
        return vecinos;
    }

    private boolean esVecino(Casillero a, Casillero b) {
        int dx = Math.abs(a.getFila() - b.getFila());
        int dy = Math.abs(a.getColumna() - b.getColumna());
        return (dx + dy == 1); // movimiento horizontal o vertical
    }

}
