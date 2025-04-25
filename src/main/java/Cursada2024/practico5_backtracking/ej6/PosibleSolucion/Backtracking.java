package Cursada2024.practico5_backtracking.ej6.PosibleSolucion;

import java.util.ArrayList;
import java.util.List;

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
public class Backtracking {

	private Jardin jardin;

	public Backtracking(Jardin jardin) {
		this.jardin = jardin;
	}

	public List<List<Casilla>> getCaminoDelCaballoDeAtila(Casilla inicio) {
		List<List<Casilla>> caminos = new ArrayList<List<Casilla>>();
		List<Casilla> camino = new ArrayList<Casilla>();
		List<Casilla> casillasADondePuedoIrDesde = jardin.casillasADondePuedoIrDesde(inicio);
		for (Casilla casilla : casillasADondePuedoIrDesde) {
			if (!camino.contains(casilla)) {
				_getCaminoDelCaballoDeAtila(casilla, inicio, camino, caminos);
			}
		}
		return caminos;
	}

	private void _getCaminoDelCaballoDeAtila(Casilla casilla_actual, Casilla casilla_final, List<Casilla> camino,
			List<List<Casilla>> caminos) {
		camino.add(casilla_actual);
		if (camino.contains(casilla_actual) && casilla_actual.equals(casilla_final)) {
			caminos.add(new ArrayList<Casilla>(camino));
		} else {
			List<Casilla> casillasADondePuedoIrDesde = jardin.casillasADondePuedoIrDesde(casilla_actual);
			for (Casilla casilla : casillasADondePuedoIrDesde) {
				if (!camino.contains(casilla)) {
					_getCaminoDelCaballoDeAtila(casilla, casilla_final, camino, caminos);
				}
			}
		}
		camino.remove(camino.size() - 1);
	}

	public List<Casilla> getCaminoPosible() {
		List<Casilla> yaPaso = new ArrayList<Casilla>();
		Casilla inicio = jardin.getCasilla(0, 0);
		return _getCaminoPosible(inicio, yaPaso);
	}

	private List<Casilla> _getCaminoPosible(Casilla casilla_actual, List<Casilla> yaPaso) {
		if (!casilla_actual.isPisada()) {
			Casilla casilla = jardin.siguienteCasilla(casilla_actual);
			return _getCaminoPosible(casilla, yaPaso);
		} else {
			// Encontr� una pisada
			yaPaso.add(casilla_actual);
			List<Casilla> casillas_siguientes = jardin.casillasSiguientesPisadas(casilla_actual, yaPaso);
			for (Casilla casilla_siguiente : casillas_siguientes) {
				return _getCaminoPosible(casilla_siguiente, yaPaso);
			}
		}
		return yaPaso;
	}

}
