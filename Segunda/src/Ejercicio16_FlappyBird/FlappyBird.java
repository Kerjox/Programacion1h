package Ejercicio16_FlappyBird;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class FlappyBird extends JApplet implements Runnable {

	public static final int BGHEIGHT = 600;
	public static final int BGWIDTH = 800;
	private Bird bird;
	private List<Pipe> pipes;
	private Thread game;
	private Image image;
	private Graphics renderBuffer;
	private int numberCollides;
	private int delay = 20;
	private int contDelay = 0;
	private int lastPipeX;

	@Override
	public void init() {

		image = this.createImage(BGWIDTH, BGHEIGHT);
		renderBuffer = image.getGraphics();
		numberCollides = 0;
		initBird();
		initPipes();
	}

	@Override
	public void paint(Graphics g) {

		renderBuffer.setColor(Color.BLACK);
		renderBuffer.fillRect(0, 0, BGWIDTH, BGHEIGHT);
		bird.drawBird(renderBuffer);
		drawColls();
		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void run() {

		do {
			bird.move();
			checkCollide();
			generatePipe();
			repaint();
			delay(this.delay);
		} while (true);
	}

	private void generatePipe() {

		this.contDelay += this.delay;
		if (contDelay >= 3000) {

			pipes.add(new Pipe(lastPipeX));
			lastPipeX += 180;
			contDelay = 0;
		}
	}

	@Override
	public void start() {

		this.game = new Thread(this);
		this.game.start();

	}

	private void checkCollide() {

		for (Pipe pipe : pipes) {

			if (pipe.checkCollide(bird)) {
				numberCollides++;
				System.out.printf("Collide %d \n", numberCollides);
			}
		}
	}

	private void initPipes() {

		pipes = new ArrayList<>();

		int x = 300;
		for (int i = 0; i < 20; i++) {

			pipes.add(new Pipe(x));

			x += 180;
		}
		lastPipeX = x;

	}

	private void initBird() {

		bird = new Bird();
		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				bird.upBird();
			}
		});
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void drawColls() {

		Pipe pipeToRemove = null;
		for (Pipe pipe : pipes) {

			pipeToRemove = pipe.removePipe();
			if (pipeToRemove != null) {
				pipes.remove(pipeToRemove);
				break;
			}
		}

		for (Pipe pipe : pipes) {

			pipe.movePipe();
			pipe.drawPipes(renderBuffer);
		}
	}

}
