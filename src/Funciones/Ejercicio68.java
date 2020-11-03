/*
    Cargar cadena1 en cadena2 y sustituir el caracter por la subcadena, reordenando
 */

package Funciones;

public class Ejercicio68 {

    public static void main(String[] args) {

        char[] frase = new char[]{'H', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á'};
        char sustituir = 'l';
        char[] sustitituto = new char[]{'g', 'g', 'g'};

        char [] solve = copyPlusSustitution(frase, sustituir, sustitituto);
        printChar(solve);


    }

    private static char[] copyPlusSustitution(char[] data, char characterToFind, char[] chainToInsert){

        char[] charMod = new char[data.length + (findCharacter(data, characterToFind) * chainToInsert.length) - chainToInsert.length];

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

        }

    }

    private static int findCharacter(char[] data,char findCharacter){

        int numberConcorances = 0;

        for (char character : data) {

            if (character == findCharacter){

                numberConcorances++;

            }

        }

        return numberConcorances;

    }

    private static void printChar(char[] data){

        for (char character : data) {

            System.out.print(character);

        }
        System.out.println();

    }

}
