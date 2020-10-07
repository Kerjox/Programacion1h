/*
    El alumno con mejores notas y su media, y las peores
    Sacar la asignatura con mejores notas y su media y la peor
 */

package Bucles;

import java.util.Arrays;

public class Ejercicio35 {

    public static void main(String[] args) {

        int[][] notas = {
                {7, 5, 1, 6},
                {8, 7, 6, 9},
                {9, 10, 8, 7},
                {3, 4, 6, 4},
                {7, 2, 8, 6}
        };
        String[] alumnos = {"Juan", "Pepe", "Iker", "Alberto", "Javier"};
        String[] materias = {"Matemáticas", "Física", "Lengua", "Tics"};

        mejorPeorMediaAlumnos(notas, alumnos);
        mejorPeorMediasMaterias(notas, materias);

    }

    private static void mejorPeorMediaAlumnos(int[][] notas, String[] alumnos) {

        float[] medias = new float[notas.length];
        int posMediaMasAlta = 0;
        int posMediaMasBaja = 0;

        for (int x = 0; x < notas.length; x++) {

            int sumaMedias = 0;

            for (int y = 0; y < notas[0].length; y++) {

                sumaMedias += notas[x][y];

            }

            medias[x] = (float) sumaMedias / notas[0].length;

            if (medias[x] > medias[posMediaMasAlta]) {

                posMediaMasAlta = x;

            } else if (medias[x] < medias[posMediaMasAlta]) {

                posMediaMasBaja = x;

            }

        }

        System.out.printf("El alumno que tiene las notas mas altas es %s con una media de %.2f \n", alumnos[posMediaMasAlta], medias[posMediaMasAlta]);
        System.out.printf("El alumno que tiene las notas mas bajas es %s con una media de %.2f \n\n", alumnos[posMediaMasBaja], medias[posMediaMasBaja]);

    }

    private static void mejorPeorMediasMaterias(int[][] notas, String[] materias) {

        float[] mediaMaterias = new float[notas[0].length];
        int posMaxMedia = 0;
        int posMinMedia = 0;

        for (int y = 0; y < notas[0].length; y++) {

            float sumaMediaMaterias = 0;

            for (int x = 0; x < notas.length; x++) {

                sumaMediaMaterias += notas[x][y];

            }

            mediaMaterias[y] = sumaMediaMaterias / notas[0].length;

            if (mediaMaterias[y] > mediaMaterias[posMaxMedia]) {

                posMaxMedia = y;

            } else if (mediaMaterias[y] < mediaMaterias[posMinMedia]) {

                posMinMedia = y;

            }

        }

        System.out.printf("La asignatura con la media mas alta es %s con un %.2f \n", materias[posMaxMedia], mediaMaterias[posMaxMedia]);
        System.out.printf("La asignatura con la nota media mas baja es %s con un %.2f \n", materias[posMinMedia], mediaMaterias[posMinMedia]);

    }

}
