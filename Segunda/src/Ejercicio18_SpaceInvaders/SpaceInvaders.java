package Ejercicio18_SpaceInvaders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class SpaceInvaders extends JApplet implements Runnable{

	private Thread game;
	private Image image;
	private Graphics renderBuffer;
	public static final int BGWIDHT = 600;
	public static final int BGHEIGHT = 400;
	private List<Invader> invadersList;
	private List<Disparo> disparosList;
	private final int numberInvaders = 10;

	@Override
	public void init() {

		this.image = this.createImage(BGWIDHT, BGHEIGHT);
		this.renderBuffer = image.getGraphics();
		initInvaders();
		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {


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
			repaint();
			delay(50);
		}while(true);
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

		renderBuffer.setColor(Color.BLACK);
		renderBuffer.fillRect(0, 0, BGWIDHT, BGHEIGHT);
		for (Invader invader : invadersList) {

			invader.paint(renderBuffer);
		}

		g.drawImage(image, 0, 0, this);

	}

}
