package Ejercicio14_Pelota.Juego1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Juego_Pelota extends JApplet implements Runnable {

	private final int bgHeight = 900;
	private final int bgWidth = 1600;
	private final int numberPelotas = 100;
	private final Random r = new Random();
	private Thread animacion;
	private Image image;
	private final List<Pelota> pelotas = new ArrayList<>();
	private Graphics renderBuffer;

	@Override
	public void run() {

		do {

			moverPeloas();
			repaint();
			delay(10);

		} while (true);

	}

	private void moverPeloas() {

		for (int i = 0; i < pelotas.size(); i++) {

			pelotas.get(i).mover();
		}
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
		renderBuffer.fillRect(0, 0, bgWidth, bgHeight);
		pintarPelotas();

		g.drawImage(image, 0, 0, this);
	}

	private void pintarPelotas() {

		for (int i = 0; i < pelotas.size(); i++) {

			pelotas.get(i).pintarPelota(renderBuffer);
		}
	}


	@Override
	public void update(Graphics g) {

		paint(g);
	}

	@Override
	public void init() {

		this.setSize(new Dimension(bgWidth, bgHeight));
		image = this.createImage(bgWidth, bgHeight);
		renderBuffer = image.getGraphics();
		initPelotas(numberPelotas);
	}

	@Override
	public void start() {

		animacion = new Thread(this);
		animacion.start();
	}

	private void initPelotas(int number) {

		for (int i = 0; i < number; i++) {

			pelotas.add(new Pelota(bgWidth, bgHeight));
		}
	}

}
