/*
    En un array bidimensional tenemos el número de goles que han metido 5 futbolistas en las 4 temporadas, 1 vector nobres_futbolistas
    Sacar la media de goles / año de cada futbolista
 */

package Bucles;

public class Ejercicio42 {

    static int[][] golesTemporada = {
        {21, 42, 30, 10},
        {23, 10, 15, 30},
        {20, 25, 23, 26},
        {15, 20, 21, 23},
        {12, 13, 14, 12}
    };
    static String[] futbolistas = {"Pepe", "Alfredo", "Marcelo", "Javier", "Juan"};

    public static void main(String[] args) {

        printMedian(getMedianGoalsPerYear());

    }

    private static int[] getMedianGoalsPerYear() {

        int[] medianGoals = new int[golesTemporada.length];

        for (int x = 0; x < golesTemporada.length; x++) {

            for (int y = 0; y < golesTemporada[0].length; y++) {

                medianGoals[x] += golesTemporada[x][y];

            }

            medianGoals[x] /= golesTemporada[0].length;

        }

        return medianGoals;

    }

    private static void printMedian(int[] medians) {

        for (int x = 0; x < medians.length; x++) {

            System.out.printf("La media de goles por año de %s es de %d \n", futbolistas[x], medians[x]);

        }

    }

}
