package Ejercicio16_FlappyBird;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class Pipe{

	private Color color;
	private Random r = new Random();
	private Rectangle rTop;
	private Rectangle rBottom;
	private final int space = 100;

	public Pipe(int x) {

		this.color = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
		int randomHeight = r.nextInt(FlappyBird.BGHEIGHT - space);
		this.rTop = new Rectangle(x, 0, 50 , randomHeight);
		this.rBottom = new Rectangle(x, randomHeight + space, 50, FlappyBird.BGHEIGHT);
	}

	public void drawPipes(Graphics g) {

		g.setColor(this.color);
		g.fillRect(rTop.x, rTop.y, rTop.width, rTop.height);
		g.fillRect(rBottom.x, rBottom.y, rBottom.width, rBottom.height);
	}

	public void movePipe() {

		this.rTop.x--;
		this.rBottom.x--;
	}

	public Pipe removePipe() {

		if (rTop.x <= 20) {
			return this;
		}
		return null;
	}

	public boolean checkCollide(Bird bird) {

		int birdX = (int) bird.getX();
		int birdY = (int) bird.getY();
		return this.rTop.contains(birdX + 10, birdY) || this.rBottom.contains(birdX + 10, birdY)
				|| this.rTop.contains(birdX + 20, birdY + 10) || this.rBottom.contains(birdX + 20, birdY + 10)
				|| this.rTop.contains(birdX + 10, birdY + 20) || this.rBottom.contains(birdX + 10, birdY + 20);
	}

}
