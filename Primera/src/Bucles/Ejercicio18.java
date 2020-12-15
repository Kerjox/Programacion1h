package Bucles;/*
    Modificar un vector convirtiendo los negativos en positivos y los positivos los multiplicamos por 2.
 */

import java.util.Arrays;

public class Ejercicio18 {

    public static void main(String[] args) {

        int datos[] = {-78, 85, -34, 5, -89, 12};

        for (int i = 0; i < datos.length; i++) {

            if (datos[i] < 0) {

                datos[i] *= -1;

            } else {

                datos[i] *= 2;

            }

        }

        System.out.printf("datos%s", Arrays.toString(datos));

    }
}
