package Ejercicio05.Ovalos2;

import java.awt.*;
import java.util.Random;

public class Ovalo {

	private Color color;
	private int height;
	private int posX;
	private int posY;
	private int width;
	private final Random r;

	public Ovalo() {

		r = new Random();
		this.init();

	}

	public void init() {

		this.width = r.nextInt(50);
		this.height = r.nextInt(50);
		this.posX = r.nextInt(200);
		this.posY = r.nextInt(200);
		this.color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}

	public void dibujar(Graphics g) {

		g.setColor(this.color);
		g.fillOval(this.posX, this.posY, this.width, this.height);
	}

}
