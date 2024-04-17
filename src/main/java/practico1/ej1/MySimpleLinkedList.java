package practico1.ej1;

public class MySimpleLinkedList<T> {
    /**
     * Implemente los métodos indicados del esqueleto de Lista desarrollado en Teoría (
     * void insertFront(T), T extractFront(), boolean isEmpty(), int size(),
     * String toString). Agregar también el método: T get(index).
     */

    private Node<T> first; //La referencia al primer nodo de mi lista vinculada.
    int size; //coviene para ahorrar espacio en el algoritmo si es q se necesita. Es mejor q estar reccorriendo O(n)
    int lastSize; //O(n)

    public MySimpleLinkedList() {
        this.first = null; //la lista esta vacia por eso ponemos null
        this.size = 0;
    }

    //METODOS
    public int size(){
        return this.size;
    }

    public void insertFront(T info){
        Node<T> tmp = new Node<T>(info, null); //Creo nodo temporal, el nulls significa que aun no apunta a ningun nodo.
        tmp.setNext(this.first); //el nodo tmp va a apuntar al primero de la lista.
        this.first = tmp; //lo actualizmaos
        this.size = this.size + 1; //se incrementa el tamaño de la lista vinculada en 1
    }


    //Acción de eliminar y devolver el primer elemento de la lista
    public T extractFront() {
        if (!this.isEmpty()) { // Verifica si la lista no está vacía
            T info = first.getInfo(); // Obtiene la información del primer nodo
            first = first.getNext(); // Actualiza el primer nodo al siguiente nodo, para que apunte al siguiente nodo en la lista
            this.size--; // Decrementa el tamaño de la lista
            return info; // Retorna la información del primer nodo extraído
        }
        return null; // Retorna null si la lista está vacía
    }

    public boolean isEmpty(){
        return this.size == 0 && this.first == null;
    }


    public T get(int index) {
        if (!isEmpty() && size() > index) {
            Node<T> tmp = this.first;
            for (int i = 0; i <= index && tmp != null; i++) {
                if (i == index) {
                    return tmp.getInfo();
                }
                tmp = tmp.getNext();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "MySimpleLinkedList{" +
                "first=" + first +
                ", size=" + size +
                ", lastSize=" + lastSize +
                '}';
    }
}
