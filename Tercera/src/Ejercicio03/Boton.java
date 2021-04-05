package Ejercicio03;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Boton extends Rectangle{

	public static final int SIZE = 80;
	private Image img;
	private int index;

	public Boton(int index) {

		loadImage(index);
		this.width = this.height = SIZE;
		this.index = index;
	}

	private void loadImage(int index) {

		try {
			img = ImageIO.read(getClass().getResource("./src/botones/" + index + ".gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics g, int x, int y) {

		g.drawImage(this.img, x, y, this.width, this.height, null);
	}
}
