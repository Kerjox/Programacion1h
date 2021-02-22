package Ejercicio19_CrossyRoad;

import java.awt.*;

public class Frog extends Rectangle {

	public Frog() {

		super(100, 300, 15, 15);
	}

	public void paint(Graphics g) {

		g.setColor(Color.WHITE);
		g.fillRect(this.x, this.y, this.width, this.height);
	}

	public void move(String keyText) {

		switch (keyText) {

			case "W":
				this.y -= 3;
				break;
			case "A":
				this.x -= 3;
				break;
			case "S":
				this.y += 3;
				break;
			case "D":
				this. x += 3;
				break;
		}
	}

}
