package Ejercicio04;

import java.util.Arrays;

public class Bombo {

	private final int[] bolas;
	private final int numbersPerTicket;
	private final int tickets;
	private final int indexSacarBola;
	private final int totalNumbers;
	private int totalNumbers2;

	public Bombo(int a, int b) {

		this.tickets = a;
		this.numbersPerTicket = b;
		this.totalNumbers = a * b;
		this.bolas = new int[totalNumbers];
		this.indexSacarBola = 0;
		this.totalNumbers2 = totalNumbers;

		fillBolas();
		System.out.println(Arrays.toString(bolas));
		removeBolas();
		System.out.println(Arrays.toString(bolas));

	}

	public void setTotalNumbers2(int totalNumbers2) {

		this.totalNumbers2 = totalNumbers2;
	}

	private void removeBolas() {

		for (int i = 0; i < 10000; i++) {

			int index1 = (int) (Math.random() * totalNumbers);
			int index2 = (int) (Math.random() * totalNumbers);
			int aux = this.bolas[index1];
			this.bolas[index1] = this.bolas[index2];
			this.bolas[index2] = aux;

		}

	}

	private void fillBolas() {

		for (int i = 0; i < totalNumbers; i++) {

			this.bolas[i] = i;

		}

	}

	public void fillTickets(int[][] data) {

		for (int i = 0, index = 0; i < tickets; i++) {

			for (int j = 0; j < numbersPerTicket; j++) {

				data[i][j] = sacarBola();

			}

		}

	}

	public int sacarBola() {

		int indexAleatorio = (int) (Math.random() * totalNumbers2);
		int aleatorio = bolas[indexAleatorio];
		bolas[indexAleatorio] = bolas[totalNumbers2-- - 1];

		return aleatorio;

	}

}
