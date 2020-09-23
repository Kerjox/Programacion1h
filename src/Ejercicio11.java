/*
    Multiplicacion mediante sumas y mostrar el resultado por pantalla
 */

import static java.lang.String.format;

public class Ejercicio11 {
    public static void main(String[] args) {

        int multiplicando = 7;
        int multiplicador = 5;
        int sol = multiplicando;

        for (int i = multiplicador; i > 1; i--) {

            sol += multiplicando;

        }

        System.out.println(format("El resultado es: %s", sol));

    }
}
