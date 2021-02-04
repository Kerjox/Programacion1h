package Ejercicio15_Arkanoid;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Arkanoid extends JApplet implements Runnable {

	Thread game;
	Pelota pelota;
	Graphics renderBuffer;
	private final List<Brick> bricks = new ArrayList<>();
	private Image image;

	@Override
	public void init() {

		this.setSize(new Dimension(600, 400));
		image = this.createImage(getWidth(), getHeight());
		renderBuffer = image.getGraphics();
		initBricks();
		pelota = new Pelota(getWidth(), getHeight());


	}

	@Override
	public void paint(Graphics g) {

		renderBuffer.setColor(Color.BLACK);
		renderBuffer.fillRect(0, 0, getWidth(), getHeight());
		paintBricks(renderBuffer);
		pelota.pintarPelota(renderBuffer);
		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void run() {

		do {
			pelota.moverPelota();
			repaint();
			checkCollide();
			delay(10);
		} while (true);
	}

	@Override
	public void start() {

		game = new Thread(this);
		game.start();
	}

	private void checkCollide() {

		for (Brick brick : bricks) {

			int direction = pelota.getDirection();
			if (brick.contains(pelota.x + 10, pelota.y)) {                              // Colisiona Arriba

				bricks.remove(brick);

				if (direction == Pelota.UL) pelota.setDirection(Pelota.DL);
				else pelota.setDirection(Pelota.DR);

			} else if (brick.contains(pelota.x, pelota.y + 10)) {                       // Colisiona Izquierda

				bricks.remove(brick);

				if (direction == Pelota.UL) pelota.setDirection(Pelota.UR);
				else pelota.setDirection(Pelota.DR);

			} else if (brick.contains(pelota.x + 20, pelota.y + 10)) {                // Colisiona Derecha

				bricks.remove(brick);

				if (direction == Pelota.UR) pelota.setDirection(Pelota.UL);
				else pelota.setDirection(Pelota.DL);

			} else if (brick.contains(pelota.x + 10, pelota.y + 20)) {                // Colisiona Abajo

				bricks.remove(brick);

				if (direction == Pelota.DL) pelota.setDirection(Pelota.UL);
				else pelota.setDirection(Pelota.UR);

			}
		}
		//bricks.removeIf(brick -> brick.contains(pelota.x + 10, pelota.y));
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

	private void paintBricks(Graphics g) {

		for (Brick brick : bricks) {

			brick.pintar(renderBuffer);
		}
	}

}
