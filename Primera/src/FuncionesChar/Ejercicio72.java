/*
    Invertir las palabras de la cadena sin cambiar el orden
 */

package FuncionesChar;

public class Ejercicio72 {

    public static void main(String[] args) {

        char[] sentence;
        char[] solve;

        sentence = new char[]{' ', 'H', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á'};
        solve = invertWordsInChar(sentence);

        System.out.println(solve);

    }

    private static char[] invertWordsInChar(char[] data){

        char[] charMod;
        int firstCharacterWord;
        int lastCharacterWord;

        charMod = new char[data.length];
        lastCharacterWord = data.length - 1;

        for (int i = data.length - 1; i >= 0; i--) {

            if (data[i] == ' '){

                char[] wordToInsert;
                char[] invertedWordToInsert;

                firstCharacterWord = i;
                wordToInsert = extractWord(data, firstCharacterWord, lastCharacterWord);
                lastCharacterWord = i - 1;
                insertChar(charMod, wordToInsert, data.length - (i + wordToInsert.length));
                charMod[data.length - (i + wordToInsert.length)] = ' ';

            }

        }

        return charMod;

    }

    private static void insertChar(char[] data, char[] wordToInsert, int index){

        for (char word : wordToInsert) {

            data[index++] = word;

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

    private static char[] invertWord(char[] data){

        char[] invertedWord;

        invertedWord = new char[data.length];

        for (int i = 0; i < data.length; i++) {

            invertedWord[data.length - i - 1] = data[i];

        }

        return invertedWord;

    }

}
