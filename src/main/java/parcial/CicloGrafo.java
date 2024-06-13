package parcial;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CicloGrafo {
    Grafo gg = new Grafo();
    ArrayList<Integer> caminoConCiclo = new ArrayList<>();
    Set<Integer> visitados = new HashSet<>();

    public boolean buscarCiclo(int x) {
        for (Integer vertice : gg.obtenerVertices()) {
            if (!visitados.contains(vertice)) {
                if (buscarCicloDFS(vertice, -1, new ArrayList<>())) {
                    int suma = 0;
                    for (int i = 0; i < caminoConCiclo.size() - 1; i++) {
                        suma += gg.obtenerArco(caminoConCiclo.get(i), caminoConCiclo.get(i + 1));
                    }
                    return suma == x;
                }
            }
        }
        return false;
    }

    private boolean buscarCicloDFS(int vertice, int padre, ArrayList<Integer> caminoParcial) {
        visitados.add(vertice);
        caminoParcial.add(vertice);

        for (Integer ady : gg.obtenerAdyacentes(vertice)) {
            if (!ady.equals(padre)) {
                if (visitados.contains(ady)) {
                    caminoParcial.add(ady);
                    int cicloInicio = caminoParcial.indexOf(ady);
                    caminoConCiclo.addAll(caminoParcial.subList(cicloInicio, caminoParcial.size()));
                    return true;
                } else {
                    if (buscarCicloDFS(ady, vertice, caminoParcial)) {
                        return true;
                    }
                }
            }
        }

        caminoParcial.remove(caminoParcial.size() - 1);
        return false;
    }


public class Grafo {
    // Método que devuelve todos los vértices del grafo
    public ArrayList<Integer> obtenerVertices() {
        // Implementar según la representación del grafo
        return new ArrayList<>();
    }

    // Método que devuelve los vértices adyacentes a un vértice dado
    public ArrayList<Integer> obtenerAdyacentes(int vertice) {
        // Implementar según la representación del grafo
        return new ArrayList<>();
    }

    // Método que devuelve el valor del arco entre dos vértices
    public int obtenerArco(int origen, int destino) {
        // Implementar según la representación del grafo
        return 0;
    }
}
}
