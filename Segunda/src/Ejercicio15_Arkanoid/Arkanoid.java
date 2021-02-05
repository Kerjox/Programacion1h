package Ejercicio15_Arkanoid;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Arkanoid extends JApplet implements Runnable {

	private final List<Brick> bricks = new ArrayList<>();
	Thread game;
	Pelota pelota;
	Raqueta raqueta;
	Graphics renderBuffer;
	private Image image;

	@Override
	public void init() {

		this.setSize(new Dimension(600, 400));
		image = this.createImage(getWidth(), getHeight());
		renderBuffer = image.getGraphics();

		initBricks();
		pelota = new Pelota(getWidth(), getHeight());
		initRaqueta();

	}

	@Override
	public void paint(Graphics g) {

		renderBuffer.setColor(Color.BLACK);
		renderBuffer.fillRect(0, 0, getWidth(), getHeight());
		paintBricks(renderBuffer);
		pelota.pintarPelota(renderBuffer);
		raqueta.pintar(renderBuffer);
		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void run() {

		do {
			pelota.moverPelota();
			repaint();
			checkCollideBricks();
			checkCollideRaqueta();
			delay(1);
		} while (true);
	}

	@Override
	public void start() {

		game = new Thread(this);
		game.start();
	}

	private void initRaqueta() {

		raqueta = new Raqueta(300, 380, 80, 10, Color.CYAN);
		addMouseMotionListener(raqueta.mover);
	}

	private void checkCollideRaqueta() {

		if (raqueta.intersects(pelota)) {

			if (pelota.getDirection() == Pelota.DL) pelota.setDirection(Pelota.UL);
			else pelota.setDirection(Pelota.UR);
		}
	}

	private void checkCollideBricks() {

		Brick brickToBrake = null;
		for (Brick brick : bricks) {

			int direction = pelota.getDirection();
			if (brick.contains(pelota.x + 10, pelota.y)) {                              // Colisiona Arriba

				brickToBrake = brick;

				if (direction == Pelota.UL) pelota.setDirection(Pelota.DL);
				else pelota.setDirection(Pelota.DR);

			} else if (brick.contains(pelota.x, pelota.y + 10)) {                       // Colisiona Izquierda

				brickToBrake = brick;

				if (direction == Pelota.UL) pelota.setDirection(Pelota.UR);
				else pelota.setDirection(Pelota.DR);

			} else if (brick.contains(pelota.x + 20, pelota.y + 10)) {                // Colisiona Derecha

				brickToBrake = brick;

				if (direction == Pelota.UR) pelota.setDirection(Pelota.UL);
				else pelota.setDirection(Pelota.DL);

			} else if (brick.contains(pelota.x + 10, pelota.y + 20)) {                // Colisiona Abajo

				brickToBrake = brick;

				if (direction == Pelota.DL) pelota.setDirection(Pelota.UL);
				else pelota.setDirection(Pelota.UR);

			}
		}
		if (brickToBrake != null) brickToBrake.removeBrick((ArrayList<Brick>) bricks);
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
						bricks.add(new Brick(x, 10, 50, 20, 4));
						x += 50 + 5;
						break;
					case 1:
						bricks.add(new Brick(x, 35, 50, 20, 3));
						x += 50 + 5;
						break;
					case 2:
						bricks.add(new Brick(x, 60, 50, 20, 2));
						x += 50 + 5;
						break;
					case 3:
						bricks.add(new Brick(x, 85, 50, 20, 1));
						x += 50 + 5;
						break;
				}
			}
		}
	}

	private void paintBricks(Graphics g) {

		for (Brick brick : bricks) {

			brick.pintar(g);
		}
	}

}
