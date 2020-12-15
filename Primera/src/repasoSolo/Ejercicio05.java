/*
	Reemplazar cadena de caractees
 */
package repasoSolo;

public class Ejercicio05 {

	public static void main(String[] args) {

		char[] sentence = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r'};
		char[] find = {'n', ' '};
		char[] replace = {'a', 'u', ' '};

		char[] solve = replaceChar(sentence, find, replace);

		System.out.println(solve);


	}

	private static char[] replaceChar(char[] data, char[] find, char[] replace){

		int numberSubstitutions = countReplaces(data, find);

		char[] charMod = new char[data.length + numberSubstitutions * replace.length - find.length * numberSubstitutions];

		for (int i = 0, j = 0; i < data.length; i++, j++) {

			if(findConcordanceIn(data, find, i)){

				for (int k = 0; k < replace.length; k++) {

					charMod[j++] = replace[k];

				}

				j--;
				i += find.length - 1;

			}else{

				charMod[j] = data[i];

			}

		}

		return charMod;

	}

	private static boolean findConcordanceIn(char[] data, char[] find, int index){

		if (data[index++] == find[0]){

			int cont = 1;

			while (cont != find.length && data[index++] == find[cont]){

				cont++;

			}

			return cont == find.length;

		}

		return false;

	}

	private static int countReplaces(char[] data, char[] find){

		int cont = 0;

		for (int i = 0; i < data.length; i++) {

			if (findConcordanceIn(data, find, i)) cont++;

		}

		return cont;

	}

}
