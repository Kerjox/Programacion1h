/*
    Intercambiar el último carácter de una palabra con el primero de esa palabra
 */

package FuncionesChar;

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
                mirrorWord(data, posFirstCharacterWord, posLastCharacterWord);
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

            mirrorWord(data, posFirstCharacterWord, posLastCharacterWord - 1);
            posFirstCharacterWord = posLastCharacterWord + 1;

        }

    }

    private static void mirrorWord(char[] data, int posFirst, int posLast) {

        int wordLength = posLast - posFirst;

        for (int i = 0; i <= wordLength / 2; i++) {

            char aux = data[posFirst + i];
            data[posFirst + i] = data[posLast - i];
            data[posLast - i] = aux;

        }



    }

    private static void printChar(char[] frase) {

        for (char character : frase) {

            System.out.print(character);

        }

        System.out.println();

    }

}
