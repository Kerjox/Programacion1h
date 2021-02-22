package Ejercicio18_SpaceInvaders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

public class SpaceInvaders extends JApplet implements Runnable{

	private Thread game;
	private Image image;
	private Graphics renderBuffer;
	public static final int BGWIDTH = 600;
	public static final int BGHEIGHT = 400;
	private List<Invader> invadersList;
	private List<Disparo> disparosList;
	private final int numberInvaders = 10;
	private boolean gameOver = false;
	private Ship nave;
	private final int spawnAt = 2000;
	private int contSpawn = 0;


	@Override
	public void init() {

		resize(BGWIDTH, BGHEIGHT);
		this.image = this.createImage(BGWIDTH, BGHEIGHT);
		this.renderBuffer = image.getGraphics();
		disparosList = new ArrayList<>();
		nave = new Ship();
		mouseMoveListener();
		initInvaders();
		clickListener();
	}

	private void mouseMoveListener() {

		addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {

				nave.move(e.getX() - 28);
			}
		});
	}

	private void spawnMoreInvaders() {

		if (this.contSpawn >= this.spawnAt) {

			this.invadersList.add(new Invader());
			this.contSpawn = 0;
		} else this.contSpawn += 20;
	}

	private void clickListener() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				if (nave.getBullets() > 0) {

					disparosList.add(new Disparo(e.getX() - 1));
					nave.setBullets(nave.getBullets() - 1);
				}
			}
		});
	}

	private void initInvaders() {

		invadersList = new ArrayList<>();

		for (int i = 0; i < numberInvaders; i++) {

			invadersList.add(new Invader());
		}
	}

	@Override
	public void run() {

		do {

			moveInvader();
			moveDisparos();
			checkCollide();
			repaint();
			spawnMoreInvaders();
			delay(20);
		}while(true);
	}

	private void checkCollide() {

		for (Invader invader : invadersList) {

			boolean finish = false;
			for (Disparo disparo : disparosList) {

				if (invader.contains(disparo.getX() + 1, disparo.getY())) {

					disparosList.remove(disparo);
					invadersList.remove(invader);
					nave.setBullets(nave.getBullets() + 2);
					finish = true;
					break;
				}
			}
			if (finish) break;
		}

		if (invadersList.size() == 0) {
			youWin();
			this.gameOver = true;
			game.stop();
		}

		if (disparosList.size() == 0 && nave.getBullets() <= 0) {

			gameOver();
			this.gameOver = true;
			game.stop();
		}
	}

	private void moveDisparos() {

		if (disparosList.size() != 0) {

			for (Disparo disparo : disparosList) {

				disparo.move();
			}

			if (disparosList.get(0).getY() <= 0) {

				disparosList.remove(0);
			}
		}
	}

	private void youWin() {

		renderBuffer.setColor(Color.BLACK);
		renderBuffer.fillRect(0, 0, BGWIDTH, BGHEIGHT);
		renderBuffer.setColor(Color.WHITE);
		renderBuffer.setFont(new Font("serif", Font.PLAIN, 30));
		renderBuffer.drawString("You Win", BGWIDTH / 2 - 50, BGHEIGHT / 2);
		repaint();
	}

	private void gameOver() {

		renderBuffer.setColor(Color.BLACK);
		renderBuffer.fillRect(0, 0, BGWIDTH, BGHEIGHT);
		renderBuffer.setColor(Color.WHITE);
		renderBuffer.setFont(new Font("serif", Font.PLAIN, 30));
		renderBuffer.drawString("Game Over", BGWIDTH / 2 - 50, BGHEIGHT / 2);
		repaint();
	}

	private void moveInvader() {

		for (Invader invader : invadersList) {

			invader.moveInvader();
		}
	}

	@Override
	public void start() {

		this.game = new Thread(this);
		this.game.start();
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

		if (!gameOver) {

			renderBuffer.setColor(Color.BLACK);
			renderBuffer.fillRect(0, 0, BGWIDTH, BGHEIGHT);
			nave.paint(renderBuffer);
			for (Invader invader : invadersList) {

				invader.paint(renderBuffer);
			}

			for (Disparo disparo: disparosList) {

				disparo.paint(renderBuffer);
			}
			renderBuffer.setColor(Color.WHITE);
			renderBuffer.drawString("Bullets: " + this.nave.getBullets(), 0, 20);
		}

		g.drawImage(image, 0, 0, this);

	}

}
