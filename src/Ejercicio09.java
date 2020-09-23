/*
    Hacer un bucle que hace una tabla de multiplicar y mostrarlo po pantalla
 */

import static java.lang.String.format;

public class Ejercicio09 {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= 10; i++) {
            System.out.println(format("%s por %s es %s", n, i, n*i));
        }
    }
}