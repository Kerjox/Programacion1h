/*
    Vamos a añadir un al ejercico 30 precios a los productos
 */

package Bucles;

public class Ejercicio31 {

    public static void main(String[] args) {

        float datos[][]= {
                {45.2f, 21.6f, 3.4f, 10.8f, 99.43f},
                {2.6f, 41.1f, 20.2f, 10.7f, 1.33f},
                {10, 56, 12, 78, 4}
        };

        String productos[] = {"Naranjas", "Peras", "Manzanas"};
        float preciosKilos[] = {0.96f, 0.50f, 0.75f};
        float totalEuros = 0;

        for (int i = 0; i < productos.length; i++) {

            float suma = 0;

            for (int o = 0; o < datos[i].length; o++) {

                suma += datos[i][o];

            }

            totalEuros += suma * preciosKilos[i];
            System.out.printf("Se han vendiodo %.2f kilos de %s a %.2f€/Kilo por un toral de %.2f€\n", suma, productos[i], preciosKilos[i], suma * preciosKilos[i]);

        }

        System.out.printf("En total se ha ganado %.2f€ \n", totalEuros);

    }

}
