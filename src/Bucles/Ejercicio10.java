/*
    Hacer el factorial de un número y mostrarlo por pantalla
 */

package Bucles;

public class Ejercicio10 {

    public static void main(String[] args) {

        long factorial = 7;
        long sol = factorial;

        for (long i = factorial - 1; i > 1; i--) {

            sol *= i;

        }

        System.out.println(sol);

    }

}