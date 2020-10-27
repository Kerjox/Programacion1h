/*
    Hacer un afuncion que debuelva un array de lo que se ha pagado cada mes
 */

package IntroFunciones;

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

        int[] totalSalarys = getTotalSalarysPerEmployee(salarys);
        printTotalSalarysEmployees(totalSalarys, employees);

        System.out.printf("\n");

        int[] totalSalarysPerMonth = getTotalSalarysPerMonth(salarys);
        printSalarysPerMonth(totalSalarysPerMonth, months);

    }

    private static int[] getTotalSalarysPerEmployee(int[][] data) {

        int[] res = new int[data.length];

        for (int x = 0; x < data.length; x++) {

            for (int y = 0; y < data[0].length; y++) {

                res[x] += data[x][y];

            }

        }

        return res;

    }

    private static void printTotalSalarysEmployees(int[] data, String[] employees) {

        for (int i = 0; i < data.length; i++) {

            System.out.printf("El empleado '%s' ha cobrado '%d€' en el primer semestre \n", employees[i], data[i]);

        }

    }

    private static int[] getTotalSalarysPerMonth(int[][] data) {

        int[] res = new int[data[0].length];

        for (int x = 0; x < data.length; x++) {

            for (int y = 0; y < data[0].length; y++) {

                res[y] += data[x][y];

            }

        }

        return res;

    }

    private static void printSalarysPerMonth(int[] data, String[] months) {

        for (int i = 0; i < data.length; i++) {

            System.out.printf("El mes '%s' han pagado '%d€' a los empleados \n", months[i], data[i]);

        }

    }

}
