package Ejercicio03_Exceptions;

public class Nif {

	private static final char[] lettres = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
	private final int dni;
	private final char letter;

	public Nif(int dni, char letter) {

		this.dni = dni;
		this.letter = letter;
	}

	public Nif(int dni) {

		this.dni = dni;
		this.letter = lettres[dni % 23];
	}

	public void check() throws NifException{

		try {

			if (lettres[this.dni % 23] == this.letter) {

				System.out.printf("La letra %c es correcta \n", this.letter);

			} else {

				System.out.printf("La letra %c es incorrecta \n", this.letter);
				throw new NifException("La letra " + this.letter + " no es correcta");
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
