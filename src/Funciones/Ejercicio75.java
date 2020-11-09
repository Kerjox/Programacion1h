package Funciones;

public class Ejercicio75 {

    public static void main(String[] args) {

        char[] sentence;
        char[] find;

        sentence = new char[]{'h', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á'};
        find = new char[]{'c', 'h'};
        doExercise(sentence, find);

        System.out.println(sentence);

    }

    private static void doExercise(char[] data, char[] chainToRemove){

        int numberOfReplaces = numberOfReplaces(data, chainToRemove);

        for (int i = 0; i < data.length - chainToRemove.length * numberOfReplaces; i++) {

            if (findChainIn(data, chainToRemove, i)) {

                remove(data, chainToRemove, i);
                i--;

            }

        }

    }

    private static void remove(char[] data, char[] chainToRemove, int i) {

        for (int j = 0; j < chainToRemove.length; j++) {

            for (int y = i; y < data.length - 1; y++) {

                if (y + 1 == data.length - 1) {

                    data[y] = data[y + 1];
                    data[y + 1] = ' ';

                } else {

                    data[y] = data[y + 1];

                }

            }

        }

    }

    private static boolean findChainIn(char[] data, char[] chainToFind, int index){

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

    private static int numberOfReplaces(char[] data, char[] chainToFind){

        int cont = 0;

        for (int i = 0; i < data.length - chainToFind.length; i++) {

            if (findChainIn(data, chainToFind, i)){

                cont++;

            }

        }

        return cont;

    }

}
