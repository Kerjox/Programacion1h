/*
    Mostrar que película y en que día tubo mas y menos audiencia de todas, y cuantas entradas se vendieron de dichas películas.
 */

package Bucles;

import java.util.Arrays;

public class Ejercicio34 {

    public static void main(String[] args) {

        int[][] datos= {
                {45, 21, 3, 10, 9, 45, 90},
                {2, 41, 20, 101, 1, 20, 47},
                {10, 56, 12, 78, 4, 100, 90},
                {10, 20, 64, 30, 81, 70, 30}
        };
        String[] peliculas = {"Al filo del mañana", "Interstellar", "Alita", "Oblivion"};
        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        int maxPosF = 0;
        int maxPosC = 0;
        int minPosF = 0;
        int minPosC = 0;

        for (int f = 0; f < datos.length; f++) {

            for (int c = 0; c < datos.length; c++) {

                if (datos[maxPosF][maxPosC] < datos[f][c]) {

                    maxPosF = f;
                    maxPosC = c;

                }else if (datos[minPosF][minPosC] > datos[f][c]){

                    minPosF = f;
                    minPosC = c;

                }

            }

        }

        System.out.printf("La pelicula que mas estradas se han vendido en 1 día ha sido %s con %d el día %s \n", peliculas[maxPosF], datos[maxPosF][maxPosC], dias[maxPosC]);
        System.out.printf("La pelicula que menos estradas se han vendido en 1 día ha sido %s con %d el día %s \n", peliculas[minPosF], datos[minPosF][minPosC], dias[minPosC]);

    }

}
