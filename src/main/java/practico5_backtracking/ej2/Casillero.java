package practico5_backtracking.ej2;

import java.util.ArrayList;

public class Casillero {
    boolean up;
    boolean right;
    boolean down;
    boolean left;
    int costo;
    ArrayList<Casillero> vecinos;

    public Casillero(boolean up, boolean right, boolean down, boolean left, int costo) {
        this.up = up;
        this.right = right;
        this.down = down;
        this.left = left;
        this.costo = costo;
        this.vecinos = new ArrayList<>();
    }

    public ArrayList<Casillero> getVecinos() {
        return vecinos;
    }

    public void addVecino(Casillero casillero){
        vecinos.add(casillero);
    }

    public void setVecinos(ArrayList<Casillero> vecinos) {
        this.vecinos = vecinos;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Casillero{" +
                "top=" + up +
                ", right=" + right +
                ", down=" + down +
                ", left=" + left +
                ", costo=" + costo +
                '}';
    }
}
