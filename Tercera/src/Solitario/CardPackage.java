package Solitario;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class CardPackage {

	private ArrayList<Card> cards;
	private ArrayList<ArrayList<Card>> p;
	private Image backImage;

	public CardPackage() {

		loadBackImage();
		loadCards();
	}

	public ArrayList<ArrayList<Card>> getP() {

		return p;
	}

	public Card getCardClicked(Point p) {

		return null;
	}

	private void loadCards() {

		cards = new ArrayList<>();
		p = new ArrayList<>();

		for (int i = 1; i <= 52; i++) {

			cards.add(new Card(i));
		}

		for (int i = 0; i < 7; i++) {

			p.add(new ArrayList<Card>());
		}

		int index = 0;
		for (int i = 0; i < 7; i++) {

			for (int j = 0; j <= i; j++) {

				this.p.get(i).add(cards.get(index));
				System.out.printf("%d, %d \n", i, j);
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

}
