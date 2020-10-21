/*
    Crear una funcion que pasando le una tabla debuelva la suma de todos los valores
 */

package Funciones;

public class Ejercicio48 {

    public static void main(String[] args) {

        int[][] salarys = {
                {700, 542, 611, 670, 800, 10000},
                {842, 605, 674, 945, 541, 781},
                {9, 1012, 845, 711, 784, 954},
                {745, 674, 956, 914, 456, 854},
                {754, 845, 845, 674, 954, 935}
        };

        System.out.printf("La suma de todos los salarios es %d€", sumArray(salarys));

    }

    private static int sumArray(int[][] data) {

        int suma = 0;

        for (int x = 0; x < data.length; x++){

            for (int y = 0; y < data[0].length; y++){

                suma += data[x][y];

            }

        }

        return suma;

    }

}
