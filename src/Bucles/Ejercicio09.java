package Bucles;/*
    Hacer un bucle que hace una tabla de multiplicar y mostrarlo po pantalla
 */

public class Ejercicio09 {

    public static void main(String[] args) {

        int n = 5;

        for (int i = 1; i <= 10; i++) {

            System.out.printf("%s por %s es %s \n", n, i, n*i);

        }
    }
}