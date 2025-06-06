package Cursada2025.tp6;

import java.util.Comparator;

public class ComparadorValorPorPeso implements Comparator<Objeto> {
    @Override
    public int compare(Objeto o1, Objeto o2) {
        double ratio1 = o1.getValorPorPeso();
        double ratio2 = o2.getValorPorPeso();

        // De mayor a menor
        return Double.compare(ratio2, ratio1);
    }
}
