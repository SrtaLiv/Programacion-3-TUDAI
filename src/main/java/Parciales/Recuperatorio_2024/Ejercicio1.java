package Parciales.Recuperatorio_2024;

import Cursada2024.practico4_grafos.grafoListaAdy.Arco;

import java.util.Hashtable;
import java.util.Iterator;

public class Ejercicio1 {

    /**
     * Dado un grafo no dirigido
     * G(𝑉,𝐴) - G(V,A), escribir un algoritmo en Java que permita encontrar un ciclo hamiltoniano
     * (ciclo que pasa una vez por todos los vértices de V) de mayor peso (es decir, que la suma de los arcos que lo
     * componen sea la mayor posible).
     * El algoritmo debe devolver como resultado la lista de vértices que se deben seguir en secuencia para formar dicho ciclo.
     * Si hay más de un ciclo con el mismo peso máximo, devolver cualquiera de ellos.
     * Por ejemplo, para el grafo de la derecha que tiene varios ciclos hamiltonianos,
     * se debe encontrar y devolver el de mayor peso (en este caso, con peso 180).
     * Ciclos posibles:
     * A - B - C - F - E - D - A → peso 140
     * A - B - C - F - D - E - A → peso 180
     * A - C - B - F - E - D - A → peso 130
     */

    private Hashtable<Integer, String> colores;
    // Ciclo: Almacena el camino (secuencia de vértices) y el costo (suma de arcos)
    private Ciclo mejorSolucion;

    public Ciclo ejercicio1(Grafo<Float> g) {
        colores = new Hashtable<>();
        mejorSolucion = new Ciclo();
        mejorSolucion.setCosto(0);

        // Inicialización
        Iterator<Integer> it = g.obtenerVertices();

        while (it.hasNext()) {
            colores.put(it.next(), "B");
        }

        Ciclo ciclo = new Ciclo();
        Integer origen = g.obtenerVertices().next(); // Obtener el primero de los vértices
        ciclo.addVertice(origen);
        ciclo.setCosto(0);
        obtenerCicloHamiltoneano(g, origen, origen, ciclo);

        return mejorSolucion;
    }

    public static void obtenerCicloHamiltoneano(Grafo<Float> g, Integer actual, Integer origen, Ciclo ciclo) {
        // Cuando en el camino tenemos todos los vértices + el origen 2 veces (inicio y fin)
        if (ciclo.getCamino().size() == g.cantidadVertices() + 1) {
            if (actual == origen) {
                // Operar solución actual contra mejor solución
                if (ciclo.getCosto() > mejorSolucion.getCosto()) {
                    mejorSolucion = new Ciclo(ciclo); // Copia el camino y el costo
                }
            }
        } else {
            Iterator<Arco<Float>> adyacentes = g.obtenerArcos(actual);

            while (adyacentes.hasNext()) {
                Arco<Float> adyacente = adyacentes.next();

                if (colores.get(arco.getVerticeDestino() == "B")) {
                    ciclo.addVertice(arco.getVerticeDestino());
                    ciclo.costo += (arco.getEtiqueta());
                    colores.put(arco.getVerticeDestino(), "A");

                    obtenerCicloHamiltoneano(g, arco.getVerticeDestino(), origen, ciclo);

                    ciclo.removeVertice(arco.getVerticeDestino());
                    ciclo.costo -= (arco.getEtiqueta());
                    colores.put(arco.getVerticeDestino(), "B");
                }
            }
        }
    }
}
