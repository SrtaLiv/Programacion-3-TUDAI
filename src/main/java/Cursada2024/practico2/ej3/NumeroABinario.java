package practico2.ej3;
public class NumeroABinario {
    /**
     * Implemente un algoritmo recursivo que convierta un número en notación decimal a su
     * equivalente en notación binaria.
     * Recordatorio, por ejemplo convertir el 26 a binario:
     */

    public int decimalABinario(int n){
        if (n == 0 || n == 1){
            return n;
        } else {
            if (n % 2 == 0){
                System.out.println("| 0 | n: " + n);
                decimalABinario(n/2);

            }
            if (n % 2 != 0){
                System.out.println("| 1 | n: " + n);
                decimalABinario(n/2);
            }
        }
        return n;
    }

    public String decimalABinarioGPT(int n){
        if (n == 0 || n == 1){
            return Integer.toString(n); // Convierte el número entero en una cadena de texto
        } else {
            String resultado = decimalABinarioGPT(n / 2);
            // Concatenar el dígito binario obtenido con el residuo de la división de n entre 2
            resultado += Integer.toString(n % 2);
            return resultado;
        }
    }

    public static void main(String[] args) {
        NumeroABinario num = new NumeroABinario();
        //int n = num.decimalABinario(26);
        String nums = num.decimalABinarioGPT(26);
        //System.out.println(n);
        System.out.println(nums);
    }


}

