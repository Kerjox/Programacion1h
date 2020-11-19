/*
	Ley
 */


package Repaso;

import java.util.Arrays;

public class Ejercicio97 {

	public static void main(String[] args) {

		final String[] PARTIDOS = {"p.p.", "P.S.O.E.", "Podemos", "Ciudadanos", "VOX"};
		final int ESCANOS = 5;
		int[] votos = {119421, 157520, 57389, 46645, 91978};

		int[] escanosPartido = doDHondt(PARTIDOS, ESCANOS, votos);
		printResults(escanosPartido, PARTIDOS);

	}

	private static int[] doDHondt(String[] PARTIDOS, int ESCANOS, int[] votos) {

		int[] escanosPartido = new int[PARTIDOS.length];

		int[] dividendos = new int[votos.length];

		Arrays.fill(dividendos, 1);

		for (int i = 0; i < ESCANOS; i++) {

			int[] _votos = new int[votos.length];

			for (int j = 0; j < votos.length; j++) {

				_votos[j] = votos[j] / dividendos[j];

			}

			int maxPos = returnMaxPos(_votos);

			dividendos[maxPos] += 1;
			escanosPartido[maxPos] += 1;

		}

		return escanosPartido;
	}

	private static int returnMaxPos(int[] data) {

		int posMax = 0;

		for (int i = 0; i < data.length; i++) {

			if (data[i] > data[posMax]) {

				posMax = i;

			}

		}

		return posMax;

	}

	private static void printResults(int[] escanos, String[] partidos) {

		for (int i = 0; i < escanos.length; i++) {

			System.out.printf("El %s tiene %d escaños. \n", partidos[i], escanos[i]);

		}

	}

}
