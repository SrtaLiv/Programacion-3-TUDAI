package EjerciciosExtra.Recuperatorio2024;

import java.util.ArrayList;

public class Ejercicio3 {

    public Cuadrilla llenarCuadricula(Cuadrilla cc, ArrayList<Integer> nums, int f, int c){
        for (Integer actual : nums){
            cc.agregar(actual);
            Cuadrilla solucion = backtracking(cc, nums, f, c);
            if (solucion!=null){
                return Cuadrilla;
            }
            cc.quitar(actual);
        }
        return null;
    }

    private Cuadrilla backtracking(Cuadrilla cc, ArrayList<Integer> nums, int f, int c){
        if (cc.size() == nums.size()){
            if (cumpleRestricciones(c, f, cc)){
                return cc;
            }
        }
        else{
            for (Integer i : nums){
                if (!cc.contains(i)){
                    cc.agregar(i);
                    Cuadrilla res = backtracking(cc, nums, f, c);
                    if (res != null)
                        return res;
                    cc.quitar(i);
                }

            }
        }
        return null;
    }

    public boolean cumpleRestricciones(int c, int f, Cuadrilla cc){
        for (ArrayList<Integer> fila : cc.getFilas()){
            if (!sumaFila(fila) < f){
                return false;
            }
        }
        for (ArrayList<Integer> col : cc.getColumnas()){
            if (!sumaColumna(col) < f){
                return false;
            }
        }
        return true;
    }
}
