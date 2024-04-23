package practico2_1.ej1e;

public class main {
    public static void main(String[] args) {
        Tree arbol = new Tree();
        arbol.add(50); //ROOT
        arbol.add(30);
        arbol.add(70);
        arbol.add(20);
        arbol.add(40);
        arbol.add(25);
        arbol.add(26);
        arbol.add(23);



        Tree arbolSolo = new Tree();

        /*System.out.println("Raíz del árbol: " + arbol.getRoot()); // Output: 50
        System.out.println("¿El árbol contiene el elemento 30? " + arbol.hasElem(30)); // Output: true
        System.out.println("¿El árbol contiene el elemento 100? " + arbol.hasElem(100)); // Output: false
        System.out.println("¿El árbol esta vacio? " + arbol.isEmpty()); // Output: false
        System.out.println("¿El árbol esta vacio? " + arbolSolo.isEmpty()); // Output: true
        System.out.println("Altura de un arbol: " + arbol.getHeight()); //altura 2

        System.out.println("////////////////////");
        System.out.println("Arbol en pre-orden ");
        arbol.printPreOrder();

        System.out.println("////////////////////");
        System.out.println("Arbol en post-orden ");
        arbol.printPosOrder();

        System.out.println("////////////////////");
        System.out.println("Arbol en orden ");
        arbol.printInOrder();
*/
        System.out.println("Rama mas larga" + arbol.getLongestBranch());
        System.out.println(arbol.getElemAtLevel(2));
        System.out.println(arbol.getMaxElem());

    }
}
