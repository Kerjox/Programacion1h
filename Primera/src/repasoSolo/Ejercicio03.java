package repasoSolo;

import java.util.Arrays;

public class Ejercicio03 {

	public static void main(String[] args) {

		String[] data = {"C", "D", "B", "A"};
		orderStrings(data);
		System.out.println(Arrays.toString(data));

	}

	private static void orderStrings(String[] data){

		for (int i = 0; i < data.length; i++) {

			for (int j = i; j > 0 && data[j].compareTo(data[j - 1]) < 0; j--) {

				String aux = data[j];
				data[j] = data[j - 1];
				data[j - 1] = aux;

			}

		}

	}

}
