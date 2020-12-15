/*
    Hacer una función que reciba un array desordenado y lo ordene
 */

package IntroFunciones;

import java.util.Arrays;

public class Ejercicio50 {

    public static void main(String[] args) {

        int [] data = {54, 2, 45, 79, 30, 74, 95, 40};

        System.out.printf("El array desordenado \n data %s", Arrays.toString(data));

        orderElements(data);

        System.out.printf("\n El array ordenado \n data %s", Arrays.toString(data));

    }

    private static void orderElements(int[] data){

        for (int i = 1; i < data.length; i++) {

            int cont = i;

            while (cont > 0 && data[cont] < data[cont - 1]) {

                int _aux = data[cont];
                data[cont] = data[cont - 1];
                data[cont - 1] = _aux;
                cont--;

            }

        }

    }

}
