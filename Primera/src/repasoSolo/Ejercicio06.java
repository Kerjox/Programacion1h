/*
	Pasar la última letra de la cadena de caracteres a mayuscula
	Y de la string tabmbién
 */

package repasoSolo;

public class Ejercicio06 {

	public static void main(String[] args) {

		char[] sentence = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r'};
		String senteceS = "En un lugar";

		toUppercaseLastCharacterChar(sentence);
		System.out.println(sentence);

		String sentenceModString = toUppercaseLastCharacterString(senteceS);
		System.out.println(sentenceModString);

	}

	private static void toUppercaseLastCharacterChar(char[] data){

		for (int i = 0; i < data.length; i++) {

			if (i == data.length - 1 || data[i + 1] == ' '){

				data[i] = Character.toUpperCase(data[i]);

			}

		}

	}

	private static String toUppercaseLastCharacterString(String data){

		for (int i = 0; i < data.length(); i++) {

			if (i == data.length() - 1 || data.charAt(i + 1) == ' '){

				//data = data.substring(0, i).concat(Character.toString(Character.toUpperCase(data.charAt(i))).concat(data.substring(i + 1)));
				data = data.substring(0, i).concat(data.substring(i, i + 1).toUpperCase().concat(data.substring(i + 1)));

			}

		}

		return data;

	}

}
