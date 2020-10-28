/*
    Tenemos 2 cadenas de caracteres, tenemos que realizar una función que identifique el número de veces que se repite la cadena dentro de la otra
 */

package Funciones;

public class Ejercicio65 {

    public static void main(String[] args) {

        System.out.println("Contar cuantas veces se repite una cadena de caracteres dentro de otra cadena de caracteres \n");

        char[] data = new char[] {'n', 'a', 'a', 'x', 'n', 'n', 'n'};
        char[] thingToFind = new char[] {'a', 'x'};

        System.out.printf("Se repite: '%d' veces", findConcordances(data, thingToFind));

    }

    private static int findConcordances(char[] data, char[] thingToFind){

        int numberOfConcordances = 0;

        for (int x = 0; x < data.length - thingToFind.length + 1; x++) {

            int verifyString = 0;

            for (int i = x, o = 0; o < thingToFind.length; i++, o++) {

                if (data[i] != thingToFind[o]){

                    break;

                }

                verifyString++;

            }

            if (verifyString == thingToFind.length){

                numberOfConcordances++;

            }

        }

        return numberOfConcordances;

    }

}
