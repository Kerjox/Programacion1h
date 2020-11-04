/*
    Cargar cadena1 en cadena2 y sustituir el caracter por la subcadena, reordenando
 */

package Funciones;

public class Ejercicio68 {

    public static void main(String[] args) {

        char[] frise;
        char find;
        char[] replace;
        char[] solve;

        frise = new char[]{'H', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á'};
        find = 'l';
        replace = new char[]{'g', 'g', 'g'};
        solve = copyPlusSubstitution(frise, find, replace);

        System.out.println(solve);

    }

    private static char[] copyPlusSubstitution(char[] data, char characterToFind, char[] chainToInsert){

        char[] charMod = new char[data.length + (numbersCharactersToReplace(data, characterToFind) * chainToInsert.length) - chainToInsert.length];

        copyChar(data, charMod);

        for (int i = 0; i < charMod.length; i++) {

            if (charMod[i] == characterToFind){

                doSpaces(charMod, i, chainToInsert.length - 1);
                insertChain(charMod, i, chainToInsert);
                i += chainToInsert.length - 1;

            }

        }

        return charMod;

    }

    private static void copyChar(char[] data, char[] charMod) {

        for (int i = 0; i < data.length; i++){

            charMod[i] = data[i];

        }

    }

    private static void insertChain(char[] data, int index, char[] chainToInsert){

        for (int i = 0; i < chainToInsert.length; i++) {

            data[index + i] = chainToInsert[i];

        }

    }

    private static void doSpaces(char[] data, int index, int repetitions){

        for (int j = 0; j < repetitions; j++) {

            for (int i = data.length - 1; i > index; i--) {

                data[i] = data[i - 1];

            }

            index++;

        }

    }

    private static int numbersCharactersToReplace(char[] data, char findCharacter){

        int numberConcordances = 0;

        for (char character : data) {

            if (character == findCharacter){

                numberConcordances++;

            }

        }

        return numberConcordances;

    }

}
