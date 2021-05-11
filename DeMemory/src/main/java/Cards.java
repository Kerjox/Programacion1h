import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards {

	private final Image backImage;
	private final int timeToFlip = 1000;
	private List<Card> cards;
	private List<Card> cardsSelected;
	private int contTimeToFlip = 0;
	private boolean correct;

	public Cards() {

		this.cards = new ArrayList<>();
		this.cardsSelected = new ArrayList<>();
		this.backImage = getBackImage();
		this.cards = getCards();
		Collections.shuffle(this.cards);
	}

	public boolean isCorrect() {

		return correct;
	}

	public void setCorrect(boolean correct) {

		this.correct = correct;
	}

	public int getTimeToFlip() {

		return timeToFlip;
	}

	public void setContTimeToFlip(int contTimeToFlip) {

		this.contTimeToFlip = contTimeToFlip;
	}

	public void setCardsSelected(List<Card> cardsSelected) {

		this.cardsSelected = cardsSelected;
	}

	protected Image getBackImage() {

		try {
			return ImageIO.read(Cards.class.getClassLoader().getResource("images/reverso.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected List<Card> getCards() {

		List<Card> cards = new ArrayList<>();

		for (int i = 0; i < 8; i++) {

			cards.add(new Card(i + 1, i, this.backImage));
			cards.add(new Card(i + 1, i, this.backImage));
		}

		return cards;
	}

	public void setCards(List<Card> cards) {

		this.cards = cards;
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

			areAllCardsSelected();
		}
	}

	protected void areAllCardsSelected() {

		if (this.cardsSelected.size() == 2) {

			this.correct = isSameColor(this.cardsSelected.get(0), this.cardsSelected.get(1));
			this.contTimeToFlip = 0;
		}
	}

	protected boolean isSameColor(Card card, Card card1) {

		return card.getColor().equals(card1.getColor());
	}

	public void flipIncorrectCards() {

		if (this.cardsSelected.size() == 2) {

			if (this.correct) {

				this.cardsSelected.clear();

			} else if (this.contTimeToFlip >= this.timeToFlip) {

				flipSelectedCards();
				this.cardsSelected.clear();
			}

			this.contTimeToFlip += 10;
		}
	}

	protected void flipSelectedCards() {

		for (Card card : this.cardsSelected) {

			card.setReversed(true);
		}
	}

}
