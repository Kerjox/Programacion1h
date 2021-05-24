package Ejercicio01_Caminar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game extends JApplet implements Runnable, KeyEventDispatcher {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	private static final int GUERRILLERO = 0;
	private static final int HAMPON = 1;
	private static final int VAQUERO = 2;

	private Thread game;
	private Image image;
	private Graphics renderBuffer;
	private ArrayList<Guerrillero> guerrillerosList;
	private ArrayList<Hampon> hamponesList;
	private ArrayList<Vaquero> vaquerosList;
	private int player;

	@Override
	public void run() {

		do {

			repaint();
			delay(10);
		}while(true);
	}

	@Override
	public void init() {

		this.image = this.createImage(WIDTH, HEIGHT);
		this.renderBuffer = this.image.getGraphics();
		this.game = new Thread(this::run);
		this.player = 0;
		initGuerrilleros();
		initHampones();
		initVaqueros();

		suspendAnimationsPlayers();
		startAnimation();
	}

	@Override
	public void start() {

		resize(WIDTH, HEIGHT);
		requestFocusInWindow();
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
		game.start();
	}

	@Override
	public void paint(Graphics g) {

		renderBuffer.setColor(Color.BLACK);
		renderBuffer.fillRect(0, 0, WIDTH, HEIGHT);
		paintPlayer();
		g.drawImage(image, 0, 0, this);
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void initGuerrilleros() {

		this.guerrillerosList = new ArrayList<>();
		this.guerrillerosList.add(new Guerrillero(50, 50));
		this.guerrillerosList.add(new Guerrillero(150, 50));

	}

	private void initHampones() {

		this.hamponesList = new ArrayList<>();
		this.hamponesList.add(new Hampon(50, 50));
	}

	private void initVaqueros() {

		this.vaquerosList = new ArrayList<>();
		this.vaquerosList.add(new Vaquero(50, 50));

	}

	private void paintGuerrilleros() {

		for (Guerrillero guerrillero : guerrillerosList) {

			guerrillero.paint(renderBuffer);
		}
	}

	private void paintHampones() {

		for (Hampon hampon : hamponesList) {

			hampon.paint(renderBuffer);
		}
	}

	private void paintVaqueros() {

		for (Vaquero vaquero : vaquerosList) {

			vaquero.paint(renderBuffer);
		}
	}


	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {

		switch (e.getKeyCode()) {

			case 71:
				if (player == GUERRILLERO) break;
				player = GUERRILLERO;
				suspendAnimationsPlayers();
				startAnimation();
				break;

			case 72:
				if (player == HAMPON) break;
				player = HAMPON;
				suspendAnimationsPlayers();
				startAnimation();
				break;
			case 86:
				if (player == VAQUERO) break;
				player = VAQUERO;
				suspendAnimationsPlayers();
				startAnimation();
				break;
		}
		return false;
	}

	private void startAnimation() {

		switch (player) {

			case GUERRILLERO:

				for (Guerrillero guerrillero : guerrillerosList) {

					guerrillero.animation.resume();
				}
				break;

			case HAMPON:

				for (Hampon hampon : hamponesList) {

					hampon.animation.resume();
				}
				break;

			case VAQUERO:

				for (Vaquero vaquero : vaquerosList) {

					vaquero.animation.resume();
				}
				break;
		}
	}

	private void paintPlayer() {

		switch (this.player) {

			case 0:
				paintGuerrilleros();
				break;
			case 1:
				paintHampones();
				break;
			case 2:
				paintVaqueros();
				break;
		}
	}

	private void suspendAnimationsPlayers() {

		for (Guerrillero guerrillero : guerrillerosList) {

			guerrillero.animation.suspend();
		}

		for (Hampon hampon : hamponesList) {

			hampon.animation.suspend();
		}

		for (Vaquero vaquero : vaquerosList) {

			vaquero.animation.suspend();
		}
	}
}