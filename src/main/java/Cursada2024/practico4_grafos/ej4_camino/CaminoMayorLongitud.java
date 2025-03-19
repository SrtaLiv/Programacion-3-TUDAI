package practico4_grafos.ej4_camino;

public class CaminoMayorLongitud {

    /**
     * Ejercicio 4
     * Escribir un algoritmo que, dado un grafo dirigido y dos vértices i, j de este grafo, devuelva el
     * camino simple (sin ciclos) de mayor longitud del vértice i al vértice j. Puede suponerse que el
     * grafo de entrada es acíclico.
     */

/*    public ArrayList<Integer> caminoMayor(GrafoDirigidoHASH gr, int origen, int destino) {
        ArrayList<Integer> caminoMayor = new ArrayList<Integer>();
        this.visitados.add(origen);
        if (origen == destino) {
            caminoMayor .add(origen);
        } else {
            Iterator<Integer> it_ady = this.grafo.obtenerAdyacentes(origen);
            while (it_ady.hasNext()) {
                Integer ady = it_ady.next();
                if (!this.visitados.contains(ady)) {
                    ArrayList<Integer> camino = caminoMayor(ady, destino);
                    if (!camino.isEmpty() && (camino .size() >= caminoMayor .size())) {
                        caminoMayor.clear();
                        caminoMayor.add(origen);
                        caminoMayor.addAll(camino);
                    }
                }
            }
        }
        this.visitados.remove(origen);
        return caminoMayor ;
    }*/

}
