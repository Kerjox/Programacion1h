package UBALDE_DANIEL_ExamenB;

public class Ejercicio04 {

	public static void main(String[] args) {

		String sentence = "En un lugar de la mancha";
		String solve = doReverse(sentence, 0);
		System.out.println(solve);

	}

	private static String doReverse(String data, int cont){

		if (cont == data.length()) return "";

		return doReverse(data, cont + 1).concat(data.substring(cont, cont + 1));

	}
}
