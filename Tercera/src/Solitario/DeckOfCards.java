package Solitario;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class DeckOfCards {

	private final ArrayList<Card> cardsInMovement;
	private Image backImage;
	private Card cardPressed;
	private Card cardToMoveFromDeck;
	private ArrayList<Card> cards;
	private ArrayList<Card> cardsInDeck;
	private ArrayList<ArrayList<Card>> cardsInGame;
	private Rectangle finish;
	private ArrayList<Card>[] finishList;
	private ArrayList<Rectangle> firstRectanglesCards;
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
		initFirstRectanglesCards();
		initFinish();
	}

	private void initFinish() {

		this.finishList = new ArrayList[4];
		for (int i = 0; i < 4; i++) {

			this.finishList[i] = new ArrayList<>();
		}
		this.finish = new Rectangle(500, 0, 400, 150);

	}

	private void loadBackImage() {

		try {
			this.backImage = ImageIO.read(getClass().getResource("./cards/back.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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

		for (int i = 1; i <= 13; i++) {

			this.cards.add(new Card(i, Card.TREBOLES, this.backImage));
		}

		for (int i = 1; i <= 13; i++) {

			this.cards.add(new Card(i, Card.ROMBOS, this.backImage));
		}

		for (int i = 1; i <= 13; i++) {

			this.cards.add(new Card(i, Card.COREZONES, this.backImage));
		}

		for (int i = 1; i <= 13; i++) {

			this.cards.add(new Card(i, Card.PICAS, this.backImage));
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

	private void initFirstRectanglesCards() {

		this.firstRectanglesCards = new ArrayList<>();

		for (int i = 0; i < this.cardsInGame.size(); i++) {

			this.firstRectanglesCards.add(new Rectangle(110 * i, 30 * i + 200, 100, 150));
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

		if (this.cardToMoveFromDeck != null) {

			this.cardToMoveFromDeck.paint(g, (int) p.getX() - 45, (int) p.getY());
			return;
		}

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

					//System.out.printf("%d : %d \n", i, j);
					this.cardPressed = this.cardsInGame.get(i).get(j);
					loadCardsInMovement(i, j);

					this.indexDeckCardsInMovement = i;
					break;
				}
			}
		}
	}

	public void paintFinishList(Graphics g) {

		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < this.finishList[i].size(); j++) {

				this.finishList[i].get(j).paint(g, 500 + (150 * i), 0);
			}
		}
	}

	public void unloadCardPressed() {

		if (this.cardPressed == null) return;

		this.cardPressed = null;

		int destinationList = getDestinationList(this.cardsInMovement.get(0));

		if (destinationList >= 0 && canMove(destinationList)) {

			moveCards(destinationList);
		} else {

			for (Card card : this.cardsInMovement) {

				this.cardsInGame.get(this.indexDeckCardsInMovement).add(card);
			}
		}

		this.cardsInMovement.clear();
	}

	private boolean canMove(int destinationList) {

		Card card = this.cardsInGame.get(destinationList).get(this.cardsInGame.get(destinationList).size() - 1);
		Card cardIncoming = this.cardsInMovement.get(0);

		return card.getColor() != cardIncoming.getColor() && card.getIndex() - 1 == cardIncoming.getIndex();
	}

	private int getDestinationList(Card c) {

		for (int i = 0; i < this.cardsInGame.size(); i++) {

			for (Card card : this.cardsInGame.get(i)) {

				if (card.intersects(c)) {

					return i;
				}
			}
		}

		System.out.println(c.getIndex());
		if (c.getIndex() == 13) {

			return checkEmptyLists(c);
		}

		return - 1;
	}

	private int checkEmptyLists(Card c) {

		for (int i = 0; i < this.cardsInGame.size(); i++) {

			if (this.cardsInGame.get(i).size() == 0 && this.firstRectanglesCards.get(i).intersects(c)) {

				return i;
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

	public void loadCardFromDeck() {

		this.cardToMoveFromDeck = this.cardsInDeck.get(this.indexDeck);
	}

}
