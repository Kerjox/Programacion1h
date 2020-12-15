/*
	Multiplicación mediante sumas, con recursividad.
 */

package Recursividad;

public class Ejercicio91 {

	public static void main(String[] args) {

		System.out.printf("La multiplicación de 5 por 5 es: %d \n", multiplicacionRecursiva(5, 5));

		System.out.printf("La divición de 20 para 5 es: %d \n", dividirRecursiva(20, 5));

	}

	private static int multiplicacionRecursiva(int number, int multiplyBy){

		if(multiplyBy > 1){

			return number + multiplicacionRecursiva(number, multiplyBy - 1);

		}else{

			return number;

		}

	}

	private static int dividirRecursiva(int number, int div){

		if (number >= div){

			return 1 + dividirRecursiva(number - div, div);

		}else{

			return 0;

		}

	}

}
