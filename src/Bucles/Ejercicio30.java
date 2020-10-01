/*
    El pimer elemeto de datos nos indica cuantos kilos de naranjas hemos vendico
    el lunes, cada elemeto de datos son los kilos que se han vendido de Naranjas en toda la semana.
    Mostar cuantos kilos se han vendido de cada producto en la semana
 */

package Bucles;

public class Ejercicio30 {

    public static void main(String[] args) {

        int datos[][] = {{45, 21, 3, 10, 99}, {2, 41, 20, 10, 1}, {10, 56, 12, 78, 4}};
        String productos[] = {"Naranjas", "Peras", "Manzanas"};

        for (int i = 0; i < productos.length; i++) {

            int suma = 0;

            for (int o = 0; o < datos[i].length; o++) {

                suma += datos[i][o];

            }

            System.out.printf("Se han vendiodo %d kilos de %s \n", suma, productos[i]);

        }

    }

}
