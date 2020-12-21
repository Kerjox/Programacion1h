package Ejercicio05;

import java.awt.*;

public class Ovalo {

	private final Color color;
	private final int height;
	private final int posX;
	private final int posY;
	private final int width;

	public Ovalo() {

		this.posX = (int) (Math.random() * 200);
		this.posY = (int) (Math.random() * 200);
		this.width = (int) (Math.random() * 200);
		this.height = (int) (Math.random() * 200);
		this.color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
	}

}
