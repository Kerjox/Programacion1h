import java.util.Arrays;

public class ProtocoloDeInvasion {

	private static final String[][] panel = {{"55", "1C", "BD", "BD", "1C"},
			{"BD", "1C", "55", "E9", "1C"},
			{"55", "E9", "55", "55", "1C"},
			{"BD", "BD", "1C", "BD", "BD"},
			{"55", "1C", "1C", "55", "1C"}};
	private static final String[] input = {"1C", "BD"};
	// 1C BD
	private static int[][] solvePanel = new int[5][5];
	private static int inputIndex = 0;


	public static void main(String[] args) {



		printSolve();
	}

	private static void printSolve() {

		for (int[] ints : solvePanel) {

			System.out.println(Arrays.toString(ints));
		}
	}

	private static boolean checkCol(int inputIndex, int indexRow) {

		int indexCol = 0;

		while(indexRow < panel.length) {

			if (panel[indexRow][indexCol].equals(input[inputIndex])) {

				solvePanel[indexRow][indexCol] = inputIndex + 1;
				return true;
			}else {

				indexRow++;

			}

		}

		return false;
	}

	private static int checkRow(int inputIndex, int indexCol) {

		int indexRow = 0;

		while(indexCol < panel.length) {

			if (panel[indexRow][indexCol].equals(input[inputIndex])) {

				solvePanel[indexRow][indexCol] = inputIndex + 1;
				return indexCol;
			}else {

				indexCol++;
			}

		}

		return 0;
	}


}
