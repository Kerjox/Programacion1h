package repasoSolo;

public class Ejercicio08 {

	public static void main(String[] args) {

		String sentence = "En un lugar de la mancha";
		String solve = replaceLastCharacterWordsString(sentence);

		System.out.println(solve);

	}

	private static String replaceLastCharacterWordsString(String data){

		for (int i = 0; i < data.length(); i++) {

			if (i == data.length() - 1 || data.charAt(i + 1) == ' '){

				data = data.substring(0, i).concat("H").concat(data.substring(i + 1));

			}

		}

		return data;

	}

}
