package Cursada2024.practico5_backtracking.ej3;

import java.util.ArrayList;
import java.util.Arrays;

public class BackSuma {
    /*
    Ejercicio 3
        Suma de subconjuntos. Dados n números positivos distintos, se desea encontrar todas las
        combinaciones de esos números tal que la suma sea igual a M.
     */
     ArrayList<ArrayList<Integer>> combinaciones = new ArrayList<>();

     public BackSuma() {
        combinaciones = new ArrayList<>();
    }
    public ArrayList<ArrayList<Integer>> combinacionesPosibles(ArrayList<Integer> nums, int clave) {
        combinaciones.clear();
        ArrayList<Integer> caminoParcial = new ArrayList<>();
        backtracking(caminoParcial, nums, clave, 0, 0);

        return combinaciones;
    }

    private void backtracking(ArrayList<Integer> caminoParcial, ArrayList<Integer> nums, int clave, int sumaTotal, int startIndex) {
        if (sumaTotal == clave){
            combinaciones.add(new ArrayList<>(caminoParcial));
            return;
        }

        for (int i = startIndex; i < nums.size(); i++) {
            int num = nums.get(i);

            if (sumaTotal + num <= clave) {
                caminoParcial.add(num);
                backtracking(caminoParcial, nums, clave, sumaTotal + num, i + 1);
                caminoParcial.remove(caminoParcial.size() - 1);
            }
        }



    }

    public static void main(String[] args) {
        BackSuma backSuma = new BackSuma();

        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 3, 6, 7));
        int m = 7;

        ArrayList<ArrayList<Integer>> combinaciones = backSuma.combinacionesPosibles(nums, m);

        for (ArrayList<Integer> combinacion : combinaciones) {
            System.out.println(combinacion);
        }
    }
}

