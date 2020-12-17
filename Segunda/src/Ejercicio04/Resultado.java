package Ejercicio04;

import java.util.Arrays;

public class Resultado {

	private static int[][] resultado;
	private static final int tickets = 6;
	private static final int numbersPerTicket = 8;
	private static int indexSacarBolas = 0;
	private static final Bombo bombo1 = new Bombo(tickets, numbersPerTicket);

	public static void main(String[] args) {

		resultado = new int[tickets][numbersPerTicket];

		bombo1.fillTickets(resultado);

		System.out.println("--------------------------");

		printResultado();

		System.out.println("--------------------------");

		bombo1.setTotalNumbers2(tickets * numbersPerTicket);

		for (int i = 0; i < tickets * numbersPerTicket; i++) {

			sacarBolas(bombo1.sacarBola());
		}

	}

	private static void sacarBolas(int number) {

			System.out.printf("La bola %d es el número: %d \n", indexSacarBolas++, number);

	}

	private static void printResultado() {

		for (int i = 0; i < tickets; i++) {

			System.out.println(Arrays.toString(resultado[i]));

		}
	}

}
