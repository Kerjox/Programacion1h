/*
	Tenemos 3 Strings y metemops en el ultimo string que está vacio una palabra cada vez de un string distinto
 */

package Strings;

public class Ejercicio86 {

	public static void main(String[] args) {

		String str1 = "cero dos cuatro seis ocho nueve diez once doce";
		String str2 = "uno tres cinco siete";
		String solve = doExercise(str1, str2);

		System.out.println(solve);

	}

	private static String doExercise(String data1, String data2){

		int data1Words = countWords(data1);
		int data2Words = countWords(data2);
		int totalExecutions = Math.max(data1Words, data2Words);
		String solve = "";

		for (int i = 0; i < totalExecutions; i++) {

			if (i < data1Words){

				solve = solve.concat(extractWord(data1, i));
				solve = solve.concat(" ");

			}

			if (i < data2Words){

				solve = solve.concat(extractWord(data2, i));
				solve = solve.concat(" ");

			}

		}

		return solve;

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
