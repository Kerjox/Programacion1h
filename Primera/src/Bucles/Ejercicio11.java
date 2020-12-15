package Bucles;/*
    Multiplicacion mediante sumas y mostrar el resultado por pantalla
 */

public class Ejercicio11 {

    public static void main(String[] args) {

        int nMultiplicado = 7;
        int multiplicador = 5;
        int sol = nMultiplicado;

        for (int i = multiplicador; i > 1; i--) {

            sol += nMultiplicado;

        }

        System.out.printf("El resultado es: %s \n", sol);

    }
}
