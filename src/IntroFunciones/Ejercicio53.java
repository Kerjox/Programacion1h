/*
    Mostrar el total de dinero que ha ganado el empleado con una función que te sume los vectores por separado.
 */

package IntroFunciones;

public class Ejercicio53 {

    public static void main(String[] args) {

        int[][] salarys = {
                {700, 542, 611, 670, 800, 10000},
                {842, 605, 674, 945, 541, 781},
                {9, 1012, 845, 711, 784, 954},
                {745, 674, 956, 914, 456, 854},
                {754, 845, 845, 674, 954, 935}
        };
        String[] employees = {"Juan", "Pepe", "Iker", "Alberto", "Javier"};

        for (int i = 0; i < employees.length; i++) {

            System.out.printf("El empleado '%s' ha ganado '%d€' \n", employees[i], sumArray(salarys[i]));

        }

    }

    private static int sumArray(int[] data){

        int sum = 0;

        for (int datum : data) {

            sum += datum;

        }

        return sum;

    }

}
