/*
    Contar el número de palabras de un char
 */
package FuncionesChar;

public class Ejercicio59 {

    public static void main(String[] args) {

        System.out.println("Contar el número de palabras de un char \n");

        char[] frase;
        frase = new char[]{'H', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a'};

        System.out.printf("El número de palabras del char es: %d \n", numberWordsInChar(frase));;

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
