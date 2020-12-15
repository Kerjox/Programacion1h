package Bucles;/*
    Mostrar el valor más alto de un vector y el minimo
 */

public class Ejercicio16 {

    public static void main(String[] args) {

        int vector[] = {-78, -45, -96, -12, -74};
        int max = vector[0];
        int min = vector[0];
        int pMax = 0;
        int pMin = 0;

        for (int i = 1; i < vector.length; i++) {

            if (vector[i] > max) {

                max = vector[i];

            } else if (vector[i] < min) {

                min = vector[i];

            }
        }

        System.out.printf("El número más alto es %d \n", max);
        System.out.printf("El número más pequeño es %d \n", min);

/*
    Por posición
 */

        for (int i = 1; i < vector.length; i++) {

            if (vector[i] > vector[pMax]) {

                pMax = i;

            } else if (vector[i] < vector[pMin]) {

                pMin = i;

            }
        }

        System.out.printf("La posición del número más alto es %d que es %d \n", pMax, vector[pMax]);
        System.out.printf("La posición del número más pequeño es %d que es %d \n", pMin, vector[pMin]);

    }
}

