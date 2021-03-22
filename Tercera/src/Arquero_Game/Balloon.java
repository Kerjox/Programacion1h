package Arquero_Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Balloon extends Rectangle {

	private Image img;

	public Balloon() {

		this.x = (int) (Math.random() * 200 + 600);
		this.y = Game.HEIGHT;
		this.width = 50;
		this.height = 60;
		loadImage();

	}

	private void loadImage() {

		try {
			img = ImageIO.read(getClass().getResource("./img/globos/globo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {

		g.drawImage(img, this.x, this.y, this.width, this.height, null);
	}

	public void move() {

		this.y -= 2;
	}

}
