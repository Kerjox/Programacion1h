/*
    Ordenar los 4 vectores de salarios
 */

package Funciones;

import java.util.Arrays;

public class Ejercicio51 {

    public static void main(String[] args) {

        int[][] salarys = {
                {700, 542, 611, 670, 800, 10000},
                {842, 605, 674, 945, 541, 781},
                {9, 1012, 845, 711, 784, 954},
                {745, 674, 956, 914, 456, 854},
                {754, 845, 845, 674, 954, 935}
        };

        System.out.printf("Los datos ordenados por filas \n");

        for (int x = 0; x < salarys.length; x++) {

            orderElements(salarys[x]);

            System.out.printf("%s \n", Arrays.toString(salarys[x]));

        }

    }

    private static void orderElements(int[] data){

        for (int i = 1; i < data.length; i++) {

            int cont = i;

            while (cont > 0 && data[cont] < data[cont - 1]) {

                int _aux = data[cont];
                data[cont] = data[cont - 1];
                data[cont - 1] = _aux;
                cont--;

            }

        }

    }

}
