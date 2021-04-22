package BlackJack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JApplet {

	public static final Integer HEIGHT = 600;
	public static final Integer WIDTH = 800;
	private Rectangle apostarMas;
	private Rectangle apostarMenos;
	private Integer apuestaValue;
	private Deck deck;
	private float dinero;
	private Rectangle pasa;
	private Rectangle reset;
	private Rectangle siguiente;

	@Override
	public void init() {

		resize(WIDTH, HEIGHT);
		this.apuestaValue = 0;
		this.dinero = 1000;
		this.siguiente = new Rectangle(20, 20, 20, 20);
		this.pasa = new Rectangle(45, 20, 20, 20);
		this.apostarMas = new Rectangle(80, 20, 30, 20);
		this.apostarMenos = new Rectangle(80, 45, 30, 20);
		this.reset = new Rectangle(250, 20, 60, 40);
		initListeners();
	}

	@Override
	public void paint(Graphics g) {

		g.setColor(new Color(0, 31, 6));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		paintBotonesApuestas(g);
		paintBotonesDinero(g);
		paintCards(g);
		paintApuesta(g);
		paintDinero(g);
		paintReset(g);
	}

	private void paintCards(Graphics g) {

		if (this.deck != null) {

			this.deck.paintPlayerCards(g);
			this.deck.paintCPUCards(g);
		}
	}

	private void initListeners() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				Point p = e.getPoint();

				if (siguiente.contains(p)) {

					System.out.println("Dar otra carta");
					deck.darCarta();
				} else if (pasa.contains(p)) {

					System.out.println("Se planta");
					checkProfit(deck.sePlanta());
				} else if (apostarMas.contains(p)) {

					apuestaValue += 5;
				} else if (apostarMenos.contains(p)) {

					if (apuestaValue > 0) {

						apuestaValue -= 5;
					}
				} else if (reset.contains(p)) {

					deck = new Deck();
				}

				repaint();
			}

			private void checkProfit(int value) {

				switch (value) {

					case 0:
						dinero -= apuestaValue;
						break;

					case 1:

						dinero += apuestaValue;
						break;

					case 2:

						// No hacer nada por empate
						break;

					case 3:

						dinero += apuestaValue * 1.5;
						break;
				}
			}
		});
	}

	private void paintReset(Graphics g) {

		g.setColor(Color.CYAN);
		g.fillRect(this.reset.x, this.reset.y, this.reset.width, this.reset.height);
		g.setColor(Color.BLACK);
		g.drawString("Reset", this.reset.x + 15, this.reset.y + 25);
	}

	private void paintDinero(Graphics g) {

		g.setColor(this.dinero > 0 ? Color.GREEN : Color.RED);
		g.drawString(this.dinero + "€", 160, 35);
	}

	private void paintApuesta(Graphics g) {

		g.setColor(Color.WHITE);
		g.drawString(this.apuestaValue.toString() + "€", 160, 20);
	}

	private void paintBotonesApuestas(Graphics g) {

		g.setColor(Color.GREEN);
		g.fillRect(this.siguiente.x, this.siguiente.y, this.siguiente.width, this.siguiente.height);
		g.setColor(Color.RED);
		g.fillRect(this.pasa.x, this.pasa.y, this.pasa.width, this.pasa.height);
	}

	private void paintBotonesDinero(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillRect(this.apostarMas.x, this.apostarMas.y, this.apostarMas.width, this.apostarMas.height);
		g.fillRect(this.apostarMenos.x, this.apostarMenos.y, this.apostarMenos.width, this.apostarMenos.height);
		g.setColor(Color.WHITE);
		g.drawString("+", this.apostarMas.x + 12, this.apostarMas.y + 14);
		g.drawString("-", this.apostarMenos.x + 12, this.apostarMenos.y + 14);

	}

}
