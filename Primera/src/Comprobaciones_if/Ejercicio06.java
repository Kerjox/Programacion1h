package Comprobaciones_if;/*
    Decir si un número termina en 5 o no y mostrarlo por pantalla
 */

public class Ejercicio06 {

    public static void main(String[] args) {

        int n = 30;

        if ((n % 10) == 5) {

            System.out.println("El número " + n + " acaba en 5");

        }else {

            System.out.println("El número " + n + " no acaba en 5");

        }
    }
}