package Solitario;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class DeckOfCards {

	private Image backImage;
	private ArrayList<Card> cards;
	private ArrayList<Card> cardsInDeck;
	private ArrayList<ArrayList<Card>> cardsInGame;

	private int indexDeck;

	public DeckOfCards() {

		this.indexDeck = 0;

		loadBackImage();
		initCards();
		shakeCards();
		initSevenArrays();
		initCardsInDeck();
	}

	private void initCardsInDeck() {

		this.cardsInDeck = new ArrayList<>();

		for (int i = 27; i < 52; i++) {

			this.cardsInDeck.add(this.cards.get(i));
		}
	}

	private void shakeCards() {

		int size = this.cards.size();

		for (int i = 0; i < 1000; i++) {

			int card1 = (int) (Math.random() * size);
			int card2 = (int) (Math.random() * size);
			Card card = this.cards.get(card1);
			this.cards.set(card1, this.cards.get(card2));
			this.cards.set(card2, card);
		}
	}

	public ArrayList<ArrayList<Card>> getCardsInGame() {

		return cardsInGame;
	}

	private void initCards() {

		this.cards = new ArrayList<>();

		for (int i = 1; i <= 52; i++) {

			this.cards.add(new Card(i, this.backImage));
		}
	}

	private void initSevenArrays() {

		this.cardsInGame = new ArrayList<>();

		for (int i = 0; i < 7; i++) {

			this.cardsInGame.add(new ArrayList<Card>());
		}

		int index = 0;
		for (int i = 0; i < 7; i++) {

			for (int j = 0; j <= i; j++) {

				if (i != j) {

					this.cards.get(index).setHidden(true);
				}
				this.cardsInGame.get(i).add(cards.get(index));
				//System.out.printf("%d, %d \n", i, j);
				index++;
			}
		}
	}

	private void loadBackImage() {

		try {
			this.backImage = ImageIO.read(getClass().getResource("./cards/back.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintDeck(Graphics g) {

		if (this.cardsInDeck.size() > 0 && this.indexDeck != this.cardsInDeck.size() - 1) {

			g.drawImage(this.backImage, 0, 0, 100, 150, null);
		}
	}

	public void paintCardFromDeck(Graphics g) {

		this.cardsInDeck.get(this.indexDeck).paint(g, 180, 0);
	}

	public void nextCardInDeck() {

		if (this.indexDeck == this.cardsInDeck.size() - 1) {

			this.indexDeck = 0;
		} else this.indexDeck++;
	}

	public void moveCards(int indexList, int fromIndex, int toList) {

		cardsInGame.get(1).get(0).setHidden(false);

		int p = cardsInGame.get(indexList).size() - fromIndex;

		for (int i = fromIndex; i < p; i++) {

			System.out.println("Mover");

			cardsInGame.get(toList).add(cardsInGame.get(indexList).get(i));
		}
		for (int i = fromIndex; i < p; i++) {

			cardsInGame.get(indexList).remove(fromIndex);
		}
	}



}
