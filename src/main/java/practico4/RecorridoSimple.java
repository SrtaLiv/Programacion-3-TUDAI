package practico4;

import java.util.Set;

public class RecorridoSimple {
    private Grafo<?> grafo;
    private Set<Integer> visitados;

    public RecorridoSimple(Grafo<?> grafo, Set<Integer> visitados) {
        this.grafo = grafo;
        this.visitados = visitados;
    }
}
