/*
    Hacer un nuevo char donde sustituimos
 */

package FuncionesChar;

public class Ejercicio64 {

    public static void main(String[] args) {

        char[] frase = new char[]{'H', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á'};
        char sustituir = 'l';
        char[] sustitituto = new char[]{'g', 'g'};

        char[] modChar = doChar(frase, sustituir, sustitituto);

        printChar(modChar);

    }

    private static int numberCharactersSustituir(char[] data, char sustituir){

        int cont = 0;

        for (char character : data) {

            if (character == sustituir){

                cont++;

            }

        }

        return cont;

    }

    private static char[] doChar(char[] data, char sustituir, char[] sustituto) {

        char[] charMod = new char[data.length + numberCharactersSustituir(data, sustituir) * 2];

        for (int i = 0, o = 0; i < data.length; i++, o++) {

            if (data[i] == sustituir) {

                for (char _sustituto : sustituto) {

                    charMod[o] = _sustituto;
                    o++;

                }

                i++;

            }

            charMod[o] = data[i];

        }

        return charMod;

    }

    private static void printChar(char[] frase) {

        for (char character : frase) {

            System.out.print(character);

        }

        System.out.println();

    }

}
