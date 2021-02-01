package Ejercicio13_Mondrian;


import javax.swing.*;
import java.awt.*;

public class Mondrian extends JApplet implements Runnable {

	private static final int ARRIBA = 0;
	private static final int ABAJO = 1;
	private static final int IZQUIERDA = 2;
	private static final int DERECHA = 3;
	private int direcion;
	private Thread animation;
	private int posX = 50, posY = 140, width = 120, height = 45;
	private Image image;
	Graphics renderBuffer;

	@Override
	public void init() {

		super.init();
		direcion = Mondrian.DERECHA;
		image = this.createImage(300, 300);
		renderBuffer = image.getGraphics();
	}

	@Override
	public void start() {

		super.start();
		animation = new Thread(this);
		animation.start();
	}

	@Override
	public void paint(Graphics g) {

		renderBuffer.setColor(Color.WHITE);
		renderBuffer.fillRect(0, 0, 300, 300);
		renderBuffer.setColor(Color.YELLOW);
		renderBuffer.fillRect(0, 0, 90, 90);
		renderBuffer.fillRect(250, 0, 40, 190);
		renderBuffer.fillRect(80, 110, 100, 20);
		renderBuffer.setColor(Color.BLUE);
		renderBuffer.fillRect(80, 200, 220, 90);
		renderBuffer.fillRect(100, 10, 90, 80);
		renderBuffer.setColor(Color.LIGHT_GRAY);
		renderBuffer.fillRect(posX, posY, width, height);
		renderBuffer.setColor(Color.RED);
		renderBuffer.fillRect(200, 0, 45, 45);
		renderBuffer.fillRect(0, 100, 45, 200);
		renderBuffer.setColor(Color.MAGENTA);
		renderBuffer.fillRect(200, 55, 50, 135);
		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void update(Graphics g) {

		paint(g);
	}

	@Override
	public void run() {

		do {

			mover();
			delay(10);
			repaint();

		} while (true);
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void mover(){

		switch (this.direcion) {
			case Mondrian.ARRIBA:
				this.posY--;
				if (this.posY <= 140) {
					this.direcion = Mondrian.DERECHA;
				}
				//System.out.println("Arriba");
				break;
			case Mondrian.ABAJO:
				this.posY++;
				if (this.posY >= 150) {
					this.direcion = Mondrian.IZQUIERDA;
				}
				//System.out.println("Abajo");
				break;
			case Mondrian.IZQUIERDA:
				this.posX--;
				if (this.posX <= 50) {
					this.direcion = Mondrian.ARRIBA;
				}
				//System.out.println("Izquierda");
				break;
			case Mondrian.DERECHA:
				this.posX++;
				if (this.posX >= 75) {
					this.direcion = Mondrian.ABAJO;
				}
				//System.out.println("Derecha");
				break;
		}
	}

}
