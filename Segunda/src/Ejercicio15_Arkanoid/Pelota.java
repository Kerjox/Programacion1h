package Ejercicio15_Arkanoid;

import java.awt.*;
import java.util.Random;

public class Pelota extends Rectangle {

	public static final int DL = 1;
	public static final int DR = 0;
	public static final int UL = 2;
	public static final int UR = 3;
	private final Random r = new Random();
	private Color color;
	private int direction;

	public Pelota(int diameter) {

		super((int) (Math.random()* 500 + 20), 300, diameter, diameter);
		randomColor();
		this.direction = Pelota.UR;
	}

	public void setX(int x) {

		this.x = x;
	}

	public void setY(int y) {

		this.y = y;
	}

	public void randomColor() {

		this.color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}

	public void checkCollideRaqueta(Raqueta raqueta) {

		if (raqueta.intersects(this)) {

			if (this.direction == Pelota.DL) this.direction = Pelota.UL;
			else this.direction = Pelota.UR;
		}
	}

	public int getDirection() {

		return direction;
	}

	public void setDirection(int direction) {

		this.direction = direction;
	}

	public void pintarPelota(Graphics g) {

		g.setColor(color);
		g.fillOval(x, y, width, height);
	}

}
