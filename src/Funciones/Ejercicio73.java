/*
    Buscar una cadena de caracteres y sustutuirla por otra
 */

package Funciones;

public class Ejercicio73 {

    public static void main(String[] args) {

        char[] sentence;
        char[] find;
        char[] replace;
        char[] solve;

        sentence = new char[]{'H', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á'};
        find = new char[]{'h','o'};
        replace = new char[]{'o', 'o', 'o', 'o'};
        solve = doExercise(sentence, find, replace);

        System.out.println(solve);


    }

    private static char[] doExercise(char[] data, char[] chainToFind, char[] chainToReplace){

        char[] charMod;

        charMod = new char[data.length + numberOfCoincidences(data, chainToFind) * chainToReplace.length - chainToFind.length];

        for (int i = 0, j = 0; i < data.length; i++, j++) {

            if (findConcordanceIn(data, chainToFind, i)){

                for (int k = 0; k < chainToReplace.length; k++) {

                    charMod[j + k] = chainToReplace[k];

                }
                j += chainToFind.length;

            }else{

                charMod[j] = data[i];

            }

        }

        return charMod;

    }

    private static boolean findConcordanceIn(char[] data, char[] chainToFind, int index){

        boolean concordances = false;

        if (data[index] == chainToFind[0]){

            int cont = 1;

            while(cont < chainToFind.length && data[index + cont] == chainToFind[cont]){

                cont++;

            }

            if (cont == chainToFind.length){

                concordances = true;

            }

        }

        return concordances;

    }

    private static int numberOfCoincidences(char[] data, char[] chaintoFind){

        int cont = 0;

        for (int i = 0; i < data.length - chaintoFind.length; i++) {

            if (findConcordanceIn(data, chaintoFind, i)){

                cont++;

            }

        }

        return cont;

    }

}
