package Ejercicio23_GoogleRun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends JApplet implements Runnable {

	public static final int HEIGHT = 720;
	public static final int WIDTH = 1024;
	private int countNewObstacle = (int) (Math.random() * 2000 + 1000);
	private Dinosaur dino;
	private Thread game;
	private boolean gameOver = false;
	private Image image;
	private boolean intersect;
	private List<Obstacle> obstaclesList;
	private final Random r = new Random();
	private Graphics renderBuffer;
	private int contAciertos = 0;
	private int contFallos = 0;

	@Override
	public void init() {

		resize(WIDTH, HEIGHT);
		this.game = new Thread(this);
		this.image = this.createImage(WIDTH, HEIGHT);
		this.renderBuffer = this.image.getGraphics();
		this.dino = new Dinosaur();
		this.obstaclesList = new ArrayList<>();
		obstaclesList.add(new Obstacle());
		clickListener();
	}

	@Override
	public void paint(Graphics g) {

		if (! this.gameOver) {

			this.renderBuffer.setColor(Color.BLACK);
			this.renderBuffer.fillRect(0, 0, WIDTH, HEIGHT);
			this.renderBuffer.setColor(Color.WHITE);
			this.renderBuffer.drawLine(0, HEIGHT / 2 + 5, WIDTH, HEIGHT / 2 + 5);
			this.renderBuffer.drawLine(0, HEIGHT / 2 + 32, WIDTH, HEIGHT / 2 + 32);
			this.renderBuffer.drawString("A: " + contAciertos,20, 20);
			this.renderBuffer.drawString("F: " + contFallos,20, 40);
			paintObstacles();
			this.dino.paint(renderBuffer);
		}
		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void run() {

		do {

			moveObstacles();
			checkCollide();
			spawnNewObstacle();
			repaint();
			delay(5);
		} while (true);
	}

	@Override
	public void start() {

		game.start();
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void clickListener() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				dino.jump();
			}
		});
	}

	private void paintObstacles() {

		for (Obstacle obstavle : obstaclesList) {

			obstavle.paint(renderBuffer);
		}
	}

	private void moveObstacles() {

		Obstacle obstacleToRemove = null;
		for (Obstacle obstavle : obstaclesList) {

			obstavle.move();

			if (obstavle.getX() <= 0) {

				obstacleToRemove = obstavle;
			}
		}
		if (obstacleToRemove != null) {

			obstaclesList.remove(obstacleToRemove);
		}
	}

	private void spawnNewObstacle() {

		if (countNewObstacle <= 0) {

			obstaclesList.add(new Obstacle());
			countNewObstacle = (int) (Math.random() * 2000 + 1000);

		} else {
			countNewObstacle -= 5;
		}
	}

	private void gameOver() {

		gameOver = true;
		renderBuffer.setColor(Color.BLACK);
		renderBuffer.fillRect(0, 0, WIDTH, HEIGHT);
		renderBuffer.setColor(Color.WHITE);
		renderBuffer.setFont(new Font("serif", Font.PLAIN, 30));
		renderBuffer.drawString("Game Over", WIDTH / 2 - 50, HEIGHT / 2);
		repaint();
	}

	private void checkCollide() {

		intersect = obstaclesList.get(0).intersects(dino);

		if ((obstaclesList.get(0).getX()) == dino.getX() && !intersect) {

			contAciertos++;
		} else if ((obstaclesList.get(0).getX() == dino.getX())){

			contFallos++;
		}
	}

}
