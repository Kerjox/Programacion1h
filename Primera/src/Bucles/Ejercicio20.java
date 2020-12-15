package Bucles;/*
    Desplazar todos los elementos de un array 1 puesto a la izquierda y el primero al último.
 */

import java.util.Arrays;

public class Ejercicio20 {

    public static void main(String[] args) {

        int datos[] = {45, 25, 84, 2, 63, 78, 12};

        for (int i = 0; i < datos.length - 1; i++) {

            int aux = datos[i];
            datos[i] = datos[i + 1];
            datos[i + 1] = aux;

        }

        System.out.printf("datos%s", Arrays.toString(datos));

    }

}
