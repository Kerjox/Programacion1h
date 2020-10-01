/*
    Mostrar las tablas de multiplicar
 */

package Bucles;

import java.util.Arrays;

public class Ejercicio25 {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {

            System.out.printf("La tabla del %d \n", i);

            for (int o = 1; o <= 10; o++) {

                System.out.printf("%d por %d es %d \n", i, o, i * o);

            }

            System.out.printf("\n");

        }

    }

}
