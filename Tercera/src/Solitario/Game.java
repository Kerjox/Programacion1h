package Solitario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JApplet {

	public static final int WIDTH = 900;
	public static final int HEIGHT = 1000;
	private DeckOfCards deckOfCards;
	private Rectangle getNewCard;
	private Image image;
	private Graphics renderBuffer;
	private Point p;

	@Override
	public void init() {

		resize(WIDTH, HEIGHT);

		this.image = this.createImage(WIDTH, HEIGHT);
		this.renderBuffer = this.image.getGraphics();
		this.deckOfCards = new DeckOfCards();
		this.getNewCard = new Rectangle(0, 0, 100, 150);
		this.p = new Point();
		initListeners();
	}

	@Override
	public void paint(Graphics g) {

		this.renderBuffer.setColor(new Color(0, 31, 6));
		this.renderBuffer.fillRect(0, 0, WIDTH, HEIGHT);
		this.deckOfCards.paintCardsInGame(this.renderBuffer);
		this.deckOfCards.paintDeck(this.renderBuffer);
		this.deckOfCards.paintCardFromDeck(this.renderBuffer);
		deckOfCards.animateMovement(this.p, renderBuffer);
		this.deckOfCards.paintFinishList(this.renderBuffer);
		g.drawImage(this.image, 0, 0, this);
	}

	private void initListeners() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				if (getNewCard.contains(e.getPoint())) {

					deckOfCards.nextCardInDeck();
					repaint();
				}else if ((e.getX() > 180 && e.getX() < 280) && (e.getY() > 0 && e.getY() < 150)) {

					deckOfCards.loadCardFromDeck();
				} else {

					p = e.getPoint();
					deckOfCards.loadCardPressed(e.getPoint());
					repaint();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {

				deckOfCards.unloadCardPressed();
				repaint();
			}
		});

		addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {

				p = e.getPoint();
				repaint();
			}
		});
	}

}
