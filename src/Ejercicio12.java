/*
    Número de variaciones sin repetición
 */

import static java.lang.String.format;

public class Ejercicio12 {

    public static void main(String[] args) {

        int n = 4;
        int m = 7;
        int divisorFactorial = m - n;
        int mFactorial = m;

        if (m < n) {

            System.out.println("Error: No se puede calcualar, m tiene que ser mayor que n.");
            return;

        }

        for (int i = divisorFactorial - 1; i > 1; i--) {

            divisorFactorial *= i;
        }

        for (long i = mFactorial - 1; i > 1; i--) {

             mFactorial *= i;

        }

        int sol = mFactorial / divisorFactorial;

        System.out.println(format("El resultado es: %s", sol));

    }
}
