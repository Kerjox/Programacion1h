package repasoSolo;

public class Ejercicio04 {

	public static void main(String[] args) {

		String sentence = "Jeve Jeve Jeve Jeve";
		String solve = replaceVocal(sentence);

		System.out.println(solve);

	}

	private static String replaceVocal(String data){

		String stringMod = "";

		for (int i = 0; i < data.length(); i++) {

			if (data.charAt(i) == 'e') {

				stringMod = stringMod.concat("a");

			}else{

				 stringMod = stringMod.concat(data.substring(i, i + 1));

			}

		}

		return stringMod;

	}

}
