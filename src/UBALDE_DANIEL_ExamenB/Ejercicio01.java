import java.util.Arrays;

public class Ejercicio01 {

	public static void main(String[] args) {

		int[][] table = {
				{1, 78, 34, 47, 54}, // Diagonal es 1, 2, 3, 4, 5
				{14, 2, 53, 64, 65},
				{16, 26, 3, 64, 56},
				{16, 26, 63, 4, 65},
				{16, 26, 36, 46, 5}
		};

		System.out.printf("La diagonal es: %s \n", Arrays.toString(getDiagonal(table)));

	}

	private static int[] getDiagonal(int[][] data) {

		int[] diagonal = new int[data.length];

		for (int i = 0; i < data.length; i++) {

			diagonal[i] = data[i][i];

		}

		return diagonal;

	}

}
