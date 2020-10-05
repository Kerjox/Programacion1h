/*
    El pimer elemeto de datos nos indica cuantos kilos de naranjas hemos vendico
    el lunes, cada elemeto de datos son los kilos que se han vendido de Naranjas en toda la semana.
    Mostar cuantos kilos se han vendido de cada producto en la semana
 */

package Bucles;

public class Ejercicio30 {

    public static void main(String[] args) {

        float datos[][] = {{45.2f, 21.6f, 3.4f, 10.8f, 99.43f}, {2.6f, 41.1f, 20.2f, 10.7f, 1.33f}, {10, 56, 12, 78, 4}};
        String productos[] = {"Naranjas", "Peras", "Manzanas"};

        for (int i = 0; i < productos.length; i++) {

            float suma = 0;

            for (int o = 0; o < datos[i].length; o++) {

                suma += datos[i][o];

            }

            System.out.printf("Se han vendiodo %.2f kilos de %s \n", suma, productos[i]);

        }

    }

}
