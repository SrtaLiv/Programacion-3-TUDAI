package practico6_greedy;

import java.util.ArrayList;

public class Ej3_Actividades {
    /**
     * Ejercicio 3
     * Maximizar el número de actividades compatibles.
     * Se tienen n actividades que necesitan utilizar un
     * recurso, tal como una sala de conferencias, en exclusión mutua. Cada actividad i tiene asociado un
     * tiempo de comienzo ci y un tiempo de finalización fi de utilización del recurso, con ci < fi.
     * Si la actividad i es seleccionada se llevará a cabo durante el intervalo [ci, fi). Las actividades i y j son
     * compatibles si los intervalos [ci, fi) y [cj, fj) no se superponen (es decir, ci > fj o cj > fi).
     * El problema consiste en encontrar la cantidad máxima de actividades compatibles entre sí.
     */
    ArrayList<Actividad> actividades;

    public Ej3_Actividades() {
        this.actividades = new ArrayList<>();
    }

    public void addActividad(Actividad actividad){
        actividades.add(actividad);
    }

    public void maximizarNumActividadesCompatibles(){
        boolean esCompatible = false;
        ArrayList<Actividad> actCompatibles = new ArrayList<>();

        //ordenar de menor a mayor
        for (int i = 0; i < actividades.size(); i++){

            for (int j = 0; j < actividades.size(); j++){
            if (actividades.get(i).getCi() > actividades.get(j).getFi()){
                esCompatible = true;
                actCompatibles.add(actividades.get(i));
            }
            if (actividades.get(j).getCi() > actividades.get(i).getFi()){
                esCompatible = true;
                actCompatibles.add(actividades.get(i));
            }


            }
        }
    }

    public class Actividad{
        int ci; //Tiempo combienzo
        int fi; //Tiempo finalizacion con ci < fi}

        public Actividad(int ci, int fi) {
            this.ci = ci;
            this.fi = fi;
        }

        public int getCi() {
            return ci;
        }

        public void setCi(int ci) {
            this.ci = ci;
        }

        public int getFi() {
            return fi;
        }

        public void setFi(int fi) {
            this.fi = fi;
        }
    }




}
