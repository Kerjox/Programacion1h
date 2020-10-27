/*
    Hacer una función que multiplique por 5 los numeros de una tabla que sean inforiores a 10
 */

package IntroFunciones;

import java.util.Arrays;

public class Ejercicio58 {

    public static void main(String[] args) {

        System.out.print("Multiplicar valores del array que sean inforiores a 10 por 5 \n\n");

        int[][] kgProductos = {
                {20, 15, 13, 16, 2, 4, 6},
                {4, 1, 5, 7, 4, 5, 7}
        };

        System.out.print("Datos iniciales \n");

        printArray(kgProductos);

        multiplyArray(kgProductos);

        System.out.println("Datos modificados \n");

        printArray(kgProductos);

    }

    private static void multiplyArray(int[][] data){

        for (int[] row : data){

            for (int y = 0; y < data[0].length; y++){

                if (row[y] < 10){

                    row[y] *= 5;

                }

            }

        }

    }

    private static void printArray(int[][] data){

        for (int[] row : data) {

            System.out.printf("%s \n", Arrays.toString(row));

        }

    }

}
