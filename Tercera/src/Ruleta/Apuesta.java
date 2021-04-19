package Ruleta;

import java.util.ArrayList;

public class Apuesta {

	private final int value;
	private final ArrayList<Casilla> casillasApostadas;

	public Apuesta(int value, ArrayList<Casilla> casillasApostadas) {

		this.value = value;
		this.casillasApostadas = casillasApostadas;
	}

	public Integer getProfit(int number) {

		for (Casilla casilla : this.casillasApostadas) {

			if (casilla.getValue() == number) {

				return this.value * (36 / this.casillasApostadas.size());
			}
		}

		return this.value * -1;
	}

}
