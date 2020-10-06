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

        int[] medias = new int[5];
        int posMediaMasAlta = 0;
        int posMediaMasBaja = 0;

        for (int x = 0; x < notas.length; x++) {

            int sumaMedias = 0;

            for (int y = 0; y < notas[0].length; y++) {

                sumaMedias += notas[x][y];

            }

            medias[x] = sumaMedias / notas[0].length;

        }

        for (int i = 1; i < medias.length; i++) {

            if (medias[i] > medias[posMediaMasAlta]) {

                posMediaMasAlta = i;

            } else if (medias[i] < medias[posMediaMasAlta]) {

                posMediaMasBaja = i;

            }

        }

        System.out.printf("El alumno que tiene las notas mas altas es %s con una media de %d \n", alumnos[posMediaMasAlta], medias[posMediaMasAlta]);
        System.out.printf("El alumno que tiene las notas mas bajas es %s con una media de %d \n\n", alumnos[posMediaMasBaja], medias[posMediaMasBaja]);

    }

    private static void mejorPeorMediasMaterias(int[][] notas, String[] materias) {

        float[] mediaMaterias = new float[notas[0].length];
        int posMaxMedia = 0;
        int posMinMedia = 0;

        for (int i = 0; i < notas[0].length; i++) {

            float sumaMediaMaterias = 0;

            for (int o = 0; o < notas.length; o++) {

                sumaMediaMaterias += notas[o][i];

            }

            mediaMaterias[i] = sumaMediaMaterias / notas[0].length;

            if (mediaMaterias[i] > mediaMaterias[posMaxMedia]) {

                posMaxMedia = i;

            } else if (mediaMaterias[i] < mediaMaterias[posMinMedia]) {

                posMinMedia = i;

            }

        }

        //System.out.printf("MediasMaterias%s\n", Arrays.toString(mediaMaterias));
        System.out.printf("La asignatura con la media mas alta es %s con un %.2f \n", materias[posMaxMedia], mediaMaterias[posMaxMedia]);
        System.out.printf("La asignatura con la nota media mas baja es %s con un %.2f \n", materias[posMinMedia], mediaMaterias[posMinMedia]);

    }

}
