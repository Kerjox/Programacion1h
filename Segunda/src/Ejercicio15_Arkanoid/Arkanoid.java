package Ejercicio15_Arkanoid;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arkanoid extends JApplet implements Runnable {

	public static final int BGHEIGHT = 600;
	public static final int BGWIDTH = 800;
	private final List<Brick> bricks = new ArrayList<>();
	Thread game;
	Pelota pelota;
	Raqueta raqueta;
	Graphics renderBuffer;
	private Image image;
	private int speed = 4;
	private int vidas = 2;

	@Override
	public void init() {

		this.setSize(new Dimension(BGWIDTH, BGHEIGHT));
		image = this.createImage(getWidth(), getHeight());
		renderBuffer = image.getGraphics();

		initBricks();
		pelota = new Pelota(20);
		initRaqueta();

	}

	@Override
	public void paint(Graphics g) {

		renderBuffer.setColor(Color.BLACK);
		renderBuffer.fillRect(0, 0, getWidth(), getHeight());
		renderBuffer.setColor(Color.WHITE);
		renderBuffer.drawString("Vidas: " + vidas, 5, 135);
		paintBricks(renderBuffer);
		pelota.pintarPelota(renderBuffer);
		raqueta.pintar(renderBuffer);
		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void run() {

		do {
			moverPelota();
			repaint();
			checkCollideBricks();
			pelota.checkCollideRaqueta(raqueta);
			delay(speed);
		} while (true);
	}

	@Override
	public void start() {

		game = new Thread(this);
		game.start();
	}

	private void initRaqueta() {

		raqueta = new Raqueta(300, Arkanoid.BGHEIGHT - 50, 100, 10, Color.CYAN);
		addMouseMotionListener(raqueta.mover);
	}

	private void vidas(int n) {

		if ((this.vidas = vidas - n) <= 0) {
			game.stop();
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
		if (brickToBrake != null) {

			brickToBrake.removeBrick((ArrayList<Brick>) bricks);
			pelota.randomColor();
			//updateSpeed(bricks);
		}
	}

	private void updateSpeed(List<Brick> bricks) {

		int n = bricks.size();
		if (n > 70 && n <= 100) speed = 6;
		else if (n > 40 && n <= 70) speed = 5;
		else if (n > 10 && n <= 40) speed = 4;
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void initBricks() {

		Random r = new Random();
		for (int i = 0; i < 4; i++) {

			int x = 10;
			int width = r.nextInt(30) + 30;
			boolean end = true;
			while (end) {
				if (x > Arkanoid.BGWIDTH) {

					width = width - Arkanoid.BGWIDTH;
					end = false;
				}
				switch (i) {
					case 0:
						bricks.add(new Brick(x, 10, width, 20, 4));
						break;
					case 1:
						bricks.add(new Brick(x, 35, width, 20, 3));
						break;
					case 2:
						bricks.add(new Brick(x, 60, width, 20, 2));
						break;
					case 3:
						bricks.add(new Brick(x, 85, width, 20, 1));
						break;
				}
				x += width + 5;
				width = r.nextInt(30) + 30;

			}
		}
	}

	private void paintBricks(Graphics g) {

		for (Brick brick : bricks) {

			brick.pintar(g);
		}
	}

	public void moverPelota() {

		int x = (int) pelota.getX();
		int y = (int) pelota.getY();
		int width = (int) pelota.getWidth();
		int height = (int) pelota.getHeight();
		int direction = pelota.getDirection();

		switch (direction) {

			case Pelota.DR:

				pelota.setX(x + 1);
				pelota.setY(y + 1);

				if (y + height >= BGHEIGHT) {

					pelota.setDirection(Pelota.UR);
					vidas(1);

				} else if (x + width >= BGWIDTH) pelota.setDirection(Pelota.DL);
				//System.out.println("Abajo Derecha");
				break;

			case Pelota.UL:

				pelota.setX(x - 1);
				pelota.setY(y - 1);

				if (y <= 0) pelota.setDirection(Pelota.DL);
				else if (x <= 0) pelota.setDirection(Pelota.UR);
				//System.out.println("Arriba Izquierda");
				break;

			case Pelota.UR:

				pelota.setX(x + 1);
				pelota.setY(y - 1);

				if (x + width >= BGWIDTH) pelota.setDirection(Pelota.UL);
				else if (y <= 0) pelota.setDirection(Pelota.DR);
				//System.out.println("Arriba Derecha");
				break;

			case Pelota.DL:

				pelota.setX(x - 1);
				pelota.setY(y + 1);

				if (x <= 0) pelota.setDirection(Pelota.DR);
				else if (y + height >= BGHEIGHT) {

					pelota.setDirection(Pelota.UL);
					vidas(1);

				}
				//System.out.println("Abajo Izquierda");
				break;
		}
	}

}
