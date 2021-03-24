package Arquero_Game;

import java.awt.*;

public class Balloon extends Rectangle {

	private final Image img;

	public Balloon(Image image) {

		this.x = (int) (Math.random() * 200 + 600);
		this.y = Game.HEIGHT;
		this.width = 50;
		this.height = 60;
		this.img = image;

	}

	public void paint(Graphics g) {

		g.drawImage(img, this.x, this.y, this.width, this.height, null);
	}

	public void move() {

		this.y -= 2;
	}

}
