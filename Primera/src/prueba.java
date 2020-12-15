public class prueba {

    static int filasTablero = 3;
    static int tablero[][] = new int[filasTablero][filasTablero];

    public static void main(String[] args) {

        hacerTablero(filasTablero);

    }

    private static void hacerTablero(int n) {

        int cont = 0;

        for (int col = 0; col < n; col++) {

            for (int fila = 0; fila < n; fila++) {

                tablero[col][fila] = cont;
                cont++;
                System.out.printf("%d   ", tablero[col][fila]);

            }

            System.out.printf("\n");

        }

    }
}
