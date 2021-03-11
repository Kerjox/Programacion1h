package UBALDE_DANIEL_Examen;

import java.awt.*;

public class Player extends Rectangle {

	public Player(int x, int y) {

		super(x, y, 20, 40);
	}

	public void paint(Graphics g) {

		g.setColor(Color.YELLOW);
		g.fillOval(this.x, this.y, this.width, this.height);
	}

	public void move(int keyCode) {

		switch (keyCode) {

			case 37:            // Izquierda

				if (this.x >= 0) {

					this.x -= 10;
				}
				break;
			case 39:            // Derecha

				if (this.x + 20 <= Game.BGWIDTH)
				this.x += 10;
				break;
		}
	}

	public void jump() {

		this.y -= 2;
	}

	public void down() {

		this.y += 2;
	}
}
