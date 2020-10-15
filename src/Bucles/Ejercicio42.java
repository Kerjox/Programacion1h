/*
    En un array bidimensional tenemos el número de goles que han metido 5 futbolistas en las 4 temporadas, 1 vector nobres_futbolistas
    Sacar la media de goles / temporada de cada futbolista
 */

package Bucles;

public class Ejercicio42 {

    static int[][] golesTemporada = {
        {18, 42, 30, 10},
        {19, 10, 15, 30},
        {22, 25, 23, 26},
        {20, 20, 21, 23},
        {33, 13, 14, 12}
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

            System.out.printf("La media de goles por temporada de %s es de %d goles. \n", futbolistas[x], medians[x]);

        }

    }

}
