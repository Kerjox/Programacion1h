/*
    Ordenar los nombres por orden alfabetico
 */

package FuncionesChar;

import java.util.Arrays;

public class Ejercicio79 {

    public static void main(String[] args) {

        String[] names = {"Juan", "Alfredo", "Coco", "Daniel"};
        order(names);

        System.out.println(Arrays.toString(names));

    }

    private static void order(String[] data){

        for (int i = 0; i < data.length; i++) {

            for (int j = data.length - 1; j > 0; j--) {

                if (data[j - 1].compareTo(data[j]) > 0){

                    String aux;

                    aux = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = aux;

                }

            }

        }

    }

}
