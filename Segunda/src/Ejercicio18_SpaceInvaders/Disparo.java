package Ejercicio18_SpaceInvaders;

import java.awt.*;

public class Disparo extends Rectangle {

	private final Color color;

	public Disparo(int x) {

		super(x, 360, 4, 15);
		this.color = Color.WHITE;
	}

	public void paint(Graphics g) {

		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
	}

	public void move() {

		y -= 2;
	}

}
