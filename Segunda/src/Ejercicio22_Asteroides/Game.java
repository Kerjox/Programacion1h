package Ejercicio22_Asteroides;

import Ejercicio21_Pelotica.Pelotica;

import javax.swing.*;
import java.awt.*;
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

	@Override
	public void run() {

		do {

			repaint();
		}while (true);
	}

	@Override
	public void start() {


	}

	@Override
	public void init() {

		resize(BGWIDTH, BGHEIGHT);
	}

	@Override
	public void paint(Graphics g) {


	}

}
