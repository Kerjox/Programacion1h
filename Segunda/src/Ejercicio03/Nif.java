package Ejercicio03;

public class Nif {

	private static final char[] lettres = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
	private final int dni;
	private char letter;

	public Nif(int dni, char letter) {

		this.dni = dni;
		this.letter = letter;
	}

	public Nif(int dni) {

		this.dni = dni;
	}

	public void check() {

		try {

			if (lettres[this.dni % 23] == this.letter) {

				System.out.println("La letra es correcta");

			} else {

				System.out.println("La letra es incorrecta");

			}

		} catch (ArithmeticException a) {

			System.out.println("No se puede dividir por 0");
		}

	}

	public void check(char l) {

		try {

			if (lettres[this.dni % 23] == l) {

				System.out.println("La letra es correcta");

			} else {

				System.out.println("La letra es incorrecta");

			}

		} catch (ArithmeticException a) {

			System.out.println("No se puede dividir por 0");
		}

	}

	public void printNif() {

		System.out.printf("%d%c \n", this.dni, this.letter);
	}

	public void calculateLetter() {

		System.out.printf("La letra del dni: %d es %c \n", this.dni, lettres[this.dni % 23]);

	}


}
