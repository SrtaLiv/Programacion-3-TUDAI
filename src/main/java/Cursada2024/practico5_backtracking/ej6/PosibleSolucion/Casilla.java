package practico5_backtracking.ej6.PosibleSolucion;

import java.util.Objects;

/**
 * Ejercicio 6. Caballo de Atila. Por donde pisa el caballo de Atila jam�s
 * vuelve a crecer el pasto. El caballo fue directamente hacia el jard�n de n x
 * n casillas. Empez� su paseo por una casilla cualquiera y volvi� a ella, es
 * decir hizo un recorrido cerrado. No visit� dos veces una misma casilla, se
 * movi� de una casilla a otra vecina en forma horizontal o vertical, pero nunca
 * en diagonal. Por donde pis� el caballo, el pasto jam�s volvi� a crecer. Luego
 * de terminado el recorrido en algunas casillas todav�a hab�a pasto (se�al de
 * que en ellas no hab�a estado el caballo). Escriba un algoritmo que deduzca el
 * recorrido completo que hizo el caballo.
 * 
 * @author Gentil Ricardo
 *
 */
public class Casilla {
	private String nombre;
	private int fila;
	private int columna;
	private boolean pisada;

	public Casilla(int f, int c) {
		super();
		this.nombre = "(" + f + "," + c + ")";
		this.fila = f;
		this.columna = c;
		this.pisada = false;
	}

	public String getNombre() {
		return nombre;
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public boolean isPisada() {
		return pisada;
	}

	public void setPisada(boolean pisada) {
		this.pisada = pisada;
	}

	@Override
	public String toString() {
		return this.nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Casilla other = (Casilla) obj;
		return Objects.equals(nombre, other.nombre);
	}

}
