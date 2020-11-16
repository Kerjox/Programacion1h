/*
	Eliminar los espacios de mas entre las palabras
 */

package Strings;

public class Ejercicio89 {

	public static void main(String[] args) {

		String sentence1 = "Había              una               vez               un               circo";
		boolean firstSpace = true;
		int pos = 0;

		for (int i = 0; i < sentence1.length(); i++) {

			if (sentence1.charAt(i) == ' ') {

				if (firstSpace) {

					pos = i;
					firstSpace = false;

				}else{

					int k = i;

					while (sentence1.charAt(k) == ' ') {

						k++;

					}

					sentence1 = sentence1.substring(0, pos).concat(sentence1.substring(k - 1));
					firstSpace = true;

				}

			}

		}

		System.out.println(sentence1);

	}

}
