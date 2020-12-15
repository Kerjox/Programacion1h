/*
	Invertir texto "Java desde cero"
 */

package repasoSolo;

public class Ejercicio02 {

	public static void main(String[] args) {

		String data = "Java desde 0";
		String solve = "";

		for (int i = data.length() - 1; i >= 0; i--) {

			solve += Character.toString(data.charAt(i));

		}

		System.out.println(solve);
	}
}
