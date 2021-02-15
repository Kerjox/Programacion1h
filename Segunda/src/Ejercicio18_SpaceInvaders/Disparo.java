package Ejercicio18_SpaceInvaders;

import java.awt.*;

public class Disparo extends Rectangle {

	private Color color;

	public Disparo(int x, int y) {

		super(x, y, 10, 30);
		this.color = Color.RED;
	}

	public void paint(Graphics g) {

		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
	}

	public void move() {


	}
}
