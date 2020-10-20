/*
    Funcion que debuelva el numero máximo de un vector
 */

package Funciones;

public class Ejercicio47 {

    public static void main(String[] args) {

        int[] data = {14, 25, 10, 2, 58, 100};

        System.out.printf("El numero mas grande es el %d \n", returnMaxValue(data));

    }

    private static int returnMaxValue(int[] data){

        int posMax = 0;

        for (int i = 0; i < data.length; i++) {

            if (data[i] > data[posMax]) {

                posMax = i;

            }

        }

        return data[posMax];

    }

}
