public class Ejercicio02 {

	public static void main(String[] args) {

		int[] mediasHistoricas = {6, 8, 4, 9, 7};
		int[][] notasAlumnos = {
				{4, 1, 7, 10, 7},
				{7, 7, 7, 7, 7},
				{10, 10, 10, 10, 10},
				{3, 4, 2, 3, 5}

		};
		String[] nombres = {"Pepe", "Julian", "Daniel", "Juan"};
		String[] asignaturas = {"BBDD", "Entornos", "Programación", "Marcas", "Sistemas Informáticos"};

		System.out.println("--------------------\n A:");
		printAlumnosSuperiorMedia(mediasHistoricas, notasAlumnos, nombres, asignaturas);
		System.out.println("--------------------\n B:");
		printAsignaturaMediaInferior(mediasHistoricas, notasAlumnos, nombres, asignaturas);
		System.out.println("--------------------\n C:");
		porcentajeNotaMedia(mediasHistoricas, notasAlumnos, nombres);
		System.out.println("--------------------\n D:");
		printVeredictoFinal(mediasHistoricas, notasAlumnos);

	}

	private static void printAlumnosSuperiorMedia(int[] medias, int[][] notas, String[] alumnos, String[] asignaturas) {

		for (int i = 0; i < notas.length; i++) {

			for (int j = 0; j < notas[0].length; j++) {

				if (notas[i][j] > medias[j]) {

					System.out.printf("El alumno %s ha sacado un %d en %s, y la media era de %d \n", alumnos[i], notas[i][j], asignaturas[j], medias[j]);

				}
			}
		}
	}

	private static void printAsignaturaMediaInferior(int[] medias, int[][] notas, String[] alumnos, String[] asignaturas) {

		for (int i = 0; i < notas[0].length; i++) {

			for (int j = 0; j < notas.length; j++) {

				if (notas[j][i] < medias[i]) {

					System.out.printf("En %s, %s no ha superado la media de %d con un %d\n", asignaturas[i], alumnos[j], medias[i], notas[j][i]);

				}
			}
		}
	}

	private static void porcentajeNotaMedia(int[] medias, int[][] notas, String[] alumnos) {

		int sumaNotasMediasHistoricas = 0;

		for (int datum : medias) {

			sumaNotasMediasHistoricas += datum;

		}

		for (int i = 0; i < notas.length; i++) {

			int notasMediasAlumno = 0;

			for (int j = 0; j < notas[0].length; j++) {

				notasMediasAlumno += notas[i][j];

			}

			System.out.printf("El porcentaje de la nota media de %s con respecto a la historica es del %.2f porciento \n", alumnos[i], (float) notasMediasAlumno / sumaNotasMediasHistoricas * 100);

		}
	}

	private static void printVeredictoFinal(int[] medias, int[][] notas){

		int mediasAlumnos = 0;
		int mediasTotal = 0;

		for (int media : medias) {

			mediasTotal += media;

		}

		mediasTotal *= notas.length;

		for (int[] nota : notas) {

			for (int j = 0; j < notas[0].length; j++) {

				mediasAlumnos += nota[j];

			}
		}

		if (mediasAlumnos / mediasTotal * 100 < 100) {

			System.out.printf("Los alumnos estan peor preparados que los años anteriores \n Los años anteriores la media era de %d y este año ha sido de %d", mediasTotal, mediasAlumnos);

		}else{

			System.out.printf("Los alumnos estan mejor preparados que los años anteriores \n Los años anteriores la media era de %d y este año ha sido de %d", mediasTotal, mediasAlumnos);

		}
	}
}