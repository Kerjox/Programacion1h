package Metodos_Ordenacion;

import java.util.Arrays;

public class Ejercicio45 {

    public static void main(String[] args) {

        int[] data = {10, 23, 12, 54, 2, 20, 14, 34};

        System.out.printf("datos iniciales %s \n", Arrays.toString(data));

        for (int i = 1; i < data.length; i++) {

            for (int j = i; j > 0 && data[j] < data[j - 1]; j--) {

                int aux = data[j];
                data[j] = data[j - 1];
                data[j - 1] = aux;

            }

        }

        System.out.printf("datos ordenados %s \n", Arrays.toString(data));

    }

}
