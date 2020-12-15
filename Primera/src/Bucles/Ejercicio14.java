package Bucles;/*
    Declaración de vectores
 */

public class Ejercicio14 {

    public static void main(String[] args) {

        int main[] = {1, 45, 78, 7, 9};

        for (int i = 0; i < main.length; i++) {

            System.out.printf("La posición del array %d es %d \n", i, main[i]);

        }

    // Multiplicamos los números del array * 2

        for (int i = 0; i < main.length; i++) {

            main[i] *= 2;

        }

        for (int i = 0; i < main.length; i++) {

            System.out.printf("La posición del array %d después de modificar es %d \n", i, main[i]);

        }
    }
}
