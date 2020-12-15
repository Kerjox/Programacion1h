/*
	Reemplazar string
 */


package repasoSolo;

public class Ejercicio07 {

	public static void main(String[] args) {

		String sentence = "En un un un lugar de la mancha";
		String find = "un";
		String replace = "aaaun";
		String solve = "";
		String solveRecursive = "";

		solve = replaceChainString(sentence, find, replace);

		System.out.println(solve);

		solveRecursive = replaceChainStringRecursive(sentence, find, replace, 0);

		System.out.println(solveRecursive);

	}

	private static String replaceChainString(String data, String find, String replace) {

		int index = 0;

		while ((index = data.indexOf(find, index)) != - 1) {

			data = data.substring(0, index).concat(replace).concat(data.substring(index + find.length()));
			index += replace.length();

		}

		return data;

	}

	private static String replaceChainStringRecursive(String data, String find, String replace, int index) {

		if ((index = data.indexOf(find, index)) == - 1) return data;

		data = data.substring(0, index).concat(replace).concat(data.substring(index + find.length()));

		return replaceChainStringRecursive(data, find, replace, index + replace.length());

	}

}
