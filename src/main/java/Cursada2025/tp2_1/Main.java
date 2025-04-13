package Cursada2025.tp2_1;

import Cursada2024.practico1.ej4.MySimpleLinkedList;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
//        tree.add(6);
//        tree.add(2);
//        tree.add(1);
//        tree.add(4);
//        tree.add(10);
//        tree.add(11);
//        tree.add(8);
//        tree.add(7);
//        tree.add(9);

        tree.add(6);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(18);
        tree.add(17);
        tree.add(20);
        tree.add(13);
        tree.add(9);


        boolean tiene = tree.hasElem(9);
        System.out.println(tiene);
        System.out.println("hola");

        //tree.delete(1);
        //boolean tiene2 = tree.hasElem(1);
        //System.out.println(tiene2);

        int altura = tree.getHeight();

        System.out.println(altura);
//
//        System.out.println("PRE ORDER");
//        tree.printPreOrder(tree.getRoot());
////      tree.printPreOrderV1(tree.getRoot());
//
//        System.out.println("POS ORDER");
//        tree.printPosOrder(tree.getRoot());
//
//
//        System.out.println("IN ORDER");
//        tree.printInOrder(tree.getRoot());

        // tree.getLongestBranch();
//        int max = tree.getMaxElem();
//        System.out.println("Maximo elemento: " + max);

      /*  System.out.println(tree.getElemAtLevel(3));

        tree.sumarHojas(1);
        tree.sumarNodosInternos();
        */

        tree.obtenerPorNivel(2);


    }

}
