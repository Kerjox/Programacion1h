package Bucles;/*
    Calcular la media de los elementos de un array y mostar los números superiores a la media
 */

public class Ejercicio19 {

    public static void main(String[] args) {

        int datos[] = {41, 85, 12, 50, 74};
        float mediaDatos = doMedian(datos);
        compareMedian(datos, mediaDatos);

    }

    private static float doMedian(int[] datos) {

        float media = 0;

        for (int i = 0; i < datos.length; i++) {

            media += datos[i];

        }

        media /= datos.length;
        System.out.printf("La media es %.2f \n", media);
        return media;


    }

    private static void compareMedian(int datos[], float media) {

        for (int i = 0; i < datos.length; i++) {

            if (datos[i] > media) {

                System.out.printf("El valor %d es superior a la media \n", datos[i]);

            }

        }

    }
}
