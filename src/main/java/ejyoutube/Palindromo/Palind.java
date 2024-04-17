package ejyoutube.Palindromo;

public class Palind {
    /**
     * Implementa un algoritmo recursivo que determine si un string es un palíndromo.
     * Un palíndromo es una palabra o frase que se lee igual en ambas direcciones.
     * Por ejemplo, "radar", "reconocer" y "anita lava la tina" son palíndromos.
     */

    // r e c o n o c e r , 0 (r) , 8 (r)
    public boolean esPalindromoRecursivo(String ss, int ini, int fin) {
        if (ini >= fin){ //recorrimos toda la lista
            return true;
        }
        if (ss.charAt(ini) != ss.charAt(fin)) {
            return false;
        }
        return esPalindromoRecursivo(ss, ini + 1, fin - 1);
    }
}