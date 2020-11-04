/*
    Concatenar cadenas copiando la cadena 1 en un nuevo char y cadena 2 invertida en el char creado
 */

package Funciones;

public class Ejercicio71 {

    public static void main(String[] args) {

        char[] frise;
        char[] solve;

        frise = new char[]{'H', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á', ' '};
        solve = doExercise(frise);

        System.out.println(solve);

    }

    private static char[] doExercise(char[] data){

        char[] charMod;

        charMod = new char[data.length * 2];

        copyChar(data, charMod, 0);
        copyChar(invertChar(data), charMod, data.length - 1);

        return charMod;

    }

    private static void copyChar(char[] data, char[] charMod, int index){

        for (int i = 0; i < data.length; i++) {

            charMod[index + i] = data[i];

        }

    }

    private static char[] invertChar(char[] data){

        char[] charmod;

        charmod = new char[data.length];

        for (int i = 0; i < data.length; i++) {

            charmod[data.length - i - 1] = data[i];

        }

        return charmod;

    }

}
