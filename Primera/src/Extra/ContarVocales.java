/*
    Contar las vocales de una string
 */

package Extra;

public class ContarVocales {

    public static void main(String[] args) {

        String sentence = "La lluvia en Sevilla es una maravilla";
        int numberVocals;

        numberVocals = countVocals(sentence);

        System.out.printf("El número de vocales que hay en la cadena: \n %s \n es: %d", sentence, numberVocals);

    }

    private static int countVocals(String data){

        char[] vocals = new char[]{'a', 'e', 'i', 'o', 'u'};
        int numberVocals = 0;

        for (int i = 0; i < data.length(); i++) {

            for (char vocal : vocals) {

                if (data.charAt(i) != ' ' && (data.charAt(i) == vocal || data.charAt(i) == Character.toUpperCase(vocal))){

                    numberVocals++;

                }

            }



        }

        return numberVocals;

    }

}
