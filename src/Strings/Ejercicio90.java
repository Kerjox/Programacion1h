/*
	Separar palabras de una frase en 2 frases alternando
 */

package Strings;

public class Ejercicio90 {

	public static void main(String[] args) {

		String sentenceBase = "Había una vez un circo";
		String sentence1 = "";
		String sentence2 = "";

		int numberWords = countWords(sentenceBase);

		if (numberWords == 0){

			System.out.println("Error: No hay palabras");
			return;

		}

		boolean sentenceSwitch = true;

		for (int i = 0; i < numberWords; i++) {

			if (sentenceSwitch){

				sentenceSwitch = false;
				sentence1 = sentence1.concat(extractWord(sentenceBase, i));
				sentence1 = sentence1.concat(" ");

			}else{

				sentenceSwitch = true;
				sentence2 = sentence2.concat(extractWord(sentenceBase, i));
				sentence2 = sentence2.concat(" ");

			}

		}

		System.out.println(sentence1);
		System.out.println(sentence2);

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

}
