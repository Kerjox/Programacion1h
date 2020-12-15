/*
    Hacemos un vector bidimensional y mostamos el contenido del vector
 */

package Bucles;

import java.util.Arrays;

public class Ejercicio26 {

    public static void main(String[] args) {

        int vector[][] = {{74, 25, 36, 2}, {32, 10, 23, 1}, {54, 5, 1, 9}, {9, 87, 5}};

        for (int[] data : vector) {

            System.out.printf("%s \n", Arrays.toString(data));

        }

    }

}
