package BlackJack;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<List<Card>> cards;
	private Image back;

	public Deck() {

		this.back = getBackImage();
		loadCards();
		Collections.shuffle(cards.get(0));
		firstPlay();
	}

	private Image getBackImage() {

		try {
			return ImageIO.read(getClass().getResource("./Cartas/reverso.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Card getNextCard() {

		Card card = this.cards.get(0).get(0);
		this.cards.get(0).remove(card);
		return card;
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

	public void paintPlayerCards(Graphics g) {

		for (int i = 0; i < cards.get(1).size(); i++) {

			cards.get(1).get(i).paint(g, 25 * i + 20, 380);
		}
	}

	public void paintCPUCards(Graphics g) {

		for (int i = 0; i < this.cards.get(2).size(); i++) {

			if (this.cards.get(2).get(i).isVisible()) {

				this.cards.get(2).get(i).paint(g, 25 * i + 20, 100);
			} else {

				this.cards.get(2).get(i).paint(this.back, g, 25 * i + 20, 100);

			}
		}
	}

	public Integer getPlayerValue() {

		Integer value = 0;
		boolean hasAs = false;

		for (Card card : this.cards.get(1)) {

			Integer cardValue = card.getValue();
			if (cardValue != 1) {

				value += cardValue;
			} else {

				hasAs = true;
			}
		}

		if (hasAs) {

			if (value + 11 > 21) {

				value += 1;
			} else {

				value += 11;
			}
		}

		return value;
	}

	public Integer getCPUValue() {

		Integer value = 0;
		boolean hasAs = false;

		for (Card card : this.cards.get(2)) {

			Integer cardValue = card.getValue();
			if (cardValue != 1) {

				value += cardValue;
			} else {

				hasAs = true;
			}
		}

		if (hasAs) {

			if (value + 11 > 21) {

				value += 1;
			} else {

				value += 11;
			}
		}

		return value;
	}

	private void firstPlay() {

		this.cards.get(1).add(getNextCard());
		this.cards.get(1).add(getNextCard());
		this.cards.get(2).add(getNextCard());
		this.cards.get(2).add(getNextCard());
		this.cards.get(2).get(this.cards.get(2).size() - 1).setVisible(false);
	}

	public int sePlanta() {

		this.cards.get(2).get(this.cards.get(2).size() - 1).setVisible(true);

		Integer CPUValue = getCPUValue();
		Integer playerValue = getPlayerValue();


		while (CPUValue < 17) {

			this.cards.get(2).add(getNextCard());
			CPUValue = getCPUValue();
		}

		System.out.printf("%d : %d \n", CPUValue, playerValue);

		if (playerValue == 21 && CPUValue != 21 && this.cards.get(1).size() == 2) {

			System.out.println("Black Jack");
			return 3;
		}

		if (playerValue > 21) {

			System.out.println("Pierde");
			return 0;
		} else {

			if (CPUValue > 21) {

				System.out.println("Gana");
				return 1;
			} else {

				if (playerValue.equals(CPUValue)) {

					System.out.println("Empate");
					return 2;
				} else {

					if (playerValue > CPUValue) {

						System.out.println("Gana");
						return 1;
					} else {

						System.out.println("Pierde");
						return 0;
					}
				}
			}
		}
	}

	public void darCarta() {

		this.cards.get(1).add(getNextCard());

		if (getPlayerValue() > 21) {

			System.out.println("Pierde, se pasa de 21");
		}
	}

}
