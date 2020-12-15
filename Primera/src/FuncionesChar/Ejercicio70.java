/*
    Copiamos el priemer char dentro de otro invertido
 */

package FuncionesChar;

public class Ejercicio70 {

    public static void main(String[] args) {

        char[] sentence;
        char[] solve;

        sentence = new char[]{'H', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á'};
        solve = invertChar(sentence);

        System.out.println(solve);

    }

    private static char[] invertChar(char[] data){

        char[] charMod = new char[data.length];

        for (int i = 0; i < data.length; i++) {

            charMod[data.length - i - 1] = data[i];

        }

        return charMod;

    }

}
