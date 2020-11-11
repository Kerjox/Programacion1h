/*

 */

package Strings;

public class Ejercicio78 {

    public static void main(String[] args) {

        String sentence;
        char[] solve;

        sentence = "Hola alcachofa escachufá";
        solve = stringToChar(sentence);

        System.out.println(solve);

    }

    private static char[] stringToChar(String data){

        char[] solve = new char[data.length()];

        for (int i = 0; i < data.length(); i++) {

            solve[i] = data.charAt(i);

        }

        return solve;

    }

}
