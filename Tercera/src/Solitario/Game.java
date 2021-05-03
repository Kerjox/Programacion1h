package Solitario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JApplet {

	public static final int WIDTH = 900;
	public static final int HEIGHT = 1000;
	private Deck deck;
	private Rectangle getNewCard;
	private Image image;
	private Graphics renderBuffer;
	private Point p;

	@Override
	public void init() {

		resize(WIDTH, HEIGHT);

		this.image = this.createImage(WIDTH, HEIGHT);
		this.renderBuffer = this.image.getGraphics();
		this.deck = new Deck();
		this.getNewCard = new Rectangle(0, 0, 100, 150);
		this.p = new Point();
		initListeners();
	}

	@Override
	public void paint(Graphics g) {

		this.renderBuffer.setColor(new Color(0, 31, 6));
		this.renderBuffer.fillRect(0, 0, WIDTH, HEIGHT);
		this.renderBuffer.setColor(Color.red);
		this.renderBuffer.drawRect(400, 0, 450, 150);
		this.deck.paintCardsInGame(this.renderBuffer);
		this.deck.paintDeck(this.renderBuffer);
		this.deck.paintCardFromDeck(this.renderBuffer);
		this.deck.paintFinishList(this.renderBuffer);
		this.deck.animateMovement(this.p, renderBuffer);
		g.drawImage(this.image, 0, 0, this);
	}

	private void initListeners() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				if (getNewCard.contains(e.getPoint())) {

					deck.nextCardInDeck();
					repaint();
				}else if ((e.getX() > 180 && e.getX() < 280) && (e.getY() > 0 && e.getY() < 150)) {

					deck.loadCardFromDeck();
				} else {

					p = e.getPoint();
					deck.loadCardPressed(e.getPoint());
					repaint();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {

				deck.unloadCardPressed();
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
