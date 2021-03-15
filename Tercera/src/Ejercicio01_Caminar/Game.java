package Ejercicio01_Caminar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends JApplet implements Runnable {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	private Thread game;
	private Image image;
	private Graphics renderBuffer;
	private ArrayList<Guerrillero> guerrilleros;

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
		generateGuerrilleros();
	}

	@Override
	public void start() {

		resize(WIDTH, HEIGHT);
		game.start();
	}

	@Override
	public void paint(Graphics g) {

		renderBuffer.setColor(Color.BLACK);
		renderBuffer.fillRect(0, 0, WIDTH, HEIGHT);
		paintGuerrilleros();
		g.drawImage(image, 0, 0, this);
	}

	private void paintGuerrilleros() {

		for (Guerrillero guerrillero : guerrilleros) {

			guerrillero.paint(renderBuffer);
		}
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void generateGuerrilleros() {

		this.guerrilleros = new ArrayList<>();
		guerrilleros.add(new Guerrillero(50, 50));
		guerrilleros.add(new Guerrillero(50, 300));
	}



}
