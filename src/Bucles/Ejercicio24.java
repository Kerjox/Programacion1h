/*
    Mostrar el resultado del contenido de datos multiplicado por los multiplicadores.
 */

package Bucles;

import java.util.Arrays;

public class Ejercicio24 {

    public static void main(String[] args) {

        int datos[] = {45, 25, 84, 2, 90};
        int multiplicadores[] = {2, 3, 4, 6};

        System.out.printf("Datos iniciales %s \n\n", Arrays.toString(datos));

        for (int i = 0; i < multiplicadores.length; i++) {

            int res[] = new int [datos.length];

            System.out.printf("Datos multiplicados por %d \n", multiplicadores[i]);

            for (int o = 0; o < datos.length; o++) {

                res[o] = datos[o] * multiplicadores[i];

            }

            System.out.printf("res%s \n\n", Arrays.toString(res));

        }

    }

}
