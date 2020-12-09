package UBALDE_DANIEL_ExamenB;

public class Ejercicio03 {

	public static void main(String[] args) {

		char[] chain = {'H', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á'};

		putFirstWordLast(chain);

		System.out.println(chain);

	}

	private static void putFirstWordLast(char[] data) {

		while (data[data.length - 1] != ' ') {

			char aux = data[0];

			moveLeftChain(data);

			data[data.length - 1] = aux;

		}

	}

	private static void moveLeftChain(char[] data) {

		for (int j = 0; j < data.length - 1; j++) {

			data[j] = data[j + 1];

		}
	}

}