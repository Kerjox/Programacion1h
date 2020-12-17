package Ejercicio03_Exceptions;

public class EjecutableNif {

	public static void main(String[] args) throws NifException {

		Nif dni1 = new Nif(44444444, 'B');          // Meter una letra incorrecta para lanzar la excepción
		Nif dni2 = new Nif(45678945);

		dni1.printNif();
		dni1.calculateLetter();
		dni1.check();

		System.out.println("---------------------------");

		dni2.printNif();
		dni2.calculateLetter();
		dni2.check();

	}

}
