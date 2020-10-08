/*
    Intercambiar la diagonal principal en la misma fila
 */

package Bucles;

import java.util.Arrays;

public class Ejercicio40 {

    public static void main(String[] args) {

        int[][] data = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        /*
        int[][] res = {
                {4, 2, 3, 1},
                {5, 7, 6, 8},
                {9, 11, 10, 12},
                {16, 14, 15, 13}
        };
         */

        int aux = 0;

        for (int i = 0; i < data.length; i++) {

            aux = data[i][data[0].length - i - 1];
            data[i][data[0].length - i - 1] = data[i][i];
            data[i][i] = aux;

            System.out.printf("%s \n", Arrays.toString(data[i]));

        }

    }

}
