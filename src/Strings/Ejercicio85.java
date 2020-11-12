/*
	Hacer un array de Strings con las posiciones necesarias y ordenar las palabras.
 */
package Strings;

import java.util.Arrays;

public class Ejercicio85 {

	public static void main(String[] args) {

		String sentence = "9Nueve 5Cinco 2Dos 0Cero 1Uno ";
		String[] words = new String[countWords(sentence)];

		copyWordsInArray(sentence, words);
		order(words);
		deleteFirstCharacter(words);

		System.out.println(Arrays.toString(words));

	}

	private static void deleteFirstCharacter(String[] data){

		for (int i = 0; i < data.length; i++) {

			data[i] = data[i].substring(1);

		}

	}

	private static int countWords(String data) {

		int cont = 0;

		for (int i = 0; i < data.length(); i++) {

			if (data.charAt(i) == ' ') {

				cont++;

			}

		}

		return cont;

	}

	private static void order(String[] data) {

		for (int i = 1; i < data.length; i++) {

			for (int j = i; j > 0 && data[j].compareTo(data[j - 1]) < 0; j--) {

				String aux = data[j];
				data[j] = data[j - 1];
				data[j - 1] = aux;

			}

		}

	}

	private static void copyWordsInArray(String data, String[] words) {

		int index = 0;
		int indexWord = 0;
		int posSpaces;

		while ((posSpaces = data.indexOf(" ", index)) != -1) {

			words[indexWord] = data.substring(index, posSpaces);
			indexWord++;
			index = posSpaces + 1;

		}

	}

}
