/*
    Poner en mayusculas la string dentro de un vector de strings
 */

package Strings;

import java.util.Arrays;

public class Ejercicio83 {

    public static void main(String[] args) {

        String[] data = {"Hola", "alcachofa", "escachufla"};
        String find = "la";

        for (int i = 0; i < data.length; i++){

            data[i] = data[i].replace(find, find.toUpperCase());

        }

        data[0] = data[0].concat("s");

        System.out.println(Arrays.toString(data));

    }

}
