package practico5_backtracking.ej2;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        BacktrackingLaberinto laberinto = new BacktrackingLaberinto();

        Casillero c1 = new Casillero(false, true, true, false, 1);
        Casillero c2 = new Casillero(false, false, true, true, 2);
        Casillero c3 = new Casillero(false, true, true, true, 6);
        Casillero c4 = new Casillero(false, false, false, true, 2);

        Casillero d1 = new Casillero(false, true, false, false, 3);
        Casillero d2 = new Casillero(true, true, true, true, 4);
        Casillero d3 = new Casillero(false, false, false, false, 7);
        Casillero d4 = new Casillero(false, false, true, true, 17);

        Casillero e1 = new Casillero(false, true, true, false, 7);
        Casillero e2 = new Casillero(true, true, true, true, 2);
        Casillero e3 = new Casillero(true, true, false, false, 10);
        Casillero e4 = new Casillero(true, false, false, true, 3);

        Casillero f1 = new Casillero(true, true, false, false, 2);
        Casillero f2 = new Casillero(true, true, false, true, 4);
        Casillero f3 = new Casillero(true, true, false, true, 4);
        Casillero f4 = new Casillero(true, false, false, true, 3);

        laberinto.matriz[0][0] = c1;
        laberinto.matriz[0][1] = c2;
        laberinto.matriz[0][2] = c3;
        laberinto.matriz[0][3] = c4;

        laberinto.matriz[1][0] = d1;
        laberinto.matriz[1][1] = d2;
        laberinto.matriz[1][2] = d3;
        laberinto.matriz[1][3] = d4;

        laberinto.matriz[2][0] = e1;
        laberinto.matriz[2][1] = e2;
        laberinto.matriz[2][2] = e3;
        laberinto.matriz[2][3] = e4;

        laberinto.matriz[3][0] = f1;
        laberinto.matriz[3][1] = f2;
        laberinto.matriz[3][2] = f3;
        laberinto.matriz[3][3] = f4;

        Camino caminoEncontrado = laberinto.getMejorCamino(c1, d2);
        System.out.println("Costo total");
        System.out.println(caminoEncontrado.getCostoTotal());
    }
}
