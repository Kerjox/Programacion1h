package Funciones;

import java.util.Arrays;

public class Ejercicio49 {

    public static void main(String[] args) {

        int[][] salarys = {
                {700, 542, 611, 670, 800, 10000},
                {842, 605, 674, 945, 541, 781},
                {9, 1012, 845, 711, 784, 954},
                {745, 674, 956, 914, 456, 854},
                {754, 845, 845, 674, 954, 935}
        };
        String[] employees = {"Juan", "Pepe", "Iker", "Alberto", "Javier"};
        String[] months = {"Enero", "Febrero", "Marzo", "Albríl", "Mayo", "Junio"};//, "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        int[] totalSalarys = getTotalSalarys(salarys);
        printsalarysEmployees(totalSalarys, employees);

    }

    private static int[] getTotalSalarys(int[][] data) {

        int[] res = new int[data.length];

        for (int x = 0; x < data.length; x++) {

            for (int y = 0; y < data[0].length; y++) {

                res[x] += data[x][y];

            }

        }

        return res;

    }

    private static void printsalarysEmployees(int[] data, String[] employees) {

        for (int i = 0; i < data.length; i++) {

            System.out.printf("El empleado '%s' ha cobrado '%d€' en el primer semestre \n", employees[i], data[i]);

        }

    }

}
