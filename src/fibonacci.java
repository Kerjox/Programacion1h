/*
    Sucesión de Fibonacci
 */

public class fibonacci {
    public static void main(String[] args) {

        System.out.println("Sucesión de fibonacci");
        doFibonacci(10);

    }
    private static void doFibonacci(int limit) {

        long n1 = 0;
        long n2 = 1;

        for (int i = limit; i > 0; i--){

            long summa;
            summa = n1 + n2;
            n1 = n2;
            n2 = summa;
            System.out.printf("%d \n", summa);

        }

    }

}