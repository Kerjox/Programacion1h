package Ejercicio17;

import java.awt.*;

public class Palabra extends Rectangle {

	private String palabra;
	private int speed;
	private Color color;
	private int level;

	public Palabra(String palabra) {

		super(JuegoPalabras.BGWIDTH - 50, (int) (Math.random()* JuegoPalabras.BGHEIGHT), 9 * palabra.length(), 20);
		this.palabra = palabra;
		this.speed = (int) (Math.random() * 3 + 1);
		this.color = Color.RED;
		this.level = 2;
	}

	public boolean moverPalabra() {

		if (this.x >= 0) {

			this.x -= speed;
			return false;
		}else return true;
	}

	public void paint(Graphics g) {

		g.setColor(color);
		g.fillRect(this.x, this.y, this.width, this.height);
		g.setColor(Color.WHITE);
		g.drawString(this.palabra, this.x + 2, this.y + 15);
	}

	public boolean clicked() {

		level--;
		if (this.level == 1) {

			this.color = Color.BLUE;
			return false;
		}else return true;
	}

}
