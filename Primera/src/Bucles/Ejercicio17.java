package Bucles;/*
    Cambiar el orden de los valosres del array, el primero con el último, el segundo con el penultimo.
 */

import java.util.Arrays;

public class Ejercicio17 {

    public static void main(String[] args) {

        int datos[] = {10, 20, 30, 40, 50, 60};
        int aux = 0;

        if ((datos.length % 2) != 0) {

            System.out.println("Error: No se pede realizar, el numero de valores del array es impar");

        }else {

            for (int i = 0; i < datos.length / 2; i++) {

                aux = datos[i];
                datos[i] = datos[(datos.length - 1) - i];
                datos[(datos.length - 1) - i] = aux;

            }

                System.out.printf("Los datos del array son %s \n", Arrays.toString(datos));

        }

    }
}
