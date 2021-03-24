package Arquero_Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class Game extends JApplet implements Runnable {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	private Image balloonImg;

	private Thread game;
	private Image image;
	private Graphics renderBuffer;
	private Archer archer;
	private ArrayList<Arrow> arrows;
	private ArrayList<Balloon> balloons;
	private int timeNewBalloon = 2000;

	@Override
	public void run() {

		do {

			moveArrows();
			moveBalloons();
			spawnMoreBalloons();
			checkCollides();
			checkLimits();
			repaint();
			delay(10);
		} while(true);
	}

	@Override
	public void init() {

		game = new Thread(this);
		image = this.createImage(WIDTH, HEIGHT);
		renderBuffer = image.getGraphics();
		archer = new Archer();
		arrows = new ArrayList<>();
		balloons = new ArrayList<>();
		loadImageBalloon();
		listeners();
	}

	@Override
	public void start() {

		resize(WIDTH, HEIGHT);
		game.start();
	}

	@Override
	public void paint(Graphics g) {

		renderBuffer.setColor(Color.WHITE);
		renderBuffer.fillRect(0, 0, WIDTH, HEIGHT);
		archer.paint(renderBuffer);
		paintArrows();
		paintBalloons();
		g.drawImage(image, 0, 0, this);
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void loadImageBalloon() {

		try {
			balloonImg = ImageIO.read(getClass().getResource("./img/globos/globo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void listeners() {

		addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {

				archer.move(e);
			}
		});

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				arrows.add(new Arrow(e.getY()));
			}
		});
	}

	private void paintArrows() {

		if (arrows.size() > 0) {

			for (Arrow arrow : arrows) {

				arrow.paint(renderBuffer);
			}
		}
	}

	private void paintBalloons() {

		if (balloons.size() > 0) {

			for (Balloon balloon : balloons) {

				balloon.paint(renderBuffer);
			}
		}
	}

	private void moveBalloons() {

		if (balloons.size() > 0) {

			for (Balloon balloon : balloons) {

				balloon.move();
			}
		}
	}

	private void spawnMoreBalloons() {

		if (this.timeNewBalloon <= 0) {

			balloons.add(new Balloon(balloonImg));
			this.timeNewBalloon = 2000;
		} else {

			this.timeNewBalloon -= 10;
		}
	}

	private void checkLimits() {

		Arrow arrowToremove = null;
		Balloon balloonToremove = null;

		for (Arrow arrow : arrows) {

			if (arrow.getX() >= WIDTH) {

				arrowToremove = arrow;
			}
		}

		arrows.remove(arrowToremove);

		for (Balloon balloon : balloons) {

			if (balloon.getY() <= 0) {

				balloonToremove = balloon;
			}
		}

		balloons.remove(balloonToremove);
	}

	private void moveArrows() {

		if (arrows.size() > 0) {

			for (Arrow arrow : arrows) {

				arrow.move();
			}
		}
	}

	private void checkCollides() {

		if (arrows.size() > 0 && balloons.size() > 0) {

			Arrow arrowToremove = null;
			Balloon balloonToremove = null;

			for (Arrow arrow : arrows) {

				for (Balloon balloon : balloons) {

					if (balloon.contains(arrow.getX() + arrow.getWidth(), arrow.getY() + arrow.getHeight() / 2)) {

						arrowToremove = arrow;
						balloonToremove = balloon;

					}
				}
			}

			arrows.remove(arrowToremove);
			balloons.remove(balloonToremove);
		}
	}

}
