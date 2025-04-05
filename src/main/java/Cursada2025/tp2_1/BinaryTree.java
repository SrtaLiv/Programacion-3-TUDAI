package Cursada2025.tp2_1;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTree<T> {

    private Node<Integer> root;
    private int size;

    public BinaryTree() {
        this.root = null;
    }

    public Node<Integer> getRoot() {
        return root;
    }

    public void setRoot(Node<Integer> root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    // aclarar que es ese N, altura del arbol?


    public boolean hasElem(int num) {
        if (root != null && root.getInfo() == num) {
            return true;
        }
        Node<Integer> cursor = root;
        while (cursor.getDer() != null || cursor.getIzq() != null) {
            if (num > cursor.getInfo()) {
                if (cursor.getDer() != null && cursor.getDer().getInfo() == num) {
                    return true;
                }
                if (cursor.getDer() == null) {
                    break;
                }
                cursor = cursor.getDer(); // apunta al proximo
            }
            else if (num < cursor.getInfo()) {
                if (cursor.getIzq() != null && cursor.getIzq().getInfo() == num) {
                    return true;
                }
                if (cursor.getIzq() == null){
                    break;
                }
                cursor = cursor.getIzq();
            }
        }
        return false;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void add(Integer num){
        Node<Integer> insert = new Node<>(null, null, num);
        if (this.isEmpty()){
            root = insert;
        }
        else{
            insert(num, root);
        }
    }

    private void insert(Integer num, Node<Integer> root) {
            if (num > root.getInfo()) {
                if (root.getDer() == null){
                    root.setDer(new Node<>(null, null, num));
                }
                else{
                    insert(num, root.getDer());
                }

            } else
                if (num < root.getInfo()){
                       if (root.getIzq() == null){
                           root.setIzq(new Node<>(null, null, num));
                       }
                       else{
                           insert(num, root.getIzq());
                       }
            }
    }


    // cantidad de arcos hasta la hoja mas lejana. Empieza en 0
    public int getHeight(){
        if (isEmpty()){
            return 0;
        }
        AtomicInteger alturaAux = new AtomicInteger(0);
//      getHeightP(root, 0,alturaAux);
//      return alturaAux.get();
        return getHeightRecursivo(root);
    }

   private void getHeightP(Node<Integer> cursor, int suma, AtomicInteger alturaAux){
        if (cursor.getIzq() != null || cursor.getDer() != null){
            suma++;
            if(suma > alturaAux.get()){ // si la altura de esa rama es mayor, esa es la altura
                alturaAux.set(suma);
            }

            if (cursor.getIzq() != null)
                getHeightP(cursor.getIzq(), suma, alturaAux);
            if (cursor.getDer() != null)
                getHeightP(cursor.getDer(), suma, alturaAux);
        }
    }

    private int getHeightRecursivo(Node<Integer> cursor){
        if (cursor.getIzq() == null && cursor.getDer() == null){
            return 0;
        }
        else {
            int izq = 0;
            int der = 0;
            if (cursor.getIzq() != null) {
                izq = getHeightRecursivo(cursor.getIzq()) + 1;
            }
            if (cursor.getDer() != null) {
                der = getHeightRecursivo(cursor.getDer()) + 1;
            }
            return Math.max(izq, der);
        }
    }


    // get longest branch cantidad de arcos
    public ArrayList<Integer> getLongestBranch() {
        return getLongestBranchP(this.getRoot());
    }

    private ArrayList<Integer> getLongestBranchP(Node<Integer> cursor) {
        if (cursor == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> leftBranch = getLongestBranchP(cursor.getIzq());
        ArrayList<Integer> rightBranch = getLongestBranchP(cursor.getDer());

        // Elegimos la rama más larga y agregamos el nodo actual al inicio
        if (leftBranch.size() > rightBranch.size()) {
            leftBranch.add(0, cursor.getInfo());
            return leftBranch;
        } else {
            rightBranch.add(0, cursor.getInfo());
            return rightBranch;
        }
    }

    // IMPRIMIR GUIONCITOS CUANDO HAY NULL
    public void printPreOrder(Node<Integer> cursor){
        if (cursor == null){
            return;
        }
        System.out.print(cursor.getInfo());
        printPreOrder(cursor.getIzq());
        printPreOrder(cursor.getDer());
    }

    public void printInOrder(Node<Integer> cursor){
        if (cursor == null){
            return;
        }
        printPreOrder(cursor.getIzq());
        System.out.print(" - ");
        System.out.print(cursor.getInfo() + " -");
        printPreOrder(cursor.getDer());
    }
    public void printPosOrder(Node<Integer> cursor){
        if (cursor == null){
            return;
        }
        printPosOrder(cursor.getIzq());
        printPosOrder(cursor.getDer());
        System.out.print(cursor.getInfo() + "-");
    }

    // rama mas larga, lista de vlaores que compone la rama mas larga.
    // La lista e valores que tienen los nodos. Lista al reves NO!

    // GET FRONTERA, todos los valores de las hojas!! NO NODOS.
    // izquierda a derecha
    public ArrayList<Integer> listGetFrontera(){
        return listGetFronteraP(getRoot());
    }

    private ArrayList<Integer> listGetFronteraP(Node<Integer> root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        if (root.getIzq() == null && root.getDer() == null){ //es hoja
            list.add(root.getInfo());
            return list;
        }

        // Si no es una hoja, seguir buscando en los hijos..
        listGetFronteraP(root.getDer());
        listGetFronteraP(root.getIzq());

        return list;
    }

    public void printPreOrderV1(Node<Integer> cursor) {
        if (cursor == root) {
            System.out.println(root.getInfo() + "-");
        }

        if (root.getIzq() == null || root.getDer() == null) {
            System.out.println("--");
        } else if (cursor.getIzq() != null) {
            System.out.println(cursor.getIzq().getInfo() + "-");
            printPreOrderV1(cursor.getIzq());
        }
        if (cursor.getDer() != null) {
            System.out.println(cursor.getDer().getInfo() + "-");
            printPreOrderV1(cursor.getDer());
        }
    }

    // obtener valor mas grande, derecha de todo. Se puede sin recursion
    public int getMaxElem(){
        while(root.getDer()!=null){
            root = root.getDer();
        }
        return root.getInfo();
    }

    //pide que devuelvas una lista con todos los nodos que están en un nivel específico del árbol.
    public ArrayList<Integer> getElemAtLevel(int level){
        int count = 1;
        ArrayList<Integer> list = new ArrayList<>();
        if (getRoot() != null && level == 1){
            list.add(root.getInfo());
            return list;
        }
        else{
            list = getElemAtLevelP(level, count, getRoot()); //tengo que pedirle los hijos al padre!!
            // si pongo nivel 2, en realidad deberia preguntar si el nivel es 1 y este tiene hijos agregarlos.
        }
        return list;
    }

    private ArrayList<Integer> getElemAtLevelP(int level, int count, Node<Integer> cursor) {
        ArrayList<Integer> list = new ArrayList<>();

        if (cursor == null){
            return new ArrayList<>();
        }

        if (level == count){ // Si encontro el nivel..
            // no hace falta porque ya estoy recorriendo el hijo de la izquierda y derecha en cada llamado recurisvo!!
//            int izq = cursor.getIzq().getInfo();
//            int der = cursor.getDer().getInfo();


//            if (cursor.getIzq() != null) {
//                list.add(izq);
//            }
//            if (cursor.getDer()!=null) {
//                list.add(der);
//            }
            list.add(cursor.getInfo());
            System.out.println("agrego a la lista");
            return list;
        }

        list.addAll(getElemAtLevelP(level, count+1, cursor.getIzq()));
        list.addAll(getElemAtLevelP(level, count+1, cursor.getDer()));

        return list;
    }


    public void delete(int num) {
        if (root == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        if (root.getInfo() == num) {
            // Manejar la raíz
            if (root.getIzq() == null && root.getDer() == null) {
                root = null;  // Si la raíz no tiene hijos, se elimina
            } else if (root.getIzq() == null || root.getDer() == null) {
                root = (root.getIzq() != null) ? root.getIzq() : root.getDer();
            } else {
                // Si la raíz tiene dos hijos, encontrar un reemplazante
                Node<Integer> reemplazante = buscarReemplazante(root);
                root.setInfo(reemplazante.getInfo());
                deleteNode(reemplazante.getInfo(), root);
            }
            System.out.println("Nodo eliminado");
            return;
        }
        deleteNode(num, root);
    }

    // si lo encontro uy lo botto

    private boolean deleteNode(int num, Node<Integer> padre) {
        if (padre == null) {
            return true; // Si el nodo es null, no hay nada que eliminar
        }

        if (num < padre.getInfo()) {
            return deleteNode(num, padre.getIzq());  // Recursivamente buscamos en el subárbol izquierdo
        } else if (num > padre.getInfo()) {
            return deleteNode(num, padre.getDer());  // Recursivamente buscamos en el subárbol derecho
        }

        Node<Integer> nodoEliminar = num < padre.getInfo() ? padre.getIzq() : padre.getDer();

        if (padre.getInfo() == num){
                System.out.println("Nodo encontrado");
                // Caso 1: no tiene hijos
                if (padre.getIzq() == null && padre.getDer() == null) {
                    System.out.println("Eliminando el nodo sin hijos: " + num);
                    padre = null;
                }

                // Caso 2: tiene 1 hijo, padre apunta a nieto
                else if (padre.getIzq() == null || padre.getDer() == null) {
                    System.out.println("Tiene 1 hijos");
                    if (padre.getIzq()!=null){
                        padre.setIzq(nodoEliminar);
                    }
                    else {
                        padre.setDer(nodoEliminar);
                    }
                }

                // Caso 3: tienen 2 hijos
                else {
                    System.out.println("Tiene 2 hijos");
                    Node<Integer> reemplazante = buscarReemplazante(padre); // 1 der, todo izq.
                    padre.setInfo(reemplazante.getInfo()); // padre toma valor de reemplazante
                    deleteNode(reemplazante.getInfo(), padre.getDer());  // Eliminamos el reemplazante
                }

        }

        return true; // Devolvemos el nodo actual (puede haber cambiado)
    }

    private Node<Integer> buscarReemplazante(Node<Integer> padre) {
        Node<Integer> der = padre.getDer();
        Node<Integer> izq = der.getIzq();
        if(izq==null){
            return der;
        }
        while (izq!=null){
            izq = izq.getIzq();
        }
        return izq;
    }

         /*
    Ejercicio 2
    Dado un árbol binario de búsquedas que almacena números enteros, implementar un algoritmo
    que retorne la suma de todos los nodos internos del árbol.
     */

    public void sumarNodosInternos(){
        int count = 0;
        count += sumarNodos(getRoot());
        System.out.println(count);
    }

    public int sumarNodos(Node<Integer> cursor){
        if (cursor == null){
            return 0;
        }
        if (cursor.getDer() == null && cursor.getIzq() == null){// hoja
            return 0;
        }
        int aux = cursor.getInfo();

        aux += sumarNodos(cursor.getIzq());
        aux += sumarNodos(cursor.getDer());
        return aux;
    }
    /*
    Ejercicio 3
    Dado un árbol binario de búsqueda que almacena números
    enteros y un valor de entrada K, implementar un algoritmo
    que permita obtener un listado con los valores de todas las
    hojas cuyo valor supere K. Por ejemplo, para el árbol de la
    derecha, con un valor K = 8, el resultado debería ser [9, 11].
    */
    public void sumarHojas(int k){
        ArrayList<Integer> result = new ArrayList<>(recorrerHojas(this.getRoot(), k));
        System.out.println(result);
    }

    private ArrayList<Integer> recorrerHojas(Node<Integer> cursor, int k){
        ArrayList<Integer> hojas = new ArrayList<>();
        if (cursor == null) return hojas;  // caso base

        if (cursor.getIzq() == null && cursor.getDer() == null){
            if (cursor.getInfo() > k){
                 hojas.add(cursor.getInfo());
            }
        }
            //MAL -> recorrerHojas(cursor.getIzq(), k);  lo estás llamando, pero no usás su resultado
            hojas.addAll(recorrerHojas(cursor.getIzq(), k));  // lo estás llamando, pero no usás su resultado
            hojas.addAll(recorrerHojas(cursor.getDer(), k));

        return hojas;
    }


    // CODIGOS QUE NO SIRVEN :( //

    /*public void insert(Integer num){
        Node<Integer> insert = new Node<>(null, null, num);
        if (this.isEmpty()){
            //root.setInfo(num); mal pq root es null
            root = insert;
            return;
        }

            if (num > root.getInfo()){
                Node<Integer> auxDer = root.getDer();

                if (auxDer == null){
                    root.setDer(insert);
                    return;
                }
              //  while (auxDer.getDer() != null || auxDer.getIzq() != null){ pq me lo quita?!
                while (auxDer.getDer() != null || auxDer.getIzq() != null){
                   if (num > auxDer.getInfo()){
                       if (auxDer.getDer() == null) break;
                      // paso al siguiente
                       auxDer = auxDer.getDer();
                   }
                   else if (num < auxDer.getInfo()){
                       // paso al siguiente
                       if (auxDer.getIzq() == null) break;
                       auxDer = auxDer.getIzq();
                   }
                   // como hago una vez q corta el while para
                    //reconocer si lo inserta izq o der
                }
                if (num > auxDer.getInfo()){
                    auxDer.setDer(insert);
                }
                else {
                    auxDer.setIzq(insert);
                }
            }

            // Insertar en el subárbol izquierdo
            else {
                Node<Integer> auxIzq = root.getIzq();

                if (auxIzq == null) {
                    root.setIzq(insert);
                    return;
                }

                while (auxIzq.getDer() != null || auxIzq.getIzq() != null) {
                    if (num > auxIzq.getInfo()) {
                        if (auxIzq.getDer() == null) break;
                        auxIzq = auxIzq.getDer();
                    } else {
                        if (auxIzq.getIzq() == null) break;
                        auxIzq = auxIzq.getIzq();
                    }
                }

                if (num > auxIzq.getInfo()) {
                    auxIzq.setDer(insert);
                } else {
                    auxIzq.setIzq(insert);
                }
            }
    }*/

     /*public boolean hasElem(Integer num){
        Node<Integer> der = root.getDer();
        Node<Integer> izq = root.getIzq();
        if (root.getInfo() == num){
            return true;
        }
        if (num < root.getInfo()){
            if (izq.getInfo() == num){
                return true;
            }
            Node<Integer> izquierda = izq.getIzq();
            Node<Integer> derecha  = izq.getDer();
            while (izquierda != null || derecha != null){
                if (izquierda.getInfo() == num || derecha.getDer().getInfo() == num){
                    return true;
                }
                // luego izq.getDer deberia cambiar de lugar con el hijo
                izquierda = izq.getIzq().getIzq();
                derecha  = izq.getDer().getDer();
            }
        }
        if (num > root.getInfo()){
            if (der.getInfo() == num){
                return true;
            }
            Node<Integer> izquierda = der.getIzq();
            Node<Integer> derecha  = der.getDer();
            while (izquierda != null || derecha != null){
                if (izquierda.getInfo() == num || derecha.getDer().getInfo() == num){
                    return true;
                }
                // luego izq.getDer deberia cambiar de lugar con el hijo
                izquierda = izq.getIzq().getIzq();
                derecha  = izq.getDer().getDer();
            }
        }
        return false;
    }

       /*
    }*/


}