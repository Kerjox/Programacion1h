/*
    Metodo de ordenacion directa
 */

package Metodos_Ordenacion;

import java.util.Arrays;

public class Ejercicio44 {

    public static void main(String[] args) {

        int[] data = {10, 12, 23, 45, 2, 85, 47, 30};

        System.out.printf("datos iniciales %s \n", Arrays.toString(data));

        for (int i = 0; i < data.length; i++) {

            int posMin = i;

            for (int o = i; o < data.length; o++) {

                if (data[posMin] > data[o]) {

                    posMin = o;

                }

            }

            int aux = data[i];
            data[i] = data[posMin];
            data[posMin] = aux;

        }

        System.out.printf("datos ordenados %s \n", Arrays.toString(data));

    }

}
