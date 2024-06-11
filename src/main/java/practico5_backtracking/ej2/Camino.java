package practico5_backtracking.ej2;

import java.util.ArrayList;

public class Camino {
    ArrayList<Casillero> camino;
    int costoTotal;

    public Camino() {
        this.camino = new ArrayList<>();
        this.costoTotal = 0;
    }

    public void agregarAlCamino(Casillero casilla){
        costoTotal+= casilla.getCosto();
        camino.add(casilla);
    }


    public void incrementar(Casillero casillero){
        costoTotal += casillero.getCosto();
    }

    public void decrementar(Casillero casillero){
        costoTotal -= casillero.getCosto();
    }

    public ArrayList<Casillero> getCamino() {
        return camino;
    }

    public void setCamino(ArrayList<Casillero> camino) {
        this.camino.clear();
        this.camino.addAll(camino);
    }

    public void eliminarUltimoDelCamino() {
        Casillero ultimo = camino.remove(camino.size() - 1);
        costoTotal -= ultimo.costo;
    }

    public int getCostoTotal() {
        int costo = 0;
        for (Casillero cc : camino){
            costo += cc.getCosto();
        }
        return costo;
    }

    public void setCostoTotal(int costoTotal) {
        this.costoTotal = costoTotal;
    }
}
