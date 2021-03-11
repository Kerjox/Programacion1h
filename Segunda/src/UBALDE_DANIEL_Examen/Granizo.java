package UBALDE_DANIEL_Examen;

import java.awt.*;

public class Granizo extends Rectangle {

	public Granizo() {

		super((int) (Math.random() * Game.BGWIDTH), 0, 5, 5);
	}

	public void paint(Graphics g) {

		g.setColor(Color.WHITE);
		g.fillOval(this.x, this.y, this.width, this.height);
	}

	public void mover() {

		this.y += 2;
	}

}
