/*
	Eliminar los espacios de mas entre las palabras
 */

package Strings;

public class Ejercicio89 {

	public static void main(String[] args) {

		String sentence = "Había              una               vez               un               circo";
		boolean firstSpace = true;
		int pos = 0;
		doExercise(sentence);

		for (int i = 0; i < sentence.length(); i++) {

			if (sentence.charAt(i) == ' ') {

				if (firstSpace) {

					pos = i;
					firstSpace = false;

				}else{

					int k = i;

					while (sentence.charAt(k) == ' ') {

						k++;

					}

					sentence = sentence.substring(0, pos).concat(sentence.substring(k - 1));
					firstSpace = true;

				}

			}

		}

		System.out.println(sentence);

	}

	private static String doExercise(String data){

		int i = 0;
		boolean firstSpace = true;

		while(i < data.length()){

			if (data.charAt(i) == ' '){

				if (firstSpace){

					firstSpace = false;
					i++;

				}else{

					data = data.substring(0, i).concat(data.substring(i + 1));

				}

			}else{

				firstSpace = true;
				i++;

			}

		}

		return data;

	}

}
