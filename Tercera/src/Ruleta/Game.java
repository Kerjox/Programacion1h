package Ruleta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Game extends JApplet {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	private Image image;
	private Graphics renderBuffer;
	private Tablero tablero;
	private Integer cash = 1000;
	private byte number = 0;
	private Rectangle botonApostar;

	private ArrayList<Rectangle> fichasSacar;
	private ArrayList<Ficha> fichas;

	private Ficha fichaToMove = null;

	private ArrayList<Apuesta> apuestas;

	@Override
	public void init() {

		resize(WIDTH, HEIGHT);
		this.image = this.createImage(WIDTH, HEIGHT);
		this.renderBuffer = this.image.getGraphics();
		this.tablero = new Tablero();
		this.fichas = new ArrayList<>();
		this.apuestas = new ArrayList<>();
		this.botonApostar = new Rectangle(500, 10, 40, 40);

		initFichasTablero();
		initListeners();
	}

	@Override
	public void paint(Graphics g) {

		this.renderBuffer.setColor(Color.BLACK);
		this.renderBuffer.fillRect(0, 0, WIDTH, HEIGHT);
		this.tablero.paint(this.renderBuffer);
		this.renderBuffer.setColor(Color.RED);
		this.renderBuffer.fillRect(500, 10, 40, 40);
		this.renderBuffer.setColor(Color.WHITE);
		this.renderBuffer.drawString(String.valueOf(this.number), 60, 50);
		paintFichas(renderBuffer);
		showCash();

		g.drawImage(this.image, 0, 0, this);
	}

	private void showCash() {

		this.renderBuffer.setColor(this.cash > 0 ? Color.GREEN: Color.RED);
		this.renderBuffer.drawString(String.valueOf(this.cash), 10, 20);
	}

	private void initFichasTablero() {

		this.fichasSacar = new ArrayList<>();

		this.fichasSacar.add(new Rectangle(480, 383, 25, 25));
		this.fichasSacar.add(new Rectangle(515, 383, 25, 25));
		this.fichasSacar.add(new Rectangle(548, 383, 25, 25));
		this.fichasSacar.add(new Rectangle(580, 383, 25, 25));
		this.fichasSacar.add(new Rectangle(615, 383, 25, 25));
		this.fichasSacar.add(new Rectangle(647, 383, 25, 25));
	}

	private void initListeners() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				switch (e.getButton()) {

					case 1:

						leftClick(e);
						break;

					case 3:

						rightClick(e);
						break;
				}

				repaint();

			}

			private void rightClick(MouseEvent e) {

				fichas.removeIf(ficha -> ficha.contains(e.getPoint()));
			}

			private void leftClick(MouseEvent e) {

				if (botonApostar.contains(e.getPoint())) {

					for (Ficha ficha : fichas) {

						apuestas.clear();
						ArrayList<Casilla> casillasApostadas = tablero.getCasillasApostadas(ficha);
						apuestas.add(new Apuesta(ficha.getValue(), casillasApostadas));

						number = (byte) (Math.random() * 35 + 1);
						for (Apuesta apuesta : apuestas) {

							cash += apuesta.getProfit(number);
						}
					}
				}

				sacarFicha(e);
				loadFicha(e);
			}

			private void loadFicha(MouseEvent e) {

				if (fichas.size() > 0) {

					for (Ficha ficha : fichas) {

						if (ficha.contains(e.getPoint())) {

							fichaToMove = ficha;
						}
					}
				}
			}

			private void sacarFicha(MouseEvent e) {

				for (Rectangle ficha : fichasSacar) {

					if (ficha.contains(e.getPoint())) {

						//System.out.println(fichasSacar.indexOf(ficha));
						fichas.add(new Ficha(fichasSacar.indexOf(ficha), e.getPoint()));
						repaint();
					}
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {

				fichaToMove = null;
			}
		});

		addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {

				if (fichaToMove != null) {

					fichaToMove.move(e.getPoint());
					repaint();
				}
			}
		});
	}

	private void paintFichas(Graphics renderBuffer) {

		if (this.fichas.size() > 0) {

			for (Ficha ficha : this.fichas) {

				ficha.paint(renderBuffer);
			}
		}
	}

}
