/*
    Método de ordenación de la burbuja
 */

package Bucles;

import java.util.Arrays;

public class Ejecicio43 {

    public static void main(String[] args) {

        int[] data = {10, 12, 23, 45, 2, 85, 47, 30};

        System.out.printf("datos iniciales %s \n", Arrays.toString(data));

        for (int o = 0; o < data.length; o++) {

            int aux = 0;

            for (int i = data.length - 1; i > 0; i--) {

                if (data[i] < data[i - 1]) {

                    aux = data[i];
                    data[i] = data[i - 1];
                    data[i - 1] = aux;

                }

            }

        }

        System.out.printf("datos ordenados %s \n", Arrays.toString(data));

    }

}
