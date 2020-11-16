/*
	Poner la frase al reves
 */
package Strings;

public class Ejercicio87 {

	public static void main(String[] args) {

		String sentence1 = "Había una vez un circo";
		String solve = "";

		for (int i = sentence1.length(); i > 0; i--) {

			solve = solve.concat(sentence1.substring(i - 1, i));
			//solve = solve.concat(Character.toString(sentence1.charAt(i)));

		}

		System.out.println(solve);

	}

}
