package DeMemory;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards {

	private List<Card> cards;
	private Image backImage;
	private List<Card> cardsSelected;
	private boolean correct;
	private final int timeToFlip = 1000;
	private int contTimeToflip = 0;

	public Cards() {

		this.cards = new ArrayList<>();
		this.cardsSelected = new ArrayList<>();
		this.backImage = getBackImage();
		initCards();
	}

	private Image getBackImage() {

		try {
			return ImageIO.read(getClass().getResource("./images/reverso.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void initCards() {

		for (int i = 0; i < 8; i++) {

			this.cards.add(new Card(i + 1, i, this.backImage));
			this.cards.add(new Card(i + 1, i, this.backImage));
		}

		Collections.shuffle(this.cards);
	}

	public void paint(Graphics g) {

		for (int i = 0, x = 20; i < 4; i++, x += 100) {

			for (int j = 0, y = 20; j < 4; j++, y += 100) {

				this.cards.get(i * 4 + j).paint(g, x, y);
			}
		}
	}

	public void cardClicked(Point point) {

		if (this.cardsSelected.size() != 2) {

			for (Card card : this.cards) {

				if (card.isReversed() && card.contains(point)) {

					this.cardsSelected.add(card);
					card.setReversed(false);
				}
			}

			if (this.cardsSelected.size() == 2) {

				this.correct = isSameColor(this.cardsSelected.get(0), this.cardsSelected.get(1));
				this.contTimeToflip = 0;
			}
		}
	}

	private boolean isSameColor(Card card, Card card1) {

		return card.getColor().equals(card1.getColor());
	}

	public void flipIncorrectCards() {

		if (this.cardsSelected.size() == 2) {

			if (this.correct) {

				this.cardsSelected.clear();

			} else if (this.contTimeToflip >= this.timeToFlip){

				flipSelectedCards();
				this.cardsSelected.clear();
			}

			this.contTimeToflip += 10;
		}
	}

	private void flipSelectedCards() {

		for (Card card : this.cardsSelected) {

			card.setReversed(true);
		}
	}

}
