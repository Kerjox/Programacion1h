/*
    Contar el número de veces que aparece el caracter 'a' dentro de el vector
 */

package Strings;

public class Ejercicio82 {

    public static void main(String[] args) {

        String[] data = {"Hola", "alcachofa", "escachuflá"};
        int solve = countCharacterInArrayOfStrings(data, 'a');

        System.out.printf("%d veces aparece el caracter 'a' en las palabras", solve);

    }

    private static int countCharacterInArrayOfStrings(String[] data, char find){

        int cont = 0;

        for(String word : data){

            for (int i = 0; i < word.length(); i++) {

                if (word.charAt(i) == find){

                    cont++;

                }

            }

        }

        return cont;

    }

}
