package Ejercicio23_GoogleRun;

import java.awt.*;

public class Dinosaur extends Rectangle implements Runnable{

	private final Thread jump;
	private boolean firstStart = true;

	public Dinosaur() {

		super(50, Game.HEIGHT / 2, 15, 30);
		this.jump = new Thread(this);
		jump.start();
	}

	public void paint(Graphics g) {

		g.setColor(Color.WHITE);
		g.fillOval(this.x, this.y, this.width, this.height);
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
