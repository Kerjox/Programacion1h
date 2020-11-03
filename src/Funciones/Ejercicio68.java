/*
    Cargar cadena1 en cadena2 y sustituir el caracter por la subcadena, reordenando
 */

package Funciones;

public class Ejercicio68 {

    public static void main(String[] args) {

        char[] frase = new char[]{'H', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á'};
        char sustituir = 'l';
        char[] sustitituto = new char[]{'g', 'g'};


    }

    private static void copyPlusSustitution(char[] data, char characterToFind, char[] charactersToInsert){

        char[] charMod = new char[data.length + findCharacter(data, characterToFind) * charactersToInsert.length];
        charMod = data;

        for (int i = 0; i < data.length; i++) {

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

}
