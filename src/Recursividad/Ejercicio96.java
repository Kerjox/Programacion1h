/*
	Transformar un número a binario
 */
package Recursividad;

public class Ejercicio96 {

	public static void main(String[] args) {

		int number = 8;
		toBinary(number);

	}

	private static void toBinary(int number){

		if (number != 0){

			toBinary(number / 2);
			System.out.print(number % 2);

		}

	}

}
