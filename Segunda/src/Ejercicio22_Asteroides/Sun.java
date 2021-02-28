package Ejercicio22_Asteroides;

import java.awt.*;

public class Sun extends Rectangle {

	public Sun(int x, int y) {

		super(x - 25, y - 25, 50, 50);

	}

	public void paint(Graphics g) {

		g.setColor(Color.YELLOW);
		g.fillOval(this.x, this.y, this.width, this.height);
	}
}
