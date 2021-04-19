package BlackJack;

import java.util.ArrayList;
import java.util.List;

public class Deck {

	private List<List<Card>> cards;
	private Integer index;

	public Deck() {

		this.index = 0;
		loadCards();
		System.out.println("");
		shakeCards();

	}

	/*
	for (int i = 0; i < cards.get(0).size(); i++) {

			System.out.printf("%d, ", cards.get(0).get(i).getValue());
		}
	 */

	public void getNextCard() {

		Card card = this.cards.get(0).get(this.index);
		this.index++;
	}

	private void loadCards() {

		this.cards = new ArrayList<>();

		for (int i = 0; i < 3; i++) {

			this.cards.add(new ArrayList<>());
		}

		for (int i = 1; i <= 12; i++) {

			cards.get(0).add(new Card(i, "clubs"));
			cards.get(0).add(new Card(i, "diamonds"));
			cards.get(0).add(new Card(i, "hearts"));
			cards.get(0).add(new Card(i, "spades"));
		}
	}

	private void shakeCards() {

		int size = this.cards.get(0).size();

		for (int i = 0; i < 1000; i++) {

			int card1 = (int) (Math.random() * size);
			int card2 = (int) (Math.random() * size);
			Card card = this.cards.get(0).get(card1);
			this.cards.get(0).set(card1, this.cards.get(0).get(card2));
			this.cards.get(0).set(card2, card);
		}
	}

}
