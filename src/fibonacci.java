/*
    Sucesión de Fibonacci
 */

public class fibonacci {
    public static void main(String[] args) {

        long n1 = 0;
        long n2 = 1;
        int limit = 10;

        System.out.printf("Sucesión de fibonacci \n");

        for (int i = limit; i > 0; i--) {

            long suma;
            suma = n1 + n2;
            n1 = n2;
            n2 = suma;
            System.out.printf("%d \n", suma);

        }
    }
}