/*
	Eliminar la string de la cadena
 */

package RepasoClase;

public class Ejercicio103 {

	public static void main(String[] args) {

		String sentence = "En un lugar de la mancha";
		String find = "un";

		System.out.println(removeChainString(sentence, find));

	}

	private static String removeChainString(String data, String thingToFind){

		for (int i = 0; i < data.length() - thingToFind.length(); i++) {

			if (findConcordanceIn(data, thingToFind, i)){

				data = data.substring(0, i).concat(data.substring(i + thingToFind.length()));
				i -= thingToFind.length();

			}

		}

		return data;

	}

	private static boolean findConcordanceIn(String data, String chainToFind, int index){

		if (data.charAt(index) == chainToFind.charAt(0)){

			int cont = 1;

			while(cont < chainToFind.length() && data.charAt(index + cont) == chainToFind.charAt(cont)){

				cont++;

			}

			if (cont == chainToFind.length()){

				return true;

			}

		}

		return false;

	}

}
