package UBALDE_DANIEL_ExamenB;

public class Ejercicio04 {

	public static void main(String[] args) {

		String sentence = "En un lugar de la mancha";
		String solve = doReverse(sentence);
		System.out.println(solve);

	}

	private static String doReverse(String data){

		if (data.length() != 1){

			return doReverse(data.substring(1)).concat(data.substring(0, 1));

		}else return data.substring(0, 1);
	}
}
