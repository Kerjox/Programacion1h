/*
    División mediante restas enteras
 */

public class Ejercicio13 {

    public static void main(String[] args) {

        int dividendo = 13;
        int divisor = 4;
        int aux = dividendo;
        int sol = 0;
        int resto;

        while (aux >= divisor){

            aux -= divisor;
            sol++;

        }

        resto = dividendo - divisor * sol;

        System.out.printf("El resultado de dividir %d por %d es: %d y es resto es %d\n", dividendo, divisor, sol, resto);

    }
}
