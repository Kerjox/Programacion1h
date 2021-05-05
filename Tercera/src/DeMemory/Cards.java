package DeMemory;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Cards {

	private List<Card> cards;

	public Cards() {

		this.cards = new ArrayList<>();
		initCards();
	}

	private void initCards() {

		for (int i = 0; i < 16; i++) {

			this.cards.add(new Card(i + 1, i));
			this.cards.add(new Card(i + 1, i));
		}

	}

	public void paint(Graphics g) {

		g.setColor(Color.red);
		for (int i = 0; i < 8; i++) {

			g.fillRect(i != 0 ? (i) * 100 : 5, 100, 80 ,80);
		}

		for (int i = 0; i < 8; i++) {

			g.fillRect(i != 0 ? (i) * 100 : 5, 300 , 80 ,80);
		}
	}

}
