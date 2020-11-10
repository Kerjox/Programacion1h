/*
    Poner en mayusculas el primer caracter y el último de una palabra
 */

package FuncionesChar;

public class Ejercicio76 {

    public static void main(String[] args) {

        char[] sentence;

        sentence = new char[]{'h', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á'};
        doExercise(sentence);

        System.out.println(sentence);

    }

    private static void doExercise(char[] data){

        int fistCharacterWord = 0;

        for (int i = 0; i < data.length; i++) {

            if (i == data.length - 1 || data[i + 1] == ' '){

                data[fistCharacterWord] = Character.toUpperCase(data[fistCharacterWord]);
                data[i] = Character.toUpperCase(data[i]);
                fistCharacterWord = i + 2;


            }

        }

    }

}
