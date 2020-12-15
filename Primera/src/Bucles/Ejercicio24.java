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

        for (int multiplicador : multiplicadores){

            int[] solve = new int[datos.length];

            System.out.printf("Datos multiplicados por %d \n", multiplicador);

            for (int i = 0; i < datos.length; i++) {

                solve[i] = datos[i] * multiplicador;

            }

            System.out.printf("res%s \n\n", Arrays.toString(solve));

        }

    }

}
