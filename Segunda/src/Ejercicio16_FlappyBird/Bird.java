package Ejercicio16_FlappyBird;

import java.awt.*;

public class Bird extends Rectangle {

	private final Color color;
	private int contSpeed;

	public Bird() {

		super(100, 50, 20, 20);
		this.color = Color.CYAN;
		this.contSpeed = 0;
	}

	public void drawBird(Graphics g) {

		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	public void move() {

		if (this.y + this.height < FlappyBird.BGHEIGHT) {

			if (contSpeed > 60) {
				this.y += 3;
			} else {
				this.y += 2;
				contSpeed++;
			}
		}
	}

	public void upBird() {

		contSpeed = 0;
		if (this.y > 0) this.y -= 30;
	}

}
