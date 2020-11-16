/*
	Añadir una 'a' al final de cada palabra
 */
package Strings;

public class Ejercicio88 {

	public static void main(String[] args) {

		String sentence1 = "Había una vez un circo ";

		sentence1 = doExercise(sentence1);

		System.out.println(sentence1);

	}

	private static String doExercise(String sentence1) {

		int lastPos = sentence1.indexOf(" ");

		while(lastPos != -1){

			sentence1 = sentence1.substring(0, lastPos).concat("a").concat(sentence1.substring(lastPos));

			lastPos = sentence1.indexOf(" ", lastPos + 2);

		}

		return sentence1;

	}

}
