package Bucles;/*
    Mostrar el valor más alto de un vector
 */

public class Ejercicio15 {

    public static void main(String[] args) {

        int vector[] = {-78, -45, -96, -12, -74};
        int sol = vector[0];

        for (int i = 1; i < vector.length; i++) {

                if (vector[i] > sol) {

                    sol = vector[i];

            }
        }

        System.out.printf("El número más alto es %d \n", sol);

        int posmax = 0;

        for (int i = 1; i < vector.length; i++) {

            if (vector[i] > vector[posmax]) {

                posmax = i;

            }
        }

        System.out.printf("La posición del número más alto es %d que es %d \n", posmax, vector[posmax]);

    }
}
