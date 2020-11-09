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

        sentence = new char[]{'h', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á'};
        find = new char[]{'a', ' '};
        replace = new char[]{'L', 'L', 'L', 'L'};
        solve = doExercise(sentence, find, replace);

        System.out.println(solve);


    }

    private static char[] doExercise(char[] data, char[] chainToFind, char[] chainToReplace){

        char[] charMod;
        int numberSubstitutions;

        numberSubstitutions = numberOfCoincidences(data, chainToFind);

        charMod = new char[data.length + numberSubstitutions * chainToReplace.length - chainToFind.length * numberSubstitutions];

        for (int i = 0, j = 0; i < data.length; i++, j++) {

            if (findConcordanceIn(data, chainToFind, i)){

                System.arraycopy(chainToReplace, 0, charMod, j, chainToReplace.length);

                j += chainToReplace.length - 1;
                i += chainToFind.length - 1;

            }else{

                charMod[j] = data[i];

            }

        }

        return charMod;

    }

    private static boolean findConcordanceIn(char[] data, char[] chainToFind, int index){

        if (data[index] == chainToFind[0]){

            int cont = 1;

            while(cont < chainToFind.length && data[index + cont] == chainToFind[cont]){

                cont++;

            }

            if (cont == chainToFind.length){

                return true;

            }

        }

        return false;

    }

    private static int numberOfCoincidences(char[] data, char[] chainToFind){

        int cont = 0;

        for (int i = 0; i < data.length - chainToFind.length; i++) {

            if (findConcordanceIn(data, chainToFind, i)){

                cont++;

            }

        }

        return cont;

    }

}