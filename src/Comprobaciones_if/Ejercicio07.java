package Comprobaciones_if;/*
    Con 2 números calcular su uno es múltiplo de otro o no y mostrarlo por pantalla
 */

public class Ejercicio07 {

    public static void main(String[] args) {

        int x, y;

        x = 25;
        y = 5;

        if (x < y) {

            int aux;

            aux = x;
            x = y;
            y = aux;

        }
        if ((x % y) == 0) {

            System.out.println("El número " + x + " es múltiplo de " + y);

        }else {

            System.out.println("El número " + x + " no es múltiplo de " + y);

        }
    }
}
