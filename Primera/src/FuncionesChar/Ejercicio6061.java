/*
    Tenermos una cadena de carácteres, crear una nueva que sea igual que la anterior pero que después de cada palabra le añada una x
 */

package FuncionesChar;

public class Ejercicio6061 {

    public static void main(String[] args) {

        System.out.println("Añadir una 'x' al final de cada palabra \n");

        char[] sentence;
        sentence = new char[]{'H', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á'};

        char[] charMod;
        charMod = doExercise(sentence);

        System.out.println(charMod);

    }

    private static char[] doExercise(char[] data){

        int numberWordsInChar;
        char[] charMod;

        numberWordsInChar = numberWordsInChar(data);
        charMod = new char[numberWordsInChar + data.length];

        for (int i = 0, o = 0; i < data.length; i++, o++) {

            charMod[o] = data[i];

            if (i == data.length - 1 || data[i + 1] == ' '){

                charMod[o + 1] = 'x';
                o++;

            }

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
