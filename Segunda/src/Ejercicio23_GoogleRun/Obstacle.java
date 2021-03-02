package Ejercicio23_GoogleRun;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Obstacle extends Rectangle {

	BufferedImage image;

	public Obstacle() {

		super(Game.WIDTH, Game.HEIGHT / 2 - 10, 20, 40);
		String imageName = "img/cactuses/" + (int) (Math.random() * 5) + ".png";
		try {
			image = ImageIO.read(getClass().getResource(imageName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void paint(Graphics g) {

		g.setColor(Color.RED);
		g.drawImage(image, this.x, this.y, this.width, this.height, null);
	}

	public void move() {

		this.x--;
	}

}
