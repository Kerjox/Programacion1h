/*
	Factorial de un numero con recursividad
 */

package Recursividad;

public class Ejercicio92 {

	public static void main(String[] args) {

		int factorial = 5;

		System.out.printf("El factorial de %d es: %d", factorial, factorialRecursiva(factorial));

	}

	private static int factorialRecursiva(int number){

		if (number > 1){

			return number * factorialRecursiva(number - 1);

		}else{

			return number;

		}

	}

}
