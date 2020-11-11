/*
    Quitar los espacios sin utilizar .replace
 */

package Strings;

public class Ejercicio84 {

    public static void main(String[] args) {

        String sentence = "Hola alcachofa al escachofá en la calle";
        String solve = "";

        for (int i = 0; i < sentence.length(); i++) {

            if (sentence.charAt(i) != ' '){

                solve = solve.concat(sentence.substring(i, i + 1));

            }

        }

        System.out.println(solve);

    }

}
