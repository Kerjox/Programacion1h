/*
	Eliminar la ultima letra de la palabra
 */

package Repaso;

public class Ejercicio100 {

	public static void main(String[] args) {

		char[] sentence = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'l', 'a', ' ', 'm', 'a', 'n', 'c', 'h', 'a'};
		deleteLastCharacterInWords(sentence);

		System.out.println(sentence);

	}

	private static void deleteLastCharacterInWords(char[] data){

		int cont = 0;

		for (int i = 0; i < data.length - cont; i++) {

			if (data[i + 1] == ' '){

				for (int j = i; j < data.length - 1; j++) {

					data[j] = data[j + 1];

				}

				data[data.length - 1] = ' ';
				cont++;
				i--;

			}

		}

	}

}
