package Solitario;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class DeckOfCards {

	private final ArrayList<Card> cardsInMovement;
	private Image backImage;
	private Card cardPressed;
	private ArrayList<Card> cards;
	private ArrayList<Card> cardsInDeck;
	private ArrayList<ArrayList<Card>> cardsInGame;
	private int indexDeck;
	private int indexDeckCardsInMovement;

	public DeckOfCards() {

		this.indexDeck = 0;
		this.cardsInMovement = new ArrayList<>();

		loadBackImage();
		initCards();
		shakeCards();
		initSevenArrays();
		initCardsInDeck();
	}

	private void initCardsInDeck() {

		this.cardsInDeck = new ArrayList<>();

		for (int i = 28; i < 52; i++) {

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

	private void initCards() {

		this.cards = new ArrayList<>();

		for (int i = 1; i <= 52; i++) {

			this.cards.add(new Card(i, this.backImage));
		}
	}

	private void initSevenArrays() {

		this.cardsInGame = new ArrayList<>();

		for (int i = 0; i < 7; i++) {

			this.cardsInGame.add(new ArrayList<>());
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

	public void moveCards(int toList) {

		for (Card card : this.cardsInMovement) {

			this.cardsInGame.get(toList).add(card);
		}
	}

	public void animateMovement(Point p, Graphics g) {

		if (this.cardsInMovement.size() == 0) return;

		for (int i = 0; i < this.cardsInMovement.size(); i++) {

			this.cardsInMovement.get(i).paint(g, (int) p.getX() - 45, (int) p.getY() + (30 * i));
		}
	}


	public void loadCardPressed(Point p) {

		for (int i = 0; i < this.cardsInGame.size(); i++) {

			if (this.cardPressed != null) break;

			for (int j = this.cardsInGame.get(i).size() - 1; j >= 0; j--) {

				if (! this.cardsInGame.get(i).get(j).isHidden() && this.cardsInGame.get(i).get(j).contains(p)) {

					System.out.printf("%d : %d \n", i, j);
					this.cardPressed = this.cardsInGame.get(i).get(j);
					loadCardsInMovement(i, j);

					this.indexDeckCardsInMovement = i;
					break;
				}
			}
		}
	}

	public void unloadCardPressed() {

		this.cardPressed = null;

		int destinationList = getDestinationList();

		if (destinationList < 0) {

			for (Card card : this.cardsInMovement) {

				this.cardsInGame.get(this.indexDeckCardsInMovement).add(card);
			}
		} else if (canMove()) {

			moveCards(destinationList);
		}

		this.cardsInMovement.clear();
	}

	private boolean canMove() {

		return true;
	}

	private int getDestinationList() {

		for (int i = 0; i < this.cardsInGame.size(); i++) {

			for (Card card : this.cardsInGame.get(i)) {

				if (card.intersects(this.cardsInMovement.get(0)) && i != this.indexDeckCardsInMovement) {

					return i;
				}
			}
		}

		return - 1;
	}

	public void paintCardsInGame(Graphics g) {

		//if (this.cardPressed != null) return;

		for (int i = 0; i < this.cardsInGame.size(); i++) {

			int sizeList = this.cardsInGame.get(i).size();

			for (int j = 0; j < sizeList; j++) {

				Card card = this.cardsInGame.get(i).get(j);

				if (card.isHidden() && j == sizeList - 1 && this.cardPressed == null) {

					card.setHidden(false);
				}
				card.paint(g, 110 * i, 30 * j + 200);
			}
		}
	}

	private void loadCardsInMovement(int i, int j) {

		int size = this.cardsInGame.get(i).size();

		for (int u = j; u < size; u++) {

			this.cardsInMovement.add(this.cardsInGame.get(i).get(u));
		}

		for (int u = j; u < size; u++) {

			this.cardsInGame.get(i).remove(j);
		}
	}

	public void prueba() {

		System.out.println("Prueba");
		for (ArrayList<Card> cards : this.cardsInGame) {

			for (Card card : cards) {

				System.out.println(card);
			}
		}

	}

}
