public class Ejercicio04 {

	public static void main(String[] args) {

		String sentence = "En un lugar de la mancha manchosa que te mancha";

		printReverse(sentence, 0);

	}

	private static void printReverse(String data, int cont){

		if (cont == data.length()) return;
		printReverse(data, ++cont);

		System.out.print(data.charAt(cont - 1));

	}
}
