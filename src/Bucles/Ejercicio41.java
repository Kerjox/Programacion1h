/*
    En un array bidimensional de edades con las edades de los 4 grupos de informática 1h, 2h, 1e, 2e, y en cada grupo hay 5 alumnos
    Sacar la edad media / clase
 */

package Bucles;

public class Ejercicio41 {

    static int[][] ages = {
            {17, 19, 21, 18, 19},
            {17, 20, 23, 21, 20},
            {16, 19, 17, 16, 17},
            {17, 20, 22, 17, 18}
    };

    static String[] classes = {"1h", "2h", "1e", "2e"};

    public static void main(String[] args) {

        printMedianClasses(getMedian());
    }

    private static int[] getMedian() {
        int[] median = new int[ages.length];

        for (int x = 0; x < ages.length; x++) {

            int sumMedians = 0;

            for (int y = 0; y < ages[0].length; y++) {

                sumMedians += ages[x][y];

            }

            median[x] = sumMedians / ages[x].length;

        }

        return median;

    }

    private static void printMedianClasses(int[] agesMedian) {

        for (int x = 0; x < agesMedian.length; x++) {

            System.out.printf("La edad media de %s es %d años. \n", classes[x], agesMedian[x]);

        }

    }

}
