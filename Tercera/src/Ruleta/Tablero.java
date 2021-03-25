package Ruleta;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Tablero {

	private Image img;

	public Tablero() {

		loadImage();
	}

	private void loadImage() {

		try {
			this.img = ImageIO.read(getClass().getResource("./img/mesa.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {

		g.drawImage(img, 0, 100, null);
	}

}
