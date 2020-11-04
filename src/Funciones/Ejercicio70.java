/*
    Copiamos el priemer char dentro de otro invertido
 */

package Funciones;

public class Ejercicio70 {

    public static void main(String[] args) {

        char[] frise;
        char[] solve;

        frise = new char[]{'H', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á'};
        solve = invertChar(frise);

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
