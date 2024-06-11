package practico5_backtracking.ej2;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        BacktrackingLaberinto laberinto = new BacktrackingLaberinto();

        Casillero c0 = new Casillero(false, true, true, false, 1);
        Casillero c1 = new Casillero(false, false, true, true, 2);
        Casillero c2 = new Casillero(false, true, true, true, 6);
        Casillero c3 = new Casillero(false, false, false, true, 2);

        Casillero d0 = new Casillero(false, true, false, false, 3);
        Casillero d1 = new Casillero(true, true, true, true, 4);
        Casillero d2 = new Casillero(false, false, false, false, 7);
        Casillero d3 = new Casillero(false, false, true, true, 17);

        Casillero e0 = new Casillero(false, true, true, false, 7);
        Casillero e1 = new Casillero(true, true, true, true, 2);
        Casillero e2 = new Casillero(true, true, false, false, 10);
        Casillero e3 = new Casillero(true, false, false, true, 3);

        Casillero f0 = new Casillero(true, true, false, false, 2);
        Casillero f1 = new Casillero(true, true, false, true, 4);
        Casillero f2 = new Casillero(true, true, false, true, 4);
        Casillero f3 = new Casillero(true, false, false, true, 3);

        laberinto.matriz[0][0] = c0;
        laberinto.matriz[0][1] = c1;
        laberinto.matriz[0][2] = c2;
        laberinto.matriz[0][3] = c3;

        laberinto.matriz[1][0] = d0;
        laberinto.matriz[1][1] = d1;
        laberinto.matriz[1][2] = d2;
        laberinto.matriz[1][3] = d3;

        laberinto.matriz[2][0] = e0;
        laberinto.matriz[2][1] = e1;
        laberinto.matriz[2][2] = e2;
        laberinto.matriz[2][3] = e3;

        laberinto.matriz[3][0] = f0;
        laberinto.matriz[3][1] = f1;
        laberinto.matriz[3][2] = f2;
        laberinto.matriz[3][3] = f3;

        c0.addVecino(c0);
        c0.addVecino(d0);

        c1.addVecino(c0);
        c1.addVecino(d1);
        c1.addVecino(c2);

        c2.addVecino(c1);
        c2.addVecino(c3);
        c2.addVecino(d2);

        c3.addVecino(c2);
        c3.addVecino(d3);

        d0.addVecino(c0);
        d0.addVecino(d1);

        d1.addVecino(c1);
        d1.addVecino(d0);
        d1.addVecino(d3);

        d2.addVecino(c2);
        d2.addVecino(d1);
        d2.addVecino(d3);

        d3.addVecino(d2);
        d3.addVecino(c3);

        Camino caminoEncontrado = laberinto.getMejorCamino(c0, d2);
        System.out.println("Costo total");
        System.out.println(caminoEncontrado.getCostoTotal());
    }
}
