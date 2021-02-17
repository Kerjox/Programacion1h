package Ejercicio18_SpaceInvaders;

import java.awt.*;

public class Invader extends Rectangle {

	private final Color color;
	private boolean direction;
	private final int speed;

	public Invader() {

		super((int) (Math.random()* SpaceInvaders.BGWIDHT), (int) (Math.random()* 100), (int) (Math.random()*20) + 50, 10);
		this.color = new Color((int) (Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255));
		this.direction = false;
		this.speed = (int) (Math.random() * 4 + 1);
	}

	public void paint(Graphics g) {

		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
	}

	public void moveInvader() {

		if (this.direction) {
			if (this.x > 0) {

				this.x -= speed;
			}else {
				direction = false;
			}
		}else {
			if (this.x + this.width < SpaceInvaders.BGWIDHT) {

				this.x += speed;
			}else {
				direction = true;
			}
		}
	}
}
