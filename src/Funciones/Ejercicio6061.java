/*
    Tenermos una cadena de carácteres, crear una nueva que se aigual que la anterior pero que despés de cada palabra le añada una x
 */

package Funciones;

public class Ejercicio6061 {

    public static void main(String[] args) {

        System.out.println("Añadir una 'x' al final de cada palabra \n");

        char[] frase;
        frase = new char[]{'H', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á'};

        char[] charMod;
        charMod = modifyChar(frase);

        String result = String.valueOf(charMod);

        System.out.printf("%s \n", result);

    }

    private static char[] modifyChar(char[] data){

        int numberWordsInData = numberWordsInChar(data);
        char[] charMod;
        charMod = new char[numberWordsInData + data.length];

        for (int i = 0,o = 0; i < data.length; i++, o++) {

            if (i == data.length - 1) {

                charMod[o + 1] = 'x';

            }else if (data[i] == ' ') {

                charMod[o] = 'x';
                o++;


            }

            charMod[o] = data[i];

        }

        return charMod;

    }

    private static int numberWordsInChar(char[] data){

        int numCharacters = 1;

        for (int character : data) {

            if (character == ' '){

                numCharacters++;

            }

        }

        return numCharacters;

    }

}
