/*
	Buscar una cadena dentro de una subcadena de ua cadena
 */
package RepasoClase;

public class Ejercicio102 {

	public static void main(String[] args) {

		char[] sentence = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'l', 'a', ' ', 'm', 'a', 'n', 'c', 'h', 'a'};
		char[] find = {'u', 'n'};

		removeChain(sentence, find);
		System.out.println(sentence);

	}

	private static void removeChain(char[] data, char[] find){

		for (int i = 0; i < data.length - find.length; i++) {

			if (findConcordanceIn(data, find, i)){

				removeWord(data, i, find.length);

			}

		}

	}

	private static void removeWord(char[] data, int index, int repetitions){

		for (int i = 0; i < repetitions; i++) {

			for (int j = index; j < data.length - 1; j++) {

				data[j] = data[j + 1];

			}

			data[data.length - 1] = ' ';

		}

	}

	private static boolean findConcordanceIn(char[] data, char[] chainToFind, int index){

		if (data[index] == chainToFind[0]){

			int cont = 1;

			while(cont < chainToFind.length && data[index + cont] == chainToFind[cont]){

				cont++;

			}

			if (cont == chainToFind.length){

				return true;

			}

		}

		return false;

	}
}
