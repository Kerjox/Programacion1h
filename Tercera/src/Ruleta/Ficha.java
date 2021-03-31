package Ruleta;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Ficha extends Rectangle {

	private final int value;
	private final Image img;

	public int getValue() {

		return this.value;
	}

	public Ficha(int index, Point p) {

		this.width = this.height = 20;
		this.x = p.x - 10;
		this.y = p.y - 10;
		this.value = getValue(index);
		this.img = getImage(index);

	}

	private Image getImage(int index) {

		try {
			return ImageIO.read(getClass().getResource("./img/fichas/" + index + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private int getValue(int index) {

		switch (index) {

			case 0:
				return 10;
			case 1:
				return 25;
			case 2:
				return 50;
			case 3:
				return 100;
			case 4:
				return 500;
			case 5:
				return 1000;
			default:
				return 0;
		}
	}

	public void paint(Graphics g) {

		g.drawImage(this.img, this.x, this.y, this.width, this.height, null);
	}

	public void move(Point p) {

		this.x = p.x - 10;
		this.y = p.y - 10;
	}

}
