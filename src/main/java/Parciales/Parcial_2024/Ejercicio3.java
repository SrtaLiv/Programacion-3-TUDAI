package Parciales.Parcial_2024;

import java.util.ArrayList;

import static Parciales.Parcial_2024.Ejercicio3.Diccionario.esVocal;

public class Ejercicio3 {
    /**
     * Ejercicio 3
     * Dado un conjunto C de letras (que tiene más de 4 elementos), se desean generar todas las palabras válidas que
     * contengan exactamente 4 letras sin repetir y no empiecen con una letra vocal. Se supone que contamos con una
     * clase Diccionario que nos permite verificar si una secuencia de letras es una palabra válida
     * <Diccionario.esPalabraValida(string)>.
     * Por ejemplo, con C={E, R, N, O, M, A, T} se debería generar una solución compuesta por {MANO, MONA, REMO,
     * MORA, RAMO, ROEN, TOMA, ROTA, etc… }
     * a) Dibuje el árbol de exploración del algoritmo, indicando qué decisiones se toman en cada paso y qué
     * información se lleva en los estados.
     * b) Escriba un algoritmo en pseudo-java que resuelva el problema mediante la técnica de Backtracking.
     * c) ¿Se podría plantear alguna poda que minimice la cantidad de estados generados por el Backtracking?
     */

    /**
     * 3.c. La poda podría ser suponer que existe un método prefijoVálido e ir chequeando si el string que se va armando es
     * un prefijo válido.
     * El hecho que la palabra no tiene que tener más de 4 letras y que no puede empezar con vocal son más bien las reglas
     * que debe cumplir una solución válida al problema, más que una poda adicional que es a lo que iba orientada la
     * pregunta.
     */

    ArrayList<String> soluciones;
    public void generarPalabras(ArrayList<String> conjunto){


    }

    private void backtracking(ArrayList<String> conjunto, String palabra, String actual){
        if (palabra.length() == 4){
            if (Diccionario.esPalabraValida(actual) ){
                soluciones.add(palabra);
            }
        }
        else{
            for (String letra : conjunto){
                if (palabra.length() == 0 || (!palabra.contains(letra) && !esVocal(palabra.getFirstLetra()))) {
                    palabra += letra;
                    backtracking(conjunto, palabra, letra);
                    //palabra -= letra;
                }
            }
        }

    }

    public static class Diccionario{
        public static boolean esPalabraValida(String ss){
            return true;
        }

        public static boolean esVocal(String ss){
            return true;
        }
    }

}

