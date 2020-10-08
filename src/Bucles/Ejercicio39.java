/*
    Lo mismo que el ejercicio 38 pero sin segundo array
 */

package Bucles;

import java.util.Arrays;

public class Ejercicio39 {

    public static void main(String[] args) {

        int[][] data = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        overturn(data);
        printArray(data);

    }

    private static void overturn(int[][] origin) {

        for (int x = 0; x < origin.length; x++) {

            int aux = 0;

            for (int y = x; y < origin[0].length; y++) {

                aux = origin[x][y];
                origin[x][y] = origin[y][x];
                origin[y][x] = aux;

            }

        }

    }

    private static void printArray(int[][] array) {

        for (int x = 0; x < array.length; x++) {

            System.out.printf("%s \n", Arrays.toString(array[x]));

        }

    }

}
