package Ejercicio21_Pelotica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends JApplet implements Runnable {

	public static final int BGWIDTH = 1024;
	public static final int BGHEIGHT = 720;

	private Thread game;
	private Image image;
	private Graphics renderBuffer;
	private List<Pelotica> peloticaList;
	private boolean gameOver = false;
	private Random r = new Random();
	private int timeLeft = 30000;                   // En milisegundos

	private int delay = 20;

	@Override
	public void run() {

		do {

			movePeloticas();
			repaint();
			checkTimeLeft();
			delay(delay);
		}while (true);
	}

	@Override
	public void start() {

		this.game.start();
	}

	@Override
	public void init() {

		resize(BGWIDTH, BGHEIGHT);
		this.game = new Thread(this);
		this.image = this.createImage(BGWIDTH, BGHEIGHT);
		this.renderBuffer = image.getGraphics();
		this.peloticaList = new ArrayList<>();
		this.peloticaList.add(new Pelotica(100));
		clickListener();
	}

	@Override
	public void paint(Graphics g) {

		if (!gameOver) {

			this.renderBuffer.setColor(Color.BLACK);
			this.renderBuffer.fillRect(0, 0, BGWIDTH, BGWIDTH);
			this.renderBuffer.setColor(Color.WHITE);
			this.renderBuffer.drawString("Time left: " + this.timeLeft / 1000, 20, 20);
			paintPeloticas();
		}
		g.drawImage(this.image, 0, 0, this);
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void paintPeloticas() {

		for (Pelotica pelotica: peloticaList) {

			pelotica.paint(this.renderBuffer);
		}
	}

	private void movePeloticas() {

		for (Pelotica pelotica: peloticaList) {

			pelotica.move();
		}
	}

	private void clickListener() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				Pelotica peloticaClicked = null;

				for (Pelotica pelotica : peloticaList) {

					if (pelotica.contains(e.getPoint())) {

						peloticaClicked = pelotica;
					}
				}

				if (peloticaClicked != null) {
					if (peloticaClicked.getHeight() / 2 > 10) {

						peloticaList.add(new Pelotica((int) (peloticaClicked.getX()), (int) (peloticaClicked.getY()), (int) (peloticaClicked.getHeight() / 2), r.nextInt(3)));
						peloticaList.add(new Pelotica((int) ((peloticaClicked.getX()) + peloticaClicked.getHeight() / 2), (int) ((peloticaClicked.getY()) + peloticaClicked.getHeight() / 2), (int) (peloticaClicked.getHeight() / 2), r.nextInt(3)));
					}

					peloticaList.remove(peloticaClicked);
					delay--;
				}

				if (peloticaList.size() <= 0) {

					gameOver("You Win");
				}
			}
		});
	}

	private void gameOver(String word) {

		this.gameOver = true;
		this.renderBuffer.setColor(Color.BLACK);
		this.renderBuffer.fillRect(0, 0, BGWIDTH, BGHEIGHT);
		this.renderBuffer.setColor(Color.WHITE);
		this.renderBuffer.setFont(new Font("serif", Font.PLAIN, 30));
		this.renderBuffer.drawString(word, BGWIDTH / 2 - 50, BGHEIGHT / 2);
		repaint();
		this.game.stop();
	}

	private void checkTimeLeft() {

		if (this.timeLeft <= 0) {

			gameOver("Game Over");
		}else {

			this.timeLeft -= this.delay;
		}
	}

}
