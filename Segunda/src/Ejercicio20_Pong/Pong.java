package Ejercicio20_Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pong extends JApplet implements Runnable, KeyEventDispatcher {

	public static final int BGWIDTH = 600;
	public static final int BGHEIGHT = 400;

	private Thread game;
	private Image image;
	private Graphics renderBuffer;

	private Pad padRight;
	private Pad padLeft;

	private Pelota pelota;
	private boolean goal = false;

	private int scoreLeft = 0;
	private int scoreRight = 0;

	@Override
	public void run() {

		do {

			if (!goal) {
				pelota.move();
				checkCollide();
				checkGoal();
			}
			repaint();
			delay(5);
		}while(true);
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
		padLeft = new Pad(20, 20);
		padRight = new Pad(560, 20);
		pelota = new Pelota(20);
		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				goal = false;
			}
		});
	}

	@Override
	public void paint(Graphics g) {

		renderBuffer.setColor(Color.BLACK);
		renderBuffer.fillRect(0, 0, BGWIDTH, BGHEIGHT);
		padRight.paint(renderBuffer);
		padLeft.paint(renderBuffer);
		pelota.paint(renderBuffer);
		renderBuffer.setColor(Color.WHITE);
		renderBuffer.drawString(String.valueOf(scoreLeft), 20, 20);
		renderBuffer.drawString(String.valueOf(scoreRight), 580, 20);
		g.drawImage(image, 0, 0, this);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {

		switch (e.getKeyCode()){

			case 87:

				padLeft.move(0);
				break;

			case 83:

				padLeft.move(1);
				break;

			case 38:

				padRight.move(0);
				break;

			case 40:

				padRight.move(1);
				break;

		}
		//System.out.println(e.getKeyCode());
		return false;
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void checkCollide() {

		if (pelota.intersects(padLeft)) {

			if (pelota.getDirection() == Pelota.UL) {

				pelota.setDirection(Pelota.UR);
			}else {
				pelota.setDirection(Pelota.DR);
			}
		}else if (pelota.intersects(padRight)) {

			if (pelota.getDirection() == Pelota.DR) {

				pelota.setDirection(Pelota.DL);
			}else {
				pelota.setDirection(Pelota.UL);
			}
		}
	}

	private void checkGoal() {

		//System.out.printf("%d : %d \n", scoreLeft, scoreRight);
		if (pelota.getX() <= 0) {

			scoreRight++;
			pelota.setX((int) (padLeft.getX() + 10));
			pelota.setY((int) padLeft.getY() + 30);
			this.goal = true;
		} else if (pelota.getX() + 20 >= BGWIDTH) {

			scoreLeft++;
			pelota.setX((int) (padRight.getX() - 20));
			pelota.setY((int) padRight.getY() + 30);
			this.goal = true;
		}
	}

}
