/*
	Ley
 */


package RepasoClase;

public class Ejercicio97 {

	public static void main(String[] args) {

		final String[] PARTIDOS = {"p.p.", "P.S.O.E.", "Podemos", "Ciudadanos", "VOX"};
		final int ESCANOS = 7;
		int[] votos = {119421, 157520, 57389, 46645, 91978};

		int[] escanosPartidos = doDHondt(PARTIDOS.length, ESCANOS, votos);
		printResults(escanosPartidos, PARTIDOS);

	}

	private static int[] doDHondt(int numPartidos, int ESCANOS, int[] votos) {

		int[] escanosPartido = new int[numPartidos];

		for (int i = 0; i < ESCANOS; i++) {

			int[] _votos = new int[votos.length];

			for (int j = 0; j < votos.length; j++) {

				_votos[j] = votos[j] / (escanosPartido[j] + 1);

			}

			escanosPartido[getMaxPos(_votos)]++;

		}

		return escanosPartido;
	}

	private static int getMaxPos(int[] data) {

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
