/*
    Creamos otro char y copiamos los datos del primer char en el segundo 2 veces
 */

package Funciones;

public class Ejercicio69 {

    public static void main(String[] args) {

        char[] frise;
        char[] solve;
        int repetitions;

        frise = new char[]{'H', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á'};
        repetitions = 2;
        solve = copyTwiceInNewChar(frise, repetitions);

        System.out.println(solve);

    }

    private static char[] copyTwiceInNewChar(char[] data, int repetitions){

        char[] charMod = new char[data.length * repetitions];

        for (int i = 0; i < repetitions; i++) {

            copyChar(charMod, data, data.length * i);

        }

        return charMod;

    }

    private static void copyChar(char[] data, char[] dataToCopy,int index){

        for (int i = 0; i < dataToCopy.length; i++) {

            data[index + i] = dataToCopy[i];

        }

    }

}
