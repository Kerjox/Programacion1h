/*
    Calcular la media de los elementos de un array
 */

public class Ejercicio19 {

    static int datos[] = {41, 85, 12, 50, 74};

    public static void main(String[] args) {

        doMedian();

    }

    private static void doMedian() {

        float media = 0;

        for (int i = 0; i < datos.length; i++) {

            media += datos[i];

        }

        media /= datos.length;
        System.out.printf("La media es %.2f", media);

    }
}
