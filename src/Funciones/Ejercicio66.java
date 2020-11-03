/*
    Intercambiar el último carácter de una palabra con el primero de esa palabra
 */

package Funciones;

public class Ejercicio66 {

    public static void main(String[] args) {

        char[] frase = new char[]{'H', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á', ' '};

        findWordsFor(frase);

        //findWordsWhile(frase);

        printChar(frase);


    }

    private static void findWordsFor(char[] data){

        int posFirstCharacterWord = 0;

        for (int i = 0; i < data.length; i++) {

            if (data[i] == ' '){

                int posLastCharacterWord = i - 1;
                switchCharacters(data, posFirstCharacterWord, posLastCharacterWord);
                posFirstCharacterWord = i + 1;

            }

        }

    }

    private static void findWordsWhile(char[] data){

        int posFirstCharacterWord = 0;
        int posLastCharacterWord = 0;

        while(posLastCharacterWord < data.length){

            while(data[posLastCharacterWord] != ' '){

                posLastCharacterWord++;

            }

            switchCharacters(data, posFirstCharacterWord, posLastCharacterWord - 1);
            posFirstCharacterWord = ++posLastCharacterWord;

        }

    }

    private static void switchCharacters(char[] data, int posFirst, int posLast) {

        char aux = data[posFirst];
        data[posFirst] = data[posLast];
        data[posLast] = aux;

    }

    private static void printChar(char[] frase) {

        for (char character : frase) {

            System.out.print(character);

        }

        System.out.println();

    }

}
