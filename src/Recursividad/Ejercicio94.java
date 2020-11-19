/*
	Contar el número de campanadas que hay hasta la hora actual
 */

package Recursividad;

public class Ejercicio94 {

	public static void main(String[] args) {

		System.out.println(campanadasRecursiva(14));
		System.out.println(campanadasBucle(14));

	}

	private static int campanadasRecursiva(int number){

		if (number > 0){

			if (number > 12){

				return number - 12 + campanadasRecursiva(number - 1);

			}else{

				return number + campanadasRecursiva(number - 1);

			}

		}else{

			return 0;

		}

	}

	private static int campanadasBucle(int number){

		int cont = 0;

		for (int i = 1; i <= number; i++) {

			if (i > 12){

				cont += i - 12;

			}else{

				cont += i;

			}

		}

		return cont;

	}

}
