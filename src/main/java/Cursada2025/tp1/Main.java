package Cursada2025.tp1;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> listA = new MySimpleLinkedList<>();
        Node<Integer> na1 = new Node<>(-3, null);
        Node<Integer> na2 = new Node<>(7, null);
        Node<Integer> na3 = new Node<>(4, null);
        Node<Integer> na4 = new Node<>(0, null);
        Node<Integer> na5 = new Node<>(10, null);

        MySimpleLinkedList<Integer> listB = new MySimpleLinkedList<>();
        Node<Integer> nb1 = new Node<>(-3, null);
        Node<Integer> nb2 = new Node<>(7, null);
        Node<Integer> nb3 = new Node<>(5, null);
        Node<Integer> nb4 = new Node<>(12, null);

        listA.insertFront(na1.getInfo());
        listA.insertFront(na2.getInfo());
        listA.insertFront(na3.getInfo());
        listA.insertFront(na4.getInfo());
        listA.insertFront(na5.getInfo());

        listB.insertFront(nb1.getInfo());
        listB.insertFront(nb2.getInfo());
        listB.insertFront(nb3.getInfo());
        listB.insertFront(nb4.getInfo());

        System.out.println("Nodo" + listA.get(0));
        System.out.println(listA.indexOf(5)); // indice 2 -> info 5

        Iterator<Integer> iterator = listA.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.print(i + " - ");
        }

        System.out.println("---------------------------------------------------");
        System.out.print("Lista 1: ");
        for (Integer num : listA) {
            System.out.print(num + " - ");
        }

        System.out.println(" ");

        System.out.print("Lista 2: ");
        for (Integer num : listB) {
            System.out.print(num + " - ");
        }
        System.out.println(" ");

        System.out.println("---------------------------------------------------");

        System.out.print("Lista Resultante Ejercicio 5: ");
        MySimpleLinkedList<Integer> listResult = construirOtraLista(listB, listA);
        for (Integer num : listResult) {
            System.out.print(num + " - ");
        }

        System.out.println("---------------------------------------------------");

        System.out.print("Lista Resultante ejercicio 6: ");
        MySimpleLinkedList<Integer> listResultEj6 = construirListaConElementosEnPrimeraYNoEnSegunda(listA, listB);
        for (Integer num : listResultEj6) {
            System.out.print(num + " - ");
        }

        System.out.println("---------------------------------------------------");
        System.out.println("Pruebas para la Lista Doblemente Vinculada");
        MySimpleLinkedDoubleList<Integer> listDouble = new MySimpleLinkedDoubleList<>();

        Node<Integer> na1b = new Node<>(-3, null, null);
        Node<Integer> na2b = new Node<>(7, null, na1b);
        Node<Integer> na3b = new Node<>(4, null, na2b);
        Node<Integer> na4b = new Node<>(0, null, na3b);
        Node<Integer> na5b = new Node<>(10, null, na4b);

        listDouble.insertFront(na1b.getInfo());
        listDouble.insertFront(na2b.getInfo());
        listDouble.insertFront(na3b.getInfo());
        listDouble.insertFront(na4b.getInfo());
        listDouble.insertFront(na5b.getInfo());

        Iterator<Integer> it = listDouble.iterator();
        while (it.hasNext()){
            System.out.println(it.next() + " - ");
        }
        System.out.println("back1" + na2b.getBack());
        System.out.println("back2" + na4b.getBack());

    }

     /*
    Ejercicio 5
    Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
    suponiendo que:
    a) Las listas están desordenadas y la lista resultante debe quedar ordenada.
    b) Las listas están ordenadas y la lista resultante debe mantenerse ordenada.
     */

    // esta lista debe ordenarse si son letras o numeros?
    //implementar Comparator
    public static <T extends Comparable<T>> MySimpleLinkedList<T> construirOtraLista(
            MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2) {
        Iterator<T> tmp1 = l1.iterator();
        MySimpleLinkedList<T> result = new MySimpleLinkedList<>();

        while (tmp1.hasNext()) {
            T info1 = tmp1.next();
            Iterator<T> tmp2 = l2.iterator();

            while (tmp2.hasNext()) {
                T info2 = tmp2.next();
                if (info1.equals(info2)) { // Si son iguales lo agrego a la lista
                    result.insertarOrdenado(info1);
                }
            }
        }
        return result;
    }

    /*
    Ejercicio 6
    Escriba una función que dadas dos listas construya otra con los elementos que están en la
    primera pero no en la segunda.
    L1 = 1,2,3,4,5,6
    L2=1,4,6,
    RESULTADO= 2,3,5
     */

    //indexOf(T info) buscar si el elemento no esta en la lista con -1
    // sin duplicaos?
    // 1 2 5 9 8
    // 9 2 5
    public static <T extends Comparable<T>> MySimpleLinkedList<T> construirListaConElementosEnPrimeraYNoEnSegunda(
            MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2
    ){
        MySimpleLinkedList<T> result = new MySimpleLinkedList<>();
        Iterator<T> it = l1.iterator();
        boolean encontrado = false;

        while (it.hasNext()){
            Iterator<T> it2 = l2.iterator();
            T aux1 = it.next();
            while (it2.hasNext()) {
                T aux2 = it2.next();
                if (aux1.equals(aux2)) {
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado){
                result.insertFront(aux1);
            }
        }
        return result;
    }

    // si esya ordenada l2 podria,os cortar ANTES ya que lista1 es menor a lista2
    // para mejorar podemos cambiar la estructura, usar iterdaores
}
