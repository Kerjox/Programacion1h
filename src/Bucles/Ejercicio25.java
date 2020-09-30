/*
    Mostrar las tablas de multiplicar
 */

package Bucles;

import java.util.Arrays;

public class Ejercicio25 {

    public static void main(String[] args) {

        //prueba();

        for (int i = 1; i <= 10; i++) {

            System.out.printf("La tabla del %d \n", i);

            for (int o = 1; o <= 10; o++) {

                System.out.printf("%d por %d es %d \n", i, o, i * o);

            }

            System.out.printf("\n");

        }

    }

    private static void prueba() {

        int x[] = new int [9];
        int y[] = new int [9];
        int z[] = new int [9];

        for (int i = 1; i <= 10; i++) {

            System.out.printf("La tabla del %d \n", i);

            for (int o = 1; o <= 10; o++) {

                for (int q = 0; q <= 9; q++) {

                    x[i] = i;
                    y[o] = o;
                    z[q] = x[i] * y[o];

                }

            }

            System.out.printf("%s", Arrays.toString(z));

        }

    }

}
