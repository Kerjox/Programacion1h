/*
	El trimestre con más nacimientos
	Més que más defunciones y traslados fuera
	Cuantas personas hay nuevas y cunatas se han ido
 */
package Repaso;

import java.util.Arrays;

public class Ejercicio98 {

	public static void main(String[] args) {

		String[] movimientos = {"Nacimientos", "Defunciones", "Traslados Fuera", "Nuevos asentamientos"};
		int[][] movimientosPoblacion = {
				{3, 2, 0, 0},   // Enero
				{1, 5, 0, 1},   // Febrero
				{9, 4, 0, 0},   // ...
				{3, 8, 0, 0},
				{6, 1, 0, 0},
				{3, 2, 1, 0},
				{3, 12, 1, 0},
				{2, 3, 0, 1},
				{1, 7, 1, 1},
				{9, 2, 0, 0},
				{1, 5, 3, 0},
				{5, 8, 2, 1}
		};

		int trimestreMaxNacimientos = trimestreMaxNacimientos(movimientosPoblacion);

		System.out.printf("El trimestre con más nacimentos es el %dº \n\n", trimestreMaxNacimientos);

		int mesMasBajas = getMesMasBajas(movimientosPoblacion);

		System.out.printf("El més con más bajas ha sido es el %dº \n\n", mesMasBajas);

		balanceAnual(movimientosPoblacion);

	}

	private static void balanceAnual(int[][] movimientosPoblacion) {

		int nuevos = 0;
		int perdidos = 0;

		for (int[] ints : movimientosPoblacion) {

			nuevos += (ints[0] + ints[3]);
			perdidos += (ints[1] + ints[2]);

		}

		System.out.printf("Persona nuevas este año en el pueblo %d \n", nuevos);
		System.out.printf("Personas perdidas en el pueblo este año %d \n", perdidos);

		if (nuevos > perdidos){

			System.out.printf("El pueblo ha aumentado %d habitantes", nuevos - perdidos);

		}else {

			System.out.printf("El pueblo ha decrecido %d habitantes", perdidos - nuevos);

		}

	}

	private static int getMesMasBajas(int[][] movimientosPoblacion) {

		int[] bajas = new int[movimientosPoblacion.length];

		for (int i = 0; i < movimientosPoblacion.length; i++) {

			bajas[i] += (movimientosPoblacion[i][1] + movimientosPoblacion[i][2]);

		}

		System.out.println(Arrays.toString(bajas));

		return getMaxPos(bajas) + 1;

	}

	private static int trimestreMaxNacimientos(int[][] movimientosPoblacion) {

		int[] nacimientosPorTrimestre = new int[4];

		for (int i = 0; i < movimientosPoblacion.length; i++) {

			nacimientosPorTrimestre[i / 3] += movimientosPoblacion[i][0];

		}

		System.out.printf("%s \n", Arrays.toString(nacimientosPorTrimestre));

		return getMaxPos(nacimientosPorTrimestre) + 1;

	}

	private static int getMaxPos(int[] data) {

		int posMax = 0;

		for (int i = 1; i < data.length; i++) {

			if (data[i] > data[posMax]) {

				posMax = i;

			}

		}

		return posMax;

	}

}
