package Recursividad;

public class Ejercicio93 {

	public static void main(String[] args) {

		followTraces(5);

	}

	private static void followTraces(int n){

		if (n > 0){

			System.out.printf("Ejecución %d \n", n);
			followTraces(n - 1);
			System.out.printf("Ejecución %d \n", n);

		}

	}

}
