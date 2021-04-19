package BlackJack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JApplet {

	private Deck deck;
	private Rectangle siguiente;
	private Rectangle pasa;

	@Override
	public void init() {

		resize(600, 400);
		this.deck = new Deck();
		this.siguiente = new Rectangle(20, 20, 20, 20);
		this.pasa = new Rectangle(45, 20, 20, 20);
		initListeners();
	}

	private void initListeners() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				if (siguiente.contains(e.getPoint())) {

					System.out.println("Dar otra carta");
				} else if (pasa.contains(e.getPoint())) {

					System.out.println("Pasar");
				}
			}
		});
	}

	@Override
	public void paint(Graphics g) {

		g.setColor(new Color(0, 31, 6));
		g.fillRect(0, 0, 800, 600);
		g.setColor(Color.RED);
		g.fillRect(this.siguiente.x, this.siguiente.y, this.siguiente.width, this.siguiente.height);
		g.setColor(Color.GREEN);
		g.fillRect(this.pasa.x, this.pasa.y, this.pasa.width, this.pasa.height);

	}

}
