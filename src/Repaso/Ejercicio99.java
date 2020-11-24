/*
	Añadir una s al final de cada palabra que termine po vocal
 */
package Repaso;

import java.util.Arrays;

public class Ejercicio99 {

	public static void main(String[] args) {

		char[] sentence = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'l', 'a', ' ', 'm', 'a', 'n', 'c', 'h', 'a' ,' '};
		String sentence2 = "En un lugar de la mancha";

		doExerciseChar(sentence);

		doExerciseString(sentence2);

	}

	private static void doExerciseChar(char[] sentence) {

		char[] charMod = new char[sentence.length + numberOfVocals(sentence)];

		for (int i = 0; i < sentence.length; i++) {

			charMod[i] = sentence[i];

		}

		for (int i = 0; i < charMod.length; i++) {

			if (charMod[i] == ' '){

				if (charMod[i - 1] == 'a' || charMod[i - 1] == 'e' || charMod[i - 1] == 'i' || charMod[i - 1] == 'o' || charMod[i - 1] == 'u') {

					doSpaces(charMod, i, 1);
					charMod[i] = 's';

				}
			}

		}

		System.out.println(charMod);
	}

	private static void doExerciseString(String sentence2) {

		for (int i = 0; i < sentence2.length(); i++) {

			if (i == sentence2.length() - 1 || sentence2.charAt(i + 1) == ' '){

				if (sentence2.charAt(i) == 'a' || sentence2.charAt(i) == 'e' || sentence2.charAt(i) == 'i' || sentence2.charAt(i) == 'o' || sentence2.charAt(i) == 'u'){

					sentence2 = sentence2.substring(0, i + 1).concat("s").concat(sentence2.substring(i + 1));

				}

			}

		}

		System.out.println(sentence2);
	}

	private static void doSpaces(char[] data, int index, int repetitions){

		for (int j = 0; j < repetitions; j++) {

			for (int i = data.length - 1; i > index; i--) {

				data[i] = data[i - 1];

			}

			index++;

		}

	}

	private static int numberOfVocals(char[] data){

		int cont = 0;

		for (int i = 0; i < data.length; i++) {

			if (i == data.length - 1 || data[i + 1] == ' '){

				if (data[i] == 'a' || data[i] == 'e' || data[i] == 'i' || data[i] == 'o' || data[i] == 'u'){

					cont++;

				}

			}

		}

		return cont;

	}

}
