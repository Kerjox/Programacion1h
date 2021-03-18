package Ejercicio02_Puzzle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Piezas extends Rectangle {

	private int index;
	private Image img;

	private boolean colocada;

	public int getIndex() {

		return index;
	}

	public boolean isColocada() {

		return colocada;
	}

	public void setColocada(boolean colocada) {

		this.colocada = colocada;
	}


	public Piezas(int index) {

		super();

		this.index = index;
		this.x = (int) (Math.random() * 340) + 400;
		this.y = (int) (Math.random() * (Game.HEIGHT - 60));

		loadImage(index + 1);

		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.colocada = false;
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
