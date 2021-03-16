package Ejercicio02_Puzzle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Pieza extends Rectangle {

	private Image img;

	public Pieza(int index) {

		super();

		this.x = (int) (Math.random() * Game.HEIGHT) - 60;
		this.y = (int) (Math.random() * Game.HEIGHT) - 60;

		loadImage(index);

		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}

	public void setPos(Point points) {

		this.x = points.x - 30;
		this.y = points.y - 30;
	}

	private void loadImage(int index) {

		try {
			img = ImageIO.read(getClass().getResource("img/" + index + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {

		g.drawImage(img, this.x, this.y, null);
	}

}
