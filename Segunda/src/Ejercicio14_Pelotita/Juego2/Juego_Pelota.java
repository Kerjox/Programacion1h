package Ejercicio14_Pelotita.Juego2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Juego_Pelota extends JApplet implements Runnable {

	private static final int NUMEROPELOTAS = 100;
	private final int bgHeight = 900;
	private final int bgWidth = 1600;
	private final List<Pelota> pelotas = new ArrayList<>();
	private final Random r = new Random();
	private Thread animacion;
	private Image image;
	private Graphics renderBuffer;

	@Override
	public void init() {

		this.setSize(new Dimension(bgWidth, bgHeight));
		image = this.createImage(bgWidth, bgHeight);
		renderBuffer = image.getGraphics();
		initPelotas(NUMEROPELOTAS);
		eventMousePressed();
	}

	@Override
	public void paint(Graphics g) {

		renderBuffer.setColor(Color.BLACK);
		renderBuffer.fillRect(0, 0, bgWidth, bgHeight);
		pintarPelotas();

		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void run() {

		do {

			moverPeloas();
			repaint();
			delay(10);

		} while (true);

	}

	@Override
	public void start() {

		animacion = new Thread(this);
		animacion.start();
	}

	@Override
	public void update(Graphics g) {

		paint(g);
	}

	private void moverPeloas() {

		for (Pelota pelota : pelotas) {

			pelota.mover();
		}
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void pintarPelotas() {

		for (Pelota pelota : pelotas) {

			pelota.pintarPelota(renderBuffer);
		}
	}

	private void eventMousePressed() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				pelotas.removeIf(pelota -> pelota.contains(e.getPoint()));

			}
		});
	}

	private void initPelotas(int number) {

		for (int i = 0; i < number; i++) {

			pelotas.add(new Pelota(bgWidth, bgHeight));
		}
	}

}
