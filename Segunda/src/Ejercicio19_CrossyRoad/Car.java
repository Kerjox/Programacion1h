package Ejercicio19_CrossyRoad;

import java.awt.*;

public class Car extends Rectangle {

	public static final boolean LEFT = true;
	public static final boolean RIGHT = false;
	private final Color color;
	private final boolean direction;
	private final int speed;
	public Car(int x, int y, boolean direction, int speed) {

		super(x, y, 50, 20);
		this.color = Color.RED;
		this.direction = direction;
		this.speed = speed;
	}

	public boolean isDirection() {

		return direction;
	}

	public void move() {

		if (this.direction) {

			this.x -= this.speed;
		} else {

			this.x += this.speed;
		}
	}

	public void paint(Graphics g) {

		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
	}

}
