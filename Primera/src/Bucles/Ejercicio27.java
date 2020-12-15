package Bucles;/*
    Cambiar de signo los numeros negativos de un vector bidimensional y multiplicar por 2 los positivos,
 */

import java.util.Arrays;

public class Ejercicio27 {

    public static void main(String[] args) {

        int vector[][] = {{74, -25, 36, 2}, {-32, 10, 23, 1}, {-54, 5, 1 , -90}};

        doChanges(vector);

        printValues(vector);

    }

    private static void doChanges(int[][] data) {

        for (int i = 0; i < data.length; i++) {

            for (int o = 0; o < data[i].length; o++) {

                if (data[i][o] < 0) {

                    data[i][o] *= -1;

                } else {

                    data[i][o] *= 2;

                }

            }

        }

    }

    private static void printValues(int values[][]) {

        for (int[] data : values) {

            System.out.printf("%s \n", Arrays.toString(data));

        }

    }

}
