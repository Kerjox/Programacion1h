package Recursividad;

public class Ejercicio95 {

	public static void main(String[] args) {

		String[] medidas = {"Unidades", "Decenas", "Centenas", "Unidades de millar", "Decenas de millar", "Centenas de millar"};
		int numero = 256809;
		doExercise(numero, medidas);
		System.out.println("");
		doExerciseRecursive(numero, medidas, 0);

	}

	private static void doExercise(int number, String[] medidas){

		int index = 0;

		while(number > 0){

			System.out.printf("%d:%s ",number % 10, medidas[index++]);

			number /= 10;

		}

	}

	private static void doExerciseRecursive(int number, String[] medidas, int index){

		if(number > 0){

			doExerciseRecursive(number / 10, medidas, ++index);
			System.out.printf("%d:%s ",number % 10, medidas[index - 1]);

		}

	}

}
