package UBALDE_DANIEL_Examen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends JApplet implements Runnable, KeyEventDispatcher {

	public static final int BGWIDTH = 800;
	public static final int BGHEIGHT = 600;
	private Thread game;
	private Image image;
	private Graphics renderBuffer;
	private Player player;
	private List<Plataforma> plataformasList;
	private List<Granizo> granizoList;
	private Random r = new Random();
	private int timeSpawnNewPlataforma = 1500;
	private boolean playerIsJumping = false;
	private int jumpLenght = 100;
	private int timeToSpawnGranizo = r.nextInt(3000) + 500;
	private boolean gameOver = false;

	@Override
	public void run() {

		do {

			spawnMorePlataformas();
			movePlataformas();
			checkoIfHasToRemovePlataformaByLimit();
			movePlayer();
			checkIfPlayerIsOnTheFloor();
			tirarGranizo();
			moverGranizo();
			checkCollidesGranizo();
			repaint();
			delay(15);
		}while (true);
	}

	@Override
	public void start() {

		resize(BGWIDTH, BGHEIGHT);
		requestFocusInWindow();
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
		game.start();
	}

	@Override
	public void init() {

		game = new Thread(this);
		image = this.createImage(BGWIDTH, BGHEIGHT);
		renderBuffer = image.getGraphics();
		plataformasList = new ArrayList<>();
		granizoList = new ArrayList<>();
		spawnPlataformas();
		spawnPlayer();
	}

	@Override
	public void paint(Graphics g) {

		if (!gameOver) {

			renderBuffer.setColor(Color.BLACK);
			renderBuffer.fillRect(0, 0, BGWIDTH, BGHEIGHT);
			player.paint(renderBuffer);
			paintPlataformas();
			paintGranizo();
		}
		g.drawImage(image ,0, 0, this);
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {

		player.move(e.getKeyCode());
		if (e.getKeyCode() == 38 && isOnPlataforma()) {

			playerIsJumping = true;
		}
		return false;
	}

	private void spawnPlataformas() {

		int x = 200;

		while(x < BGWIDTH) {

			Plataforma plataformaToInsert = new Plataforma(x);
			plataformasList.add(plataformaToInsert);
			x += plataformaToInsert.getWidth() + r.nextInt(50);
		}

	}

	private void paintPlataformas() {

		for (Plataforma plataforma : plataformasList) {

			plataforma.paint(renderBuffer);
		}
	}

	private void spawnPlayer() {

		int x = (int) plataformasList.get(0).getX();
		int y = (int) plataformasList.get(0).getY();

		player = new Player(x, y - 40);
	}

	private void movePlataformas() {

		for (Plataforma plataforma : plataformasList) {

			plataforma.mover();
		}
	}

	private void spawnMorePlataformas() {


		if (timeSpawnNewPlataforma <= 0) {

			plataformasList.add(new Plataforma());
			timeSpawnNewPlataforma = 1500;
		} else {

			timeSpawnNewPlataforma -= 15;
		}
	}

	private void checkoIfHasToRemovePlataformaByLimit() {

		if (plataformasList.get(0).getX() + plataformasList.get(0).getWidth() <= 0) {

			plataformasList.remove(plataformasList.get(0));
		}
	}

	private boolean isOnPlataforma() {

		boolean isOnPlataforma = false;

		for (Plataforma plataforma : plataformasList) {

			if (plataforma.contains(player.getX() + 10, player.getY() + 40)) {

				isOnPlataforma = true;
			}
		}

		return isOnPlataforma;
	}

	private void movePlayer() {

		if (playerIsJumping) {

			if (jumpLenght <= 0) {

				player.down();
				if (isOnPlataforma()) {

					playerIsJumping = false;
					jumpLenght = 100;
				}
			} else {

				player.jump();
				jumpLenght -= 2;
			}
		}else {

			if (!isOnPlataforma()) {

				player.down();
			}
		}
	}

	private void checkIfPlayerIsOnTheFloor() {

		if (player.getY() + 40 >= BGHEIGHT){

			gameOver();
			game.stop();
		}
	}

	private void tirarGranizo() {

		if (timeToSpawnGranizo <= 0) {

			granizoList.add(new Granizo());
			timeToSpawnGranizo = r.nextInt(3000) + 500;
		} else {

			timeToSpawnGranizo -= 15;
		}
	}

	private void paintGranizo() {

		for (Granizo granizo : granizoList) {

			granizo.paint(renderBuffer);
		}
	}

	private void moverGranizo() {

		for (Granizo granizo : granizoList) {

			granizo.mover();
		}
	}

	private void checkCollidesGranizo() {

		Granizo granizoToRemove = null;

		for (Granizo granizo : granizoList) {

			for (Plataforma plataforma : plataformasList) {

				if (granizo.intersects(plataforma)) {

					granizoToRemove = granizo;
				}
			}
		}

		granizoList.remove(granizoToRemove);

		if (granizoList.size() > 0 && granizoList.get(0).getY() >= Game.BGHEIGHT) {

			granizoList.remove(granizoList.get(0));
		}

		for (Granizo granizo : granizoList) {

			if (granizo.intersects(player)) {

				gameOver();
				game.stop();
			}
		}
	}

	private void gameOver() {

		gameOver = true;
		renderBuffer.setColor(Color.BLACK);
		renderBuffer.fillRect(0, 0, BGWIDTH, BGHEIGHT);
		renderBuffer.setColor(Color.WHITE);
		renderBuffer.setFont(new Font("serif", Font.PLAIN, 30));
		renderBuffer.drawString("Game Over", BGWIDTH / 2 - 50, BGHEIGHT / 2);
		repaint();
	}
}
