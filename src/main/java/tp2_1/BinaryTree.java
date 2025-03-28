package tp2_1;

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
    }*/

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

    // private void insert(Integer num, Node root)

    public void add(Integer num){
        Node<Integer> insert = new Node<>(null, null, num);
        if (this.isEmpty()){
            root = insert;
            return;
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

            } else {
                   if (num < root.getInfo()){
                       if (root.getIzq() == null){
                           root.setIzq(new Node<>(null, null, num));
                       }
                       else{
                           insert(num, root.getIzq());
                       }
                   }
            }
    }


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
}
