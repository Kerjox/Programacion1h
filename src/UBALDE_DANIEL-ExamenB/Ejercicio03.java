public class Ejercicio03 {

	public static void main(String[] args) {

		char[] chain = {'H', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á'};

		putLastWordFirst(chain);

		System.out.println(chain);

	}

	private static void putLastWordFirst(char[] data) {

		char index;

		while ((index = data[data.length - 1]) != ' ') {

			moveRightChain(data);

			data[0] = index;

		}

	}

	private static void moveRightChain(char[] data) {

		for (int j = data.length - 1; j > 0; j--) {

			data[j] = data[j - 1];

		}
	}

}