package Cursada2025.tp6;

import java.util.ArrayList;
import java.util.Comparator;

public class ComparadorMejorTiempo implements Comparator<Actividad> {
    @Override
    public int compare(Actividad o1, Actividad o2) {
        return o1.getTiempoComienzo() - o2.getTiempoComienzo();
    }
}
