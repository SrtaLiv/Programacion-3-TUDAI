package practico5_backtracking.ej6;

import practico5_backtracking.ej2.Casillero;

public class CaballoAtila {

    private Boolean[][] jardin;
    public CaballoAtila(){
    }
/*
    public void backtrack(Casillero origen){
        Camino parcial = new Camino();
        this.backtrack(origen, origen, parcial);
    }
    private void backtrack(Casillero destino, Casillero origen, Camino parcial){

        if(origen.equals(destino)){
            camino = parcial.getCopy();
            return;
        }

        if(parcial.contains(origen)){
            return;
        }

        if(origen.tienePaso()){
            return;
        }

        for(Casillero c : jardin) {
            parcial.add(c);
            this.backtrack(destino, c, parcial);
            parcial.remove(c);
        }
    }*/


}
