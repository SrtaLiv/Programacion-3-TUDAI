package tp2_1;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.add(6);
        tree.add(2);
        tree.add(1);
        tree.add(4);
        tree.add(10);
        tree.add(11);
        tree.add(8);
        tree.add(7);
        tree.add(9);

        boolean tiene = tree.hasElem(9);
        System.out.println(tiene);
        System.out.println("hola");

        tree.delete(1);
        boolean tiene2 = tree.hasElem(1);
        System.out.println(tiene2);

    }
}
