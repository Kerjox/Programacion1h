package Ejercicio15_Arkanoid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class Arkanoid extends JApplet implements Runnable {

	private List<Brick> bricks = new ArrayList<>();
	private Image image;
	Graphics renderBuffer;
	Pelota pelota;
	Thread game;

	@Override
	public void run() {

		do {
			pelota.moverPelota();
			repaint();
			checkCollide();
			delay(10);
		}while (true);
	}

	private void checkCollide() {

		bricks.removeIf(brick -> brick.contains(pelota.x + 10, pelota.y));
		pelota.setCollide(true);
	}

	@Override
	public void start() {

		game = new Thread(this);
		game.start();
	}

	@Override
	public void init() {

		this.setSize(new Dimension(600, 400));
		image = this.createImage(getWidth(), getHeight());
		renderBuffer = image.getGraphics();
		initBricks();
		pelota = new Pelota(getWidth(), getHeight());


	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void initBricks() {

		for (int i = 0; i < 4; i++) {

			int x = 10;
			for (int j = 0; j < 10; j++) {

				switch (i) {
					case 0:
						bricks.add(new Brick(x, 10, 50, 20, Color.RED));
						x += 50 + 5;
						break;
					case 1:
						bricks.add(new Brick(x, 35, 50, 20, Color.YELLOW));
						x += 50 + 5;
						break;
					case 2:
						bricks.add(new Brick(x, 60, 50, 20, Color.GREEN));
						x += 50 + 5;
						break;
					case 3:
						bricks.add(new Brick(x, 85, 50, 20, Color.BLUE));
						x += 50 + 5;
						break;
				}
			}
		}
	}

	@Override
	public void paint(Graphics g) {

		renderBuffer.setColor(Color.BLACK);
		renderBuffer.fillRect(0, 0, getWidth(), getHeight());
		paintBricks(renderBuffer);
		pelota.pintarPelota(renderBuffer);
		g.drawImage(image, 0, 0, this);
	}

	private void paintBricks(Graphics g) {

		for (Brick brick : bricks) {

			brick.pintar(renderBuffer);
		}
	}

}
