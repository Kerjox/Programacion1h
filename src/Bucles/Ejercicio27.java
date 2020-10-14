package Bucles;/*
    Cambiar de signo los numeros negativos de un vector bidimensional y multiplicar por 2 los positivos,
 */

import java.util.Arrays;

public class Ejercicio27 {

    public static void main(String[] args) {

        int vector[][] = {{74, -25, 36, 2}, {-32, 10, 23, 1}, {-54, 5, 1 , -90}};

        vector = doChanges(vector);

        printValues(vector);

    }

    private static int[][] doChanges(int[][] newValues) {

        for (int i = 0; i < newValues.length; i++) {

            for (int o = 0; o < newValues[i].length; o++) {

                if (newValues[i][o] < 0) {

                    newValues[i][o] *= -1;

                } else {

                    newValues[i][o] *= 2;

                }

            }

        }

        return newValues;

    }

    private static void printValues(int values[][]) {

        for (int i = 0; i < values.length; i++) {

            System.out.printf("%s \n", Arrays.toString(values[i]));

        }

    }

}
