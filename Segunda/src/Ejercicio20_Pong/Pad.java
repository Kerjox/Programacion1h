package Ejercicio20_Pong;

import java.awt.*;

public class Pad extends Rectangle {

	public Pad(int x, int y) {

		super(x, y, 10, 100);
	}

	public void paint(Graphics g) {

		g.setColor(Color.WHITE);
		g.fillRect(this.x, this.y, this.width, this.height);
	}

	public void move(int dir) {

		if (dir == 0) {

			this.y -= 5;
		}else {

			this.y += 5;
		}
	}

}
