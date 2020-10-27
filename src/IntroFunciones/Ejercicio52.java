/*
    Hacer la combinaciones de 5 elementos tomados de 2 en dos
 */

package IntroFunciones;

public class Ejercicio52 {

    public static void main(String[] args) {

        System.out.printf("%.2f", doCombination(2, 5));

    }

    private static int factorial(int n) {

        int res = 1;

        for (int i = 2; i <= n; i++) {

            res *= i;

        }

        return res;

    }

    private static float doCombination(int n, int m){

        int nominador = factorial(m) - factorial(m - n);
        int denominador = factorial(m);
        float res = (float) nominador / (float) denominador;

        return res;

    }

}
