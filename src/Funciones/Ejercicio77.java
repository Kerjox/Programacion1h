/*
    Convertir las vocales que estén en minusculas en mayusculas y viceversa
 */

package Funciones;

public class Ejercicio77 {

    public static void main(String[] args) {

        char[] sentence;
        char[] vocals;

        sentence = new char[]{'h', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á'};
        vocals = new char[]{'a', 'e', 'i', 'o', 'u'};
        doExercise(sentence, vocals);

        System.out.println(sentence);

    }

    private static void doExercise(char[] data, char[] vocals){

        for (char vocal : vocals) {

            for (int i = 0; i < data.length; i++) {

                if (data[i] == Character.toUpperCase(vocal) || data[i] == vocal) {

                    if (data[i] == vocal) {

                        data[i] = Character.toUpperCase(data[i]);

                    } else {

                        data[i] = Character.toLowerCase(vocal);

                    }

                }

            }

        }



    }

}
