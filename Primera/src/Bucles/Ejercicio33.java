/*
    Lo mismo que el 32 pero con 4 películas que están en 4 salas
 */

package Bucles;

import java.util.Arrays;

public class Ejercicio33 {

    public static void main(String[] args) {

        int[][] datos= {
                {45, 21, 3, 10, 9, 45, 90},
                {2, 41, 20, 100, 1, 20, 47},
                {10, 56, 12, 78, 4, 100, 90},
                {10, 20, 64, 30, 81, 70, 30}
        };
        String[] peliculas = {"Al filo del mañana", "Interstellar", "Alita", "Oblivion"};
        int[] totalEntradasDS = new int[4];

        for (int i = 0; i < datos.length; i++) {

            for (int o = 0; o < datos[0].length; o++) {

                totalEntradasDS[i] += datos[i][o];

            }

        }

        System.out.printf("datos%s \n", Arrays.toString(totalEntradasDS));
        System.out.printf("peliculas%s \n\n", Arrays.toString(peliculas));

        int maxPos = 0;
        int minPos = 0;

        for (int i = 1; i < totalEntradasDS.length; i++) {

            if (totalEntradasDS[i] > totalEntradasDS[maxPos]) {

                maxPos = i;

            } else if (totalEntradasDS[i] < totalEntradasDS[minPos]){

                minPos = i;

            }

        }

        System.out.printf("La película que más entradas se vendidieron fué %s con %d \n", peliculas[maxPos], totalEntradasDS[maxPos]);
        System.out.printf("La película que menos entradas se vendideron fué %s con %d \n", peliculas[minPos], totalEntradasDS[minPos]);

    }

}
