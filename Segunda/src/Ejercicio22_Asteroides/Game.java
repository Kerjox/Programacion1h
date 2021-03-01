package Ejercicio22_Asteroides;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends JApplet implements Runnable {

	public static final int BGWIDTH = 1024;
	public static final int BGHEIGHT = 720;

	private Thread game;
	private Image image;
	private Graphics renderBuffer;
	private List<Asteroid> asteroidsList;
	private Sun sun;
	private Random r = new Random();

	private int countSpawn = 1000;

	@Override
	public void run() {

		do {

			moveAsteroids();
			spawnMore();
			checkCollide();
			repaint();
			delay(5);
		}while (true);
	}

	@Override
	public void start() {

		game.start();
	}

	@Override
	public void init() {

		resize(BGWIDTH, BGHEIGHT);
		game = new Thread(this);
		image = this.createImage(BGWIDTH, BGHEIGHT);
		renderBuffer = image.getGraphics();
		sun = new Sun(BGWIDTH / 2, BGHEIGHT / 2);
		asteroidsList = new ArrayList<>();
		asteroidsList.add(new Asteroid(r.nextInt(BGWIDTH), r.nextInt(BGHEIGHT)));
	}

	@Override
	public void paint(Graphics g) {

		renderBuffer.setColor(Color.BLACK);
		renderBuffer.fillRect(0, 0, BGWIDTH, BGHEIGHT);
		sun.paint(renderBuffer);
		paintAsteroids();
		g.drawImage(image, 0, 0, this);
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void paintAsteroids() {

		for (Asteroid asteroid : asteroidsList) {

			asteroid.paint(renderBuffer);
		}
	}

	private void moveAsteroids() {

		for (Asteroid asteroid : asteroidsList) {

			asteroid.move();
		}
	}

	private void spawnMore() {

		if (this.countSpawn <= 0) {

			asteroidsList.add(new Asteroid(r.nextInt(BGWIDTH), r.nextInt(BGHEIGHT)));
			this.countSpawn = 1000;
		} else {

			this.countSpawn -= 5;
		}
	}

	private void checkCollide() {

		for (Asteroid asteroid : asteroidsList) {

			if (asteroid.intersects(sun)) {

				asteroidsList.remove(asteroid);
				break;
			}
		}
	}

}
