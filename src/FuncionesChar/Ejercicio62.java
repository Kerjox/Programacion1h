/*
    Utilizando la función de la clase Character 'toUpperCase' para convertir minúsculas en mayúsculas
 */

package FuncionesChar;

public class Ejercicio62 {

    public static void main(String[] args) {

        System.out.println("Convertir los carácteres en mayúsculas \n");

        char[] frase;
        String sCharMod;
        char[] charMod;

        frase = new char[]{'H', 'o', 'l', 'a', ' ', 'a', 'l', 'c', 'a', 'c', 'h', 'o', 'f', 'a' , ' ', 'e', 's', 'c', 'a', 'c', 'h', 'u', 'f', 'l', 'á'};
        charMod = new char[frase.length];
        charMod = toUpperCase(frase);
        sCharMod = String.valueOf(charMod);

        System.out.println(sCharMod);

    }

    private static char[] toUpperCase(char[] data) {

        char[] charMod = new char[data.length];

        for (int i = 0; i < data.length; i++) {

            charMod[i] = Character.toUpperCase(data[i]);

        }

        return charMod;

    }

}
