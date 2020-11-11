/*
    Utilizar la función substring
 */
package Strings;

public class Ejercicio80 {

    public static void main(String[] args) {

        String sentence = "Hola alcachofa escachofá";

        String substring = sentence.substring(5, 14);

        System.out.println(substring);

        for (int i = 0; i < sentence.length(); i++) {

            System.out.println(sentence.substring(0, i));

        }

    }

}
