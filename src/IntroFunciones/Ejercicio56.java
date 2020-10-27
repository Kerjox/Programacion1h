/*
    Lo mismo que en el 55 solo que hay que meter los valores dentro de una nueva tabla llamada ventas "sales"
 */

package IntroFunciones;

import java.util.Arrays;

public class Ejercicio56 {

    public static void main(String[] args) {

        System.out.print("Calcular el dinero que se ha ganado con cada producto todos lo días con la tabla de precios \n\n");

        int[][] kgProductos = {
                {20, 15, 13, 16, 2 , 4, 6},
                {4, 1, 5, 7, 4, 5, 7}
        };
        int[] pricesKg = {2, 4};
        int[][] sales = doProfitsPerDay(kgProductos, pricesKg);

        System.out.print("\n Dataos iniciales \n");

        printArray(kgProductos);

        System.out.print("\n Dataos multiplicados \n");

        printArray(sales);

    }

    private static int[][] doProfitsPerDay(int[][] data, int[] price) {

        int[][] sales = new int[data.length][data[0].length];

        for (int x = 0; x < data.length; x++) {

            for (int y = 0; y < data[0].length; y++) {

                sales[x][y] = data[x][y] * price[x];

            }

        }

        return sales;

    }

    private static void printArray(int[][] data){

        for (int[] array : data){

            System.out.printf("%s \n", Arrays.toString(array));

        }

    }

}
