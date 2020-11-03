/*
    Por palabra de la frase, todos sus caracteres se desplazan una posicion a la derecha.
 */

package Funciones;

public class Ejercicio67 {

    public static void main(String[] args) {

        char[] frase = new char[]{'H', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á', ' '};

        findWords(frase, false);
        printChar(frase);

    }

    private static void findWords(char[] data, boolean decremental){

        int posFirstCharacterWord = 0;

        for (int i = 0; i < data.length; i++) {

            if (data[i] == ' '){

                int posLastCharacterWord = i - 1;

                if (decremental){

                    moveCharDecremental(data, posFirstCharacterWord, posLastCharacterWord);

                }else{

                    moveCharIncremental(data, posFirstCharacterWord, posLastCharacterWord);

                }

                posFirstCharacterWord = i + 1;

            }

        }

    }

    private static void moveCharDecremental(char[] data, int posFirst, int posLast){

        for (int i = posLast; i > posFirst; i--) {

            char aux = data[i];
            data[i] = data[i - 1];
            data[i - 1] = aux;

        }

    }

    private static void moveCharIncremental(char[] data, int posFirst, int posLast){

        for (int i = posFirst; i < posLast; i++) {

            char aux = data[i];
            data[i] = data[i + 1];
            data[i + 1] = aux;

        }

    }

    private static void printChar(char[] data){

        for (char character : data) {

            System.out.print(character);

        }
        System.out.println();

    }

}
