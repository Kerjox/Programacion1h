package Ejercicio18_SpaceInvaders;

import java.awt.*;

public class Invader extends Rectangle {

	private Color color;
	private boolean direction;

	public Invader() {

		super((int) (Math.random()* SpaceInvaders.BGWIDHT), (int) (Math.random()* 100), (int) (Math.random()*20) + 50, 10);
		this.color = new Color((int) (Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255));
		this.direction = false;
	}

	public void paint(Graphics g) {

		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
	}

	public void moveInvader() {

		if (this.direction) {
			if (this.x > 0) {

				this.x--;
			}else {
				direction = false;
			}
		}else {
			if (this.x + this.width < SpaceInvaders.BGWIDHT) {

				this.x++;
			}else {
				direction = true;
			}
		}
	}
}
