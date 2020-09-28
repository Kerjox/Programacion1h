/*
    desplazar todos los elementos de un array 1 puesto a la izquierda
 */

public class Ejercicio20 {

    public static void main(String[] args) {

        int datos[] = {45, 25, 84, 2, 63};

        for (int i = 0; i < datos.length; i++) {

            int aux = 0;
            aux = datos[i + 1];
            datos[i] = datos[i + 1];
            datos[i] = aux;

        }

        System.out.printf("datos[");

        for (int i = 0; i < datos.length; i++) {

            if (i != 5) {

                System.out.printf("%d, ", datos[i]);

            } else {

                System.out.printf("%d]", datos[i]);

            }

        }

    }

}
