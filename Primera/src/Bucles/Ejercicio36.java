/*
    Sacar los dieces por pantalla
 */

package Bucles;

public class Ejercicio36 {

    public static void main(String[] args) {

        int[][] notas = {
                {7, 5, 1, 6},
                {10, 10, 6, 9},
                {9, 10, 8, 7},
                {3, 4, 9, 10},
                {7, 2, 8, 6}
        };
        String[] students = {"Juan", "Pepe", "Iker", "Alberto", "Javier"};
        String[] subjet = {"Matemáticas", "Física", "Lengua", "Tics"};

        printTenSubjetStudent(notas, students, subjet);

    }

    private static void printTenSubjetStudent(int[][] notas, String[] students, String[] subjet) {

        int posTenX = 0;
        int posTenY = 0;
        int cont = 0;

        for (int x = 0; x < notas.length; x++) {

            for (int y = 0; y < notas[0].length; y++) {

                if (notas[x][y] == 10) {

                    cont++;
                    posTenX = x;
                    posTenY = y;
                    System.out.printf("El alumno %s ha sacado un 10 en %s \n", students[x], subjet[y]);

                }

            }

        }

        if (cont == 0) {

            System.out.printf("Ningún alumno ha sacado un 10 en ninguna asignatura");

        }

    }

}
