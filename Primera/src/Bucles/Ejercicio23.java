package Bucles;/*
    Mover los datos del array hacia la derecha hasta que queden como estaba
 */

import java.util.Arrays;

public class Ejercicio23 {

    public static void main(String[] args) {

        int datos[] = {45, 25, 84, 2, 90};

        System.out.printf("Daos iniciales datos%s \n", Arrays.toString(datos));

        for (int i = 0; i < datos.length; i++) {

            for (int o = datos.length - 1; o > 0; o--) {

                int aux = datos[o];
                datos[o] = datos[o - 1];
                datos[o - 1] = aux;
            }

            System.out.printf("datos%s \n", Arrays.toString(datos));

        }

    }

}
