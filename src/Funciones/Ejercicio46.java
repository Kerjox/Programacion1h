/*
    Manejo de metodos
 */

package Funciones;

public class Ejercicio46 {

    public static void main(String[] args) {

        String palabras = "Manzana, pera, alcachofa";

        System.out.printf("%s \n", escribir("Hello World", palabras));
        System.out.printf("Suma %d \n", suma(21, 19));

    }

    private static String escribir(String hello, String palabras) {

        System.out.printf("%s \n", hello);
        System.out.printf("%s \n", palabras);

        return "He hablado";

    }

    private static int suma(int n1, int n2){

        int res = n1 + n2;

        return res;

    }

}
