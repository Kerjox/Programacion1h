/*
    Volcar los datos de un array en otro igual.
 */

package Bucles;

import java.util.Arrays;

public class Ejercicio38 {

    public static void main(String[] args) {

        int[][] data = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] empty = new int[data.length][data[0].length];

        overturn(data, empty);
        printArray(empty);

    }

    private static void overturn(int[][] origin, int[][] destiny) {

        for (int x = 0; x < origin.length; x++) {

            for (int y = 0; y < origin[0].length; y++) {

                destiny[y][x] = origin[x][y];

            }

        }

    }

    private static void printArray(int[][] array) {

        for (int x = 0; x < array.length; x++) {

            System.out.printf("%s \n", Arrays.toString(array[x]));

        }

    }

}
