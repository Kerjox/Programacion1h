/*
    Tenemos 2 cadenas de caracteres, tenemos que realizar una función que identifique el número de veces que se repite la cadena dentro de la otra
 */

package FuncionesChar;

public class Ejercicio65V2 {

    public static void main(String[] args) {

        System.out.println("Contar cuantas veces se repite una cadena de caracteres dentro de otra cadena de caracteres \n");

        char[] data = new char[] {'n', 'n', 'n', 'n', 'n', 'n', 'n'};
        char[] thingToFind = new char[] {'n', 'n'};

        System.out.printf("Se repite: '%d' veces", findConcordances(data, thingToFind));

    }

    private static int findConcordances(char[] data, char[] thingToFind){

        int numberOfConcordances = 0;

        for (int x = 0; x <= data.length - thingToFind.length; x++) {

            if (data[x] == thingToFind[0]){

                int o = 1;  // Indice subcadena

                while (o < thingToFind.length && data[x + o] == thingToFind[o]){

                    o++;

                }

                if (o == thingToFind.length){

                    numberOfConcordances++;

                }

            }


        }

        return numberOfConcordances;

    }

}

