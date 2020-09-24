public class Ejercicio12v2 {

    public static void main(String[] args) {

        int elementos = 7;
        int tomados = 6;
        int cont = 1;

        for (int i = elementos; i > tomados; i-- ) {

            cont *= i;

        }

        System.out.printf("Variación de %d elementos tomados de %d en %d es %d \n", elementos, tomados, tomados, cont); // La \ es secuencia de escape.

    }
}
