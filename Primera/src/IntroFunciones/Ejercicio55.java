/*
    Tenemos lo kilos que se han vendido, calcular los € que se hanvendido cada día
 */

package IntroFunciones;

import java.util.Arrays;

public class Ejercicio55 {

    public static void main(String[] args) {

        System.out.printf("Calcular el dinero que se ha ganado con cada producto todos lo días con la tabla de precios \n");

        int[][] kgProductos = {
                {20, 15, 13, 16, 2 , 4, 6},
                {4, 1, 5, 7, 4, 5, 7}
        };

        int[] pricesKg = {2, 4};

        System.out.printf("\n Dataos iniciales \n");

        printArray(kgProductos);

        System.out.printf("\n Dataos multiplicados \n");

        doProfitsPerDay(kgProductos, pricesKg);

        printArray(kgProductos);

    }

    private static void doProfitsPerDay(int[][] data, int[] price) {

        for (int x = 0; x < data.length; x++) {

            for (int y = 0; y < data[0].length; y++) {

                data[x][y] *= price[x];

            }

        }

    }

    private static void printArray(int[][] data){

        for (int[] array : data){

            System.out.printf("%s \n", Arrays.toString(array));

        }

    }

}
