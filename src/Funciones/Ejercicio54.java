/*
    Tenemos una tabla, crea una funcion que transforme la tabla multiplicando los valores por un numero.
 */

package Funciones;

import java.util.Arrays;

public class Ejercicio54 {

    public static void main(String[] args) {

        System.out.printf("Multiplicar datos por un numero con funciones \n");

        int[][] data = {
                {700, 542, 611, 670},
                {842, 605, 674, 945},
                {9, 1012, 845, 711},
                {745, 674, 956, 90},
                {754, 845, 845, 674}
        };

        int multi = 2;

        System.out.printf("\n Dataos iniciales \n");

        printArray(data);

        System.out.printf("\n Dataos multiplicados \n");

        multiplyTableData(data, multi);

        printArray(data);

    }

    private static void multiplyTableData(int[][] data, int multi){

        for (int[] row : data){

            for (int y = 0; y < data[0].length; y++){

                row[y] *= multi;

            }

        }

    }

    private static void printArray(int[][] data){

        for (int[] array : data){

            System.out.printf("%s \n", Arrays.toString(array));

        }

    }

}
