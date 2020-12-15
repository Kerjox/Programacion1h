/*
    Sobre la cadena eliminar el caracter especificado
 */

package FuncionesChar;

public class Ejercicio74 {

    public static void main(String[] args) {

        char[] sentence;
        char character;

        sentence = new char[]{'H', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'a'};
        character = 'a';
        doExercise(sentence, character);

        System.out.println(sentence);

    }

    private static void doExercise(char[] data, char characterToRemove){

        for (int i = 0; i < data.length; i++) {

            if (data[i] == characterToRemove){

                for (int j = i; j < data.length - 1; j++) {

                    if (j + 1 == data.length - 1){

                        data[j] = data[j + 1];
                        data[j + 1] = ' ';

                    }else{

                        data[j] = data[j + 1];

                    }

                }

                i--;

            }

        }

    }

}
