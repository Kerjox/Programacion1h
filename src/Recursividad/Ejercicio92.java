/*
	Factorial de un numero con recursividad
 */

package Recursividad;

import java.math.BigInteger;

public class Ejercicio92 {

	public static void main(String[] args) {

		BigInteger factorial = new BigInteger("5");

		System.out.printf("El factorial de %d es: %d", factorial, factorialRecursiva(factorial));

	}

	private static BigInteger factorialRecursiva(BigInteger number){

		if (number.compareTo(BigInteger.valueOf(2)) > 0){

			return number.multiply(factorialRecursiva(number.subtract(BigInteger.valueOf(1))));

		}else{

			return number;

		}

	}

}
