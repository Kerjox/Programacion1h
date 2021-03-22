package Arquero_Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Archer {

	private Image img;
	private int y;

	public Archer() {

		this.y = 50;
		loadImage();
	}

	private void loadImage() {

		try {
			img = ImageIO.read(getClass().getResource("./img/arquero.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {

		g.drawImage(this.img, 20, this.y, 70, 100,null);
	}

	public void move(MouseEvent e) {

		this.y = e.getY();
	}

}
