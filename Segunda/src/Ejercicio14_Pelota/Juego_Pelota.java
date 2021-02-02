package Ejercicio14_Pelota;

import javax.swing.*;
import java.awt.*;

public class Juego_Pelota extends JApplet implements Runnable {

	private Thread animacion;
	private Image image;
	private Pelota pelota;
	private Graphics renderBuffer;

	@Override
	public void run() {

		do {

			pelota.mover();
			repaint();
			delay(20);

		} while (true);

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
		renderBuffer.fillRect(0, 0, 300, 300);
		pelota.pintarPelota(renderBuffer);
		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void update(Graphics g) {

		paint(g);
	}

	@Override
	public void init() {

		image = this.createImage(300, 300);
		renderBuffer = image.getGraphics();
		pelota = new Pelota(10, Color.RED);
	}

	@Override
	public void start() {

		animacion = new Thread(this);
		animacion.start();
	}

}
