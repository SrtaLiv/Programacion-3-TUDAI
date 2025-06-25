package EjerciciosExtra.Recuperatorio2024;

import Cursada2024.practico2_1.ej1.TreeNode;

import java.util.List;

public class Ejercucio2 {
    List<T> result;
    private List<T> getLevel(TreeNode<T> n, int k){
        if (obtenerAlutra() > k){
            return result;
        }

        if (k == 0){
            result.insertfront(n.getIzq());
            result.insertFront(n.getDer());
            return result;
        }
        else{
            getLevel(n.getIzq(), k-1);
            getLevel(n.getDer(), k-1);
        }
        return result;
    }
}
