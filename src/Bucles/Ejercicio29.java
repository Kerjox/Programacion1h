/*
    Sumar por filas y por columnas
 */

package Bucles;

import java.util.Arrays;

public class Ejercicio29 {

    public static void main(String[] args) {

        int datos[][] = {{45, 21, 3, 10}, {2, 41, 20, 10}, {10, 56, 12, 78}};
        int v1[] = new int[datos.length];
        int v2[] = new int[datos[0].length];

        for (int i = 0; i < datos.length; i++) {

            for (int o = 0; o < datos[i].length; o++) {

                v1[i] += datos[i][o];
                v2[o] += datos[i][o];

            }

        }

        System.out.printf("v1%s \n", Arrays.toString(v1));
        System.out.printf("v2%s \n", Arrays.toString(v2));

    }

}