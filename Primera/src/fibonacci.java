/*
    Sucesión de Fibonacci
 */

public class fibonacci {
    public static void main(String[] args) {

        System.out.println("Sucesión de fibonacci");
        doFibonacci(10);

    }

    private static void doFibonacci(int limit) {

        Integer n1 = 0;
        Integer n2 = 1;

        for (int i = 0; i < limit; i++) {

            Integer summa = n1 + n2;
            n1 = n2;
            n2 = summa;
            System.out.printf("%d \n", summa);

        }

    }

}