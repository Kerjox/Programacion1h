/*
    Tenermos que sustituir un caracter por otro
 */

package Funciones;

public class Ejercicio63 {

    public static void main(String[] args) {

        System.out.println("Intercambiar un caracter por otro \n");

        char[] frase = new char[]{'H', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á'};
        char sustituir = 'a';
        char sustituto = 'f';

        substitute(frase, sustituir, sustituto);

        printChar(frase);

    }

    private static void printChar(char[] frase) {

        for (char character : frase) {

            System.out.print(character);

        }

        System.out.println();

    }

    private static void substitute(char[] data, char sustituir, char sustituto){

        for (int i = 0; i < data.length; i++) {

            if (data[i] == sustituir){

                data[i] = sustituto;

            }

        }

    }

}
