package Solitario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Game extends JApplet {

	public static final int HEIGHT = 700;
	public static final int WIDTH = 900;
	private DeckOfCards deckOfCards;
	private Rectangle getNewCard;
	private Image image;
	private Graphics renderBuffer;

	@Override
	public void init() {

		resize(WIDTH, HEIGHT);

		this.image = this.createImage(WIDTH, HEIGHT);
		this.renderBuffer = this.image.getGraphics();
		this.deckOfCards = new DeckOfCards();
		this.getNewCard = new Rectangle(0, 0, 100, 150);
		initListeners();
	}

	@Override
	public void paint(Graphics g) {

		this.renderBuffer.setColor(new Color(0, 31, 6));
		this.renderBuffer.fillRect(0, 0, WIDTH, HEIGHT);
		paintCardsInGame(this.renderBuffer);
		this.deckOfCards.paintDeck(this.renderBuffer);
		this.deckOfCards.paintCardFromDeck(this.renderBuffer);
		g.drawImage(this.image, 0, 0, this);
	}

	private void initListeners() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				if (getNewCard.contains(e.getPoint())) {

					//System.out.println("Sacar carta");
					deckOfCards.nextCardInDeck();
					repaint();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {


			}
		});

		addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {


				repaint();
			}
		});
	}

	private void paintCardsInGame(Graphics g) {

		ArrayList<ArrayList<Card>> cardsInGame = this.deckOfCards.getCardsInGame();

		for (int i = 0; i < cardsInGame.size(); i++) {

			for (int j = 0; j < cardsInGame.get(i).size(); j++) {

				cardsInGame.get(i).get(j).paint(this.renderBuffer, 110 * i, 30 * j + 200);
			}
		}
	}

}
