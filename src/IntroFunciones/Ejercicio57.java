/*
    Calcular la cantidad de kilos que se han vendido de cada producto con una cunción
 */

package IntroFunciones;

public class Ejercicio57 {

    public static void main(String[] args) {

        System.out.print("Sumar los Kg que se han vendido durante la semana de cada producto \n\n");

        int[][] kgProductos = {
                {20, 15, 13, 16, 2, 4, 6},
                {4, 1, 5, 7, 4, 5, 7}
        };

        String[] products= {"Peras", "Manzanas"};

        printResult(sumArrays(kgProductos), products);

    }

    private static int[] sumArrays(int[][] data){

        int[] result = new int[data.length];

        for (int x = 0; x < data.length; x++){

            for (int y = 0; y < data[0].length; y++){

                result[x] += data[x][y];

            }

        }

        return result;

    }

    private static void printResult(int[] data, String[] products){

        for (int i = 0; i < data.length; i++){

            System.out.printf("Se han vendido '%dKg' de '%s' en la semana \n", data[i], products[i]);

        }

    }

}
