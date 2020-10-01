/*
    El primer elemeto del vector de v1 multiplique a el primer vector de la tabla
 */

package Bucles;

import java.util.Arrays;

public class Ejercico28 {

    public static void main(String[] args) {

        int datos[][] = {{45, 21, 3}, {2, 41, 20}, {10, 56, 12}};
        int v1[] = {2, 3, 5};

        if (datos.length != v1.length) {

            System.out.printf("Error");

        } else {

            for (int i = 0; i < datos.length; i++) {

                for (int o = 0; o < datos[i].length; o++) {

                    datos[i][o] *= v1[i];

                }

            }

            for (int i = 0; i < datos.length; i++) {

                System.out.printf("datos%s \n", Arrays.toString(datos[i]));

            }

        }

    }

}
