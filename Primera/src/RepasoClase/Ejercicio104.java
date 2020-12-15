package RepasoClase;

public class Ejercicio104 {

	public static void main(String[] args) {

		int[] precios = {33, 150, 75, 60, 50, 17, 30};
		doExercise(precios);

	}

	private static void doExercise(int[] precios) {

		double[] preciosDescontados = new double[precios.length];
		int[] descuentosAplicados = new int[precios.length];

		for (int i = 0; i < precios.length; i++) {

			if (precios[i] <= 50){

				preciosDescontados[i] = precios[i] * 0.90;
				descuentosAplicados[i] = 10;

			}else if (precios[i] <= 100){

				preciosDescontados[i] = precios[i] * 0.20;
				descuentosAplicados[i] = 20;

			}else{

				preciosDescontados[i] = precios[i] * 0.70;
				descuentosAplicados[i] = 30;

			}

			System.out.printf("El producto %d que valia %d ahora vale %.2f con un descuento del %d porciento\n", i, precios[i], preciosDescontados[i], descuentosAplicados[i]);
		}

	}

}
