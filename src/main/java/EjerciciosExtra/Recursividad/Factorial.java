package EjerciciosExtra.Recursividad;

public class Factorial {
    public static void main(String[] args) {

    }

    /* Sumar los numeros naturales hasta N de forma recursiva factorial*/
    public static int factorialNumero(int n){
        int res;
        if (n == 1){
            return 1;
        }
        else {
            res = n * factorialNumero(n-1);
        }
        return res;
    }

    public static int sumaRecursiva(int numero){
        int res;
        if (numero==1){
            return 1;
        }
        else {
            res = numero+ sumaRecursiva(numero-1);
        }
        return res;
    }
}
