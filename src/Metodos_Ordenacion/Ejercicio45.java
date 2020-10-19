package Metodos_Ordenacion;

import java.util.Arrays;

public class Ejercicio45 {

    public static void main(String[] args) {

        int[] data = {10, 23, 12, 54, 2, 20, 14, 34};

        System.out.printf("datos iniciales %s \n", Arrays.toString(data));

        for (int i = 1; i < data.length; i++) {

            int cont = i;

            while (cont > 0 && data[cont] < data[cont - 1]) {

                int _aux = data[cont];
                data[cont] = data[cont - 1];
                data[cont - 1] = _aux;
                cont--;

            }

        }

        System.out.printf("datos ordenados %s \n", Arrays.toString(data));

    }

}
