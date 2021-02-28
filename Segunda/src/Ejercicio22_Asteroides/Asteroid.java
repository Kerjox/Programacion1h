package Ejercicio22_Asteroides;

import java.awt.*;

public class Asteroid extends Rectangle {

	private double velX;
	private double velY;
	private double posX;
	private double posY;

	public Asteroid(int x, int y) {

		super(x, y, 20, 20);
		this.posX = x;
		this.posY = y;
		calculateVel();
	}

	private void calculateVel() {

		this.velX = ((Game.BGWIDTH / 2.0) - this.x) / 1000.0;
		this.velY = ((Game.BGHEIGHT / 2.0) - this.y) / 1000.0;
	}

	public void paint(Graphics g) {

		g.setColor(Color.RED);
		g.fillOval(this.x, this.y, this.width, this.height);
	}

	public void move() {

		this.posX += this.velX;
		this.posY += this.velY;
		this.x = (int) this.posX;
		this.y = (int) this.posY;
	}
}
