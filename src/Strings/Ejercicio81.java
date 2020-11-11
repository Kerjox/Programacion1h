

package Strings;

public class Ejercicio81 {

    public static void main(String[] args) {

        String sentence = "Hola alcachofa al escachofá en la calle";

        int indexOfal = sentence.indexOf("al");
        int lastIndexOfal = sentence.lastIndexOf("al");
        int secondIndexOfal = sentence.indexOf("al", indexOfal + "al".length());
        sentence = sentence.replace("Hola", "hhhhhh");


        System.out.println(sentence);
        System.out.println(indexOfal);
        System.out.println(lastIndexOfal);
        System.out.println(secondIndexOfal);
        System.out.printf("El número de veces que se repite el String 'la' es %d", countRepetitions(sentence, "al"));

    }

    private static int countRepetitions(String data, String stringToFind){

        int cont = 0;
        int index = 0;
        int k;

        while((k = data.indexOf(stringToFind, index)) != -1){

            index = k + stringToFind.length();
            cont++;

        }

        return cont;

    }

}