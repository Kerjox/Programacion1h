package Ejercicio02_Puzzle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Pieza extends Rectangle {

	private int index;
	private Image img;

	protected Pieza() {

	}

	protected Pieza(int index) {

		super();

		this.index = index - 1;
		this.x = (int) (Math.random() * 400) + 400;
		this.y = (int) (Math.random() * Game.HEIGHT);

		loadImage(index);

		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}

	protected void setPos(Point points) {

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

	protected void paint(Graphics g) {

		g.drawImage(img, this.x, this.y, null);
	}

	public int getIndex() {

		return index;
	}

}
