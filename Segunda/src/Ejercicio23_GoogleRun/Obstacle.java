package Ejercicio23_GoogleRun;

import java.awt.*;

public class Obstacle extends Rectangle {

	public Obstacle() {

		super(Game.WIDTH, Game.HEIGHT / 2 + 10, 10, 10);
	}

	public void paint(Graphics g) {

		g.setColor(Color.RED);
		g.fillRect(this.x, this.y, this.width, this.height);
	}

	public void move() {

		this.x--;
	}

}
