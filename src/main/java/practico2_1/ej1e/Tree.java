package practico2_1.ej1e;

import java.util.ArrayList;

public class Tree {
    TreeNode raiz;

    public Tree() {
        this.raiz = null;
    }

    public Integer getRoot(){
        if (this.raiz != null) {
            return this.raiz.getValor();
        }
        else return null;
    }

    public boolean hasElem(Integer num){
        return find(this.raiz, num) != null;
    }

    private TreeNode find(TreeNode node, Integer value){
        if (node == null || node.getValor() == value){
            return node;
        }

        if (value < node.getValor()) {
            return find(node.getIzq(), value);
        } else {
            return find(node.getDer(), value);
        }
    }

    public boolean isEmpty(){
        return this.raiz == null;
    }

    public int getHeight() {
        return getHeight(raiz);
    }

    private int getHeight(TreeNode nodo) {
        if (nodo == null) {
            return -1; // Altura de un nodo nulo es -1
        }

        int alturaIzq = getHeight(nodo.getIzq());
        int alturaDer = getHeight(nodo.getDer());

        return 1 + Math.max(alturaIzq, alturaDer); // La altura del nodo es 1 más el máximo de las alturas de los subárboles izquierdo y derecho
    }
    //Recorridos
    public void printPreOrder(){
        printPreOrder(raiz);
    }

    private void printPreOrder(TreeNode node){
        if (node != null) {
            System.out.println(node.getValor() + " ");
            printPreOrder(node.getIzq());
            printPreOrder(node.getDer());
        }
    }

    public void printPosOrder(){
        printPosOrder(raiz);
    }

    private void printPosOrder(TreeNode nodo){
        if (nodo != null){
            printPosOrder(nodo.getIzq()); // Llamada recursiva para el subárbol izquierdo
            printPosOrder(nodo.getDer()); // Llamada recursiva para el subárbol derecho
            System.out.println(nodo.getValor() + " ");
        }
    }
    public void printInOrder(){
        printInOrder(raiz);
    }

    private void printInOrder(TreeNode nodo){
        if (nodo != null){
            printInOrder(nodo.getIzq()); // Recorre el subárbol izquierdo en inorden
            System.out.println(nodo.getValor() + " "); // Imprime el valor del nodo actual
            printInOrder(nodo.getDer()); // Recorre el subárbol derecho en inorden
        }
    }


    //public List getLongestBranch()
    //List getFrontera()
    //Integer getMaxElem(),
    // List getElemAtLevel(int)


    /*
    El método add(int valor) permite agregar elementos al árbol.
    El método add(TreeNode nodo, int valor) es un método auxiliar que se llama recursivamente
     para encontrar la posición adecuada para insertar un nuevo valor en el árbol.

     */
    private void add(TreeNode nodo, int valor) {
        if (nodo.getValor() > valor) {
            if (nodo.getIzq() == null) {
                TreeNode temp = new TreeNode(valor);
                nodo.setIzq(temp);
            } else {
                add(nodo.getIzq(),valor);
            }
        } else if (nodo.getValor() < valor) {
            if (nodo.getDer() == null) {
                TreeNode temp = new TreeNode(valor);
                nodo.setDer(temp);
            } else {
                add(nodo.getDer(),valor);
            }
        }
    }
    public void add(int valor) {
        if (this.raiz == null)
            this.raiz = new TreeNode(valor);
        else
            this.add(this.raiz, valor);
    }

    public ArrayList<Integer> getLongestBranch(){
        if(!this.isEmpty()){
            return this.getLongestBranch(this.raiz);
        }else{
            return null;
        }
    }

    private ArrayList<Integer> getLongestBranch(TreeNode node){

        if(node == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> izq = this.getLongestBranch(node.getIzq());
        ArrayList<Integer> der = this.getLongestBranch(node.getDer());

        ArrayList<Integer> longestBranch = new ArrayList<>();
        longestBranch.add(node.getValor()); // Agrega la raíz
        // Comparamos las longitudes de las ramas izquierda y derecha

        if (der.size() > izq.size()) {
            longestBranch.addAll(der); // Agrega la rama más larga de la derecha
            return longestBranch;
        } else {
            longestBranch.addAll(izq); // Agrega la rama más larga de la izquierda
            return longestBranch;
        }
    }

    public ArrayList<Integer> getElemAtLevel(int nivel){
        if(!this.isEmpty()){
            return this.getElemAtLevel(this.raiz, nivel, 0);
        }else{
            return null;
        }
    }

    private ArrayList<Integer> getElemAtLevel(TreeNode node, int nivel, int nivelActual){

        if(node == null){
            return new ArrayList<>();
        }

        if(nivelActual == nivel){

            ArrayList<Integer> num = new ArrayList<>();
            num.add(node.getValor());
            return num;

        }else {

            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(this.getElemAtLevel(node.getIzq(), nivel, nivelActual + 1));
            list.addAll(this.getElemAtLevel(node.getDer(), nivel, nivelActual + 1));
            return list;

        }

    }

    public Integer getMaxElem(){
        if(this!=null){
            return this.getMaxElem(this.raiz);
        }else{
            return null;
        }
    }

    private Integer getMaxElem(TreeNode node){

        if(node.getDer() != null) {
            if (node.getDer().getValor() > node.getValor()) {
                return this.getMaxElem(node.getDer());
            }
        }
        return node.getValor();
    }


}
