package Arquero_Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Arrow extends Rectangle {

	private Image img;

	public Arrow(int y) {

		loadImage();

		this.x = 90;
		this.y = y + 33;
		this.width = 100;
		this.height = 20;
	}

	private void loadImage() {

		try {
			img = ImageIO.read(getClass().getResource("./img/archer-arrow.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void move() {

		this.x += 2;
	}

	public  void paint(Graphics g) {

		g.drawImage(img, this.x, this.y, this.width, this.height, null);
	}

}
