/*
    Savar el empleado que mas cobra y el que menos y su salario medio mensual
    Sabar el mes que mas se cobra y su media por empleado y el que menos
 */

package Bucles;

public class Ejercicio37 {

    static int[][] salarys = {
            {700, 542, 611, 670, 800, 10000},
            {842, 605, 674, 945, 541, 781},
            {9, 1012, 845, 711, 784, 954},
            {745, 674, 956, 914, 456, 854},
            {754, 845, 845, 674, 954, 935}
    };
    static String[] employees = {"Juan", "Pepe", "Iker", "Alberto", "Javier"};
    static String[] months = {"Enero", "Febrero", "Marzo", "Albríl", "Mayo", "Junio"};//, "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public static void main(String[] args) {

        printBestSalarysOfEmployeeAndMedian();
        printWorstSalarysOfEmployeeAndMedian();
        printMonthWithBestMedianSalarys();
        printMonthWithWorstMedianSalarys();

    }

    private static void printBestSalarysOfEmployeeAndMedian() {

        System.out.printf("El empleado que mas ha cobrado en un mes es %s con %d€ y una media de %.2f€ \n", employees[getIndexOfEmployeeBestSalary()], getEmployeeBestSalary(), getMedianBestSalary(getIndexOfEmployeeBestSalary()));

    }

    private static void printWorstSalarysOfEmployeeAndMedian() {

        System.out.printf("El empleado que menos ha cobrado en un mes es %s con %d€ y una media de %.2f€ \n\n", employees[getIndexOfEmployeeWorstSalary()], getEmployeeWorstSalary(), getMedianWorstSalary(getIndexOfEmployeeWorstSalary()));

    }

    private static void printMonthWithBestMedianSalarys() {

        System.out.printf("La mejor media de salarios por mes fué en %s con %.2f€ \n", months[getIndexOfBestMedianMonth()], getBestMedianMonth(getIndexOfBestMedianMonth()));

    }

    private static void printMonthWithWorstMedianSalarys() {

        System.out.printf("La peor media de salarios por mes fué en %s con %.2f€ \n", months[getIndexOfWorstMedianMonth()], getBestMedianMonth(getIndexOfWorstMedianMonth()));

    }

    private static int getIndexOfEmployeeBestSalary() {

        int posEmployeeBestSalary = 0;
        int posBestSalaryX = 0;
        int posBestSalaryY = 0;

        for (int x = 0; x < salarys.length; x++) {

            for (int y = 0; y < salarys[0].length; y++) {

                if (salarys[x][y] > salarys[posBestSalaryX][posBestSalaryY]) {

                    posBestSalaryX = x;
                    posBestSalaryY = y;

                }

            }

        }

        posEmployeeBestSalary = posBestSalaryX;
        return posEmployeeBestSalary;
    }

    private static int getIndexOfEmployeeWorstSalary() {

        int posEmployeeWorstSalary = 0;
        int posWorstSalaryX = 0;
        int posWorstSalaryY = 0;

        for (int x = 0; x < salarys.length; x++) {

            for (int y = 0; y < salarys[0].length; y++) {

                if (salarys[x][y] < salarys[posWorstSalaryX][posWorstSalaryY]) {

                    posWorstSalaryX = x;
                    posWorstSalaryY = y;

                }

            }

        }

        posEmployeeWorstSalary = posWorstSalaryX;
        return posEmployeeWorstSalary;
    }

    private static int getEmployeeBestSalary() {

        int employeeBestSalary = 0;
        int posBestSalaryX = 0;
        int posBestSalaryY = 0;

        for (int x = 0; x < salarys.length; x++) {

            for (int y = 0; y < salarys[0].length; y++) {

                if (salarys[x][y] > salarys[posBestSalaryX][posBestSalaryY]) {

                    posBestSalaryX = x;
                    posBestSalaryY = y;

                }

            }

        }

        employeeBestSalary = salarys[posBestSalaryX][posBestSalaryY];
        return employeeBestSalary;
    }

    private static int getEmployeeWorstSalary() {

        int employeeWorstSalary = 0;
        int posWorstSalaryX = 0;
        int posWorstSalaryY = 0;

        for (int x = 0; x < salarys.length; x++) {

            for (int y = 0; y < salarys[0].length; y++) {

                if (salarys[x][y] < salarys[posWorstSalaryX][posWorstSalaryY]) {

                    posWorstSalaryX = x;
                    posWorstSalaryY = y;

                }

            }

        }

        employeeWorstSalary = salarys[posWorstSalaryX][posWorstSalaryY];
        return employeeWorstSalary;
    }

    private static float getMedianBestSalary(int posEmployeeBestSalary) {

        float medianEmployeeBestSalary = 0;
        int sumMedian = 0;

        for (int x = 0; x < salarys[posEmployeeBestSalary].length; x++) {

            sumMedian += salarys[posEmployeeBestSalary][x];

        }

        medianEmployeeBestSalary = (float) sumMedian / salarys[posEmployeeBestSalary].length;
        return medianEmployeeBestSalary;

    }

    private static float getMedianWorstSalary(int posEmployeeWorstSalary) {

        float medianEmployeeWorstSalary = 0;
        int sumMedian = 0;

        for (int x = 0; x < salarys[posEmployeeWorstSalary].length; x++) {

            sumMedian += salarys[posEmployeeWorstSalary][x];

        }

        medianEmployeeWorstSalary = (float) sumMedian / salarys[posEmployeeWorstSalary].length;
        return medianEmployeeWorstSalary;

    }

    private static int getIndexOfBestMedianMonth() {

        float[] medianSalaryMonths = new float[salarys[0].length];
        int indexOfBestMedianMonth = 0;

        for (int y = 0; y < salarys[0].length; y++) {

            for (int x = 0; x < salarys.length; x++) {

                medianSalaryMonths[y] += salarys[x][y];

            }

            medianSalaryMonths[y] /= (float) salarys.length;

        }

        for (int x = 1; x < medianSalaryMonths.length; x++) {

            if (medianSalaryMonths[x] > medianSalaryMonths[indexOfBestMedianMonth]) {

                indexOfBestMedianMonth = x;

            }

        }

        return indexOfBestMedianMonth;

    }

    private static float getBestMedianMonth(int indexOfBestMedianMonth) {

        float[] medianSalaryMonths = new float[salarys[0].length];

        for (int y = 0; y < salarys[0].length; y++) {

            for (int x = 0; x < salarys.length; x++) {

                medianSalaryMonths[y] += salarys[x][y];

            }

            medianSalaryMonths[y] /= (float) salarys.length;

        }

        return medianSalaryMonths[indexOfBestMedianMonth];

    }

    private static int getIndexOfWorstMedianMonth() {

        float[] medianSalaryMonths = new float[salarys[0].length];
        int indexOfWorstMedianMonth = 0;

        for (int y = 0; y < salarys[0].length; y++) {

            for (int x = 0; x < salarys.length; x++) {

                medianSalaryMonths[y] += salarys[x][y];

            }

            medianSalaryMonths[y] /= (float) salarys.length;

        }

        for (int x = 1; x < medianSalaryMonths.length; x++) {

            if (medianSalaryMonths[x] < medianSalaryMonths[indexOfWorstMedianMonth]) {

                indexOfWorstMedianMonth = x;

            }

        }

        return indexOfWorstMedianMonth;

    }

    private static float getWorstMedianMonth(int indexOfWorstMedianMonth) {

        float[] medianSalaryMonths = new float[salarys[0].length];

        for (int y = 0; y < salarys[0].length; y++) {

            for (int x = 0; x < salarys.length; x++) {

                medianSalaryMonths[y] += salarys[x][y];

            }

            medianSalaryMonths[y] /= (float) salarys.length;

        }

        return medianSalaryMonths[indexOfWorstMedianMonth];

    }

}