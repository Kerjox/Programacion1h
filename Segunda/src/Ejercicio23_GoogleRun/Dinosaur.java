package Ejercicio23_GoogleRun;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Dinosaur extends Rectangle implements Runnable{

	private final Thread jump;
	private boolean firstStart = true;
	private BufferedImage image;

	public Dinosaur() {

		super(50, Game.HEIGHT / 2 - 40, 30, 70);
		this.jump = new Thread(this);
		try {
			image = ImageIO.read(getClass().getResource("dino.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		jump.start();
	}

	public void paint(Graphics g) {

		g.setColor(Color.WHITE);
		g.drawImage(image, this.x, this.y, this.width, this.height, null);
	}

	public void run() {
		do {

			if (firstStart) {

				firstStart = false;
				jump.suspend();
			}
			for (int i = 0; i < 140; i++) {

				if (i < 70) {

					this.y--;
				}else {

					this.y++;
				}
				delay(5);
			}

			jump.suspend();
		}while(true);
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void jump() {

		jump.resume();
	}

}
