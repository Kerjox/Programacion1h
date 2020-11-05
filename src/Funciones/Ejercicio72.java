/*
    Invertir las palabras de la cadena sin cambiar el orden
 */

package Funciones;

public class Ejercicio72 {

    public static void main(String[] args) {

        char[] sentence;
        char[] solve;

        sentence = new char[]{'H', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á', ' '};
        solve = doExcercise(sentence);

        System.out.println(solve);

    }

    private static char[] doExcercise(char[] data){

        char[] charMod;
        int firstCharacterWord;
        int lastCharacterWord;

        charMod = new char[data.length];
        firstCharacterWord = 0;

        for (int i = 0; i < data.length; i++) {

            if (data[i] == ' '){

                char[] wordToInsert;
                char[] invertedWordToInsert;

                lastCharacterWord = i - 1;
                wordToInsert = extractWord(data, firstCharacterWord, lastCharacterWord);
                firstCharacterWord = i + 1;
                invertedWordToInsert = invertText(wordToInsert);
                insertChar(charMod, invertedWordToInsert, i - invertedWordToInsert.length);
                charMod[i] = ' ';

            }

        }

        return charMod;

    }

    private static void insertChar(char[] data, char[] wordToInsert, int index){

        for (int i = 0; i < wordToInsert.length; i++) {

            data[index++] = wordToInsert[i];

        }

    }

    private static char[] extractWord(char[] data,int firstPosWord, int lastPosWord){

        char[] word;

        word = new char[lastPosWord - firstPosWord + 1];

        for (int i = firstPosWord, f = 0; i <= lastPosWord; i++, f++) {

            word[f] = data[i];

        }

        return word;

    }

    private static char[] invertText(char[] data){

        char[] charMod;

        charMod = new char[data.length];

        for (int i = 0; i < data.length; i++) {

            charMod[data.length - i - 1] = data[i];

        }

        return charMod;

    }

}
