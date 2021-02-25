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

	@Override
	public void run() {

		do {

			movePeloticas();
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
		peloticaList = new ArrayList<>();
		peloticaList.add(new Pelotica(100));
		clickListener();
	}

	@Override
	public void paint(Graphics g) {
		if (!gameOver) {

			renderBuffer.setColor(Color.BLACK);
			renderBuffer.fillRect(0, 0, BGWIDTH, BGWIDTH);
			paintPeloticas();
		}
		g.drawImage(image, 0, 0, this);
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

			pelotica.paint(renderBuffer);
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
				}

				if (peloticaList.size() <= 0) {

					gameOver();
				}
			}
		});
	}

	private void gameOver() {

		gameOver = true;
		renderBuffer.setColor(Color.BLACK);
		renderBuffer.fillRect(0, 0, BGWIDTH, BGHEIGHT);
		renderBuffer.setColor(Color.WHITE);
		renderBuffer.setFont(new Font("serif", Font.PLAIN, 30));
		renderBuffer.drawString("Game Over", BGWIDTH / 2 - 50, BGHEIGHT / 2);
		repaint();
		game.stop();
	}

}
