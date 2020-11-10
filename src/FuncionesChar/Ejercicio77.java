/*
    Convertir las vocales que estén en minusculas en mayusculas y viceversa
 */

package FuncionesChar;

public class Ejercicio77 {

    public static void main(String[] args) {

        char[] sentence;

        sentence = new char[]{'h', 'O', 'l', 'a', ' ', 'A', 'l', 'c', 'a', 'c', 'h', 'O', 'f', 'a' , ' ', 'E', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á'};
        doExercise(sentence);

        System.out.println(sentence);

    }

    private static void doExercise(char[] data){

        for(int i = 0; i < data.length; i++){

            switch (data[i]) {
                case 'a', 'e', 'i', 'o', 'u' -> data[i] = Character.toUpperCase(data[i]);
                case 'A', 'E', 'I', 'O', 'U' -> data[i] = Character.toLowerCase(data[i]);
            }

        }



    }

}