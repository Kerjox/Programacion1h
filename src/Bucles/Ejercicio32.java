/*
    Tenemos un cine con 4 salas y guardo en un array vidimensional cuantas entradas se venden en la semana.
    Sacar el día que más entradas se vendieron
 */

package Bucles;

import java.util.Arrays;

public class Ejercicio32 {

    public static void main(String[] args) {

        int[][] datos= {
                {45, 21, 3, 10, 99, 45, 90},
                {2, 41, 20, 10, 1, 20, 47},
                {10, 56, 12, 78, 4, 20, 90},
                {10, 20, 64, 30, 81, 70, 30}
        };
        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        int[] totalEntradasPorDia = new int[7];

        for (int i = 0; i < datos[0].length; i++) {

            for (int[] dato : datos) {

                totalEntradasPorDia[i] += dato[i];

            }

            /*
            for (int o = 0; o < datos.length; o++) {

                totalEntradasPorDia[i] += datos[o][i];

            }
             */

        }

        System.out.println(Arrays.toString(totalEntradasPorDia));

        int maxPos = 0;
        int minPos = 0;

        for (int i = 1; i < totalEntradasPorDia.length; i++) {

            if (totalEntradasPorDia[i] > totalEntradasPorDia[maxPos]) {

                maxPos = i;

            } else if (totalEntradasPorDia[i] < totalEntradasPorDia[minPos]){

                minPos = i;

            }

        }

        System.out.printf("El día que más entradas se vendidieron fué el %s con %d \n", dias[maxPos], totalEntradasPorDia[maxPos]);
        System.out.printf("El día que menos entradas se vendideron fué el %s con %d \n", dias[minPos], totalEntradasPorDia[minPos]);

    }

}
