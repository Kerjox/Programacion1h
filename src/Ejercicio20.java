/*
    desplazar todos los elementos de un array 1 puesto a la izquierda
 */

public class Ejercicio20 {

    public static void main(String[] args) {

        int datos[] = {45, 25, 84, 2, 63, 78, 12};

        for (int i = 0; i < datos.length - 1; i++) {

            int aux = 0;
            aux = datos[i];
            datos[i] = datos[i + 1];
            datos[i + 1] = aux;

        }

        System.out.printf("datos[");

        for (int i = 0; i < datos.length; i++) {

            if (i != datos.length - 1) {

                System.out.printf("%d, ", datos[i]);

            } else {

                System.out.printf("%d]", datos[i]);

            }

        }

    }

}
