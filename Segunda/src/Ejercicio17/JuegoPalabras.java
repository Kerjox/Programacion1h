package Ejercicio17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class JuegoPalabras extends JApplet implements Runnable {

	private final String[] palabrasString = {"En", "un", "lugar", "de", "la", "mancha"};
	public static int BGWIDTH = 600;
	public static int BGHEIGHT = 400;
	private Thread game;
	private Image image;
	private Graphics renderBuffer;
	private List<Palabra> palabras;

	@Override
	public void run() {

		do {

			movePalabras();
			repaint();
			delay(50);
		}while(true);
	}

	private void movePalabras() {

		for (Palabra palabra : palabras) {

			if (palabra.moverPalabra()) {
				game.stop();
			}
		}
	}

	@Override
	public void start() {

		this.game = new Thread(this);
		this.game.start();
	}

	@Override
	public void init() {

		this.image = this.createImage(BGWIDTH, BGHEIGHT);
		renderBuffer = image.getGraphics();
		initPalabras();

	}

	private void initPalabras() {

		palabras = new ArrayList<>();

		for (String word : palabrasString) {

			palabras.add(new Palabra(word));
		}

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				Palabra word = palabras.get(0);
				if (word.contains(e.getX(), e.getY())) {

					if (word.clicked()) palabras.remove(word);
				}
			}
		});
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		renderBuffer.setColor(Color.BLACK);
		renderBuffer.fillRect(0, 0, BGWIDTH, BGHEIGHT);
		drawWords();
		g.drawImage(image, 0, 0, this);

	}

	private void drawWords() {

		for (Palabra palabra : palabras) {

			palabra.paint(renderBuffer);
		}
	}

}
