package ejyoutube.Palindromo;

public class Main {
    public static void main(String[] args) {
        Palind pali = new Palind();
        String palabra = "reconocer";
        boolean es = pali.esPalindromoRecursivo("reconocer", 0,palabra.length()-1);
        System.out.println("¿Es palindromo?" + es);
    }
}
