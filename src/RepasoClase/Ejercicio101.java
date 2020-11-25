/*
	Mostarar la frase con las palabras al reves
 */
package RepasoClase;

public class Ejercicio101 {

	public static void main(String[] args) {

		String sentence = "En un lugar de la mancha";
		invertWordsString(sentence, countWords(sentence) - 1);

	}

	private static void invertWordsString(String data, int numberWordFind){

		if (numberWordFind < 0) return;

		System.out.print(extractWord(data, numberWordFind) + " ");
		
		invertWordsString(data, numberWordFind - 1);
	}

	private static String extractWord(String data, int numberWordFind){

		String word = "";
		int firstPos = 0;
		int lastPos;
		int numberWordsString = countWords(data);

		for (int i = 0; i <= numberWordFind; i++) {

			lastPos = data.indexOf(" ", firstPos);

			if (numberWordsString == i + 1){

				word = data.substring(firstPos);

			}else{

				word = data.substring(firstPos, lastPos);

			}

			firstPos = lastPos + 1;

		}

		return word;

	}

	private static int countWords(String data){

		if (data.equals("")){

			return 0;

		}

		int cont = 1;

		for (int i = 0; i < data.length(); i++) {

			if (data.charAt(i) == ' '){

				cont++;

			}

		}

		return cont;

	}

}
