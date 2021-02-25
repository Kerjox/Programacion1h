package Ejercicio21_Pelotica;

import java.awt.*;

public class Pelotica extends Rectangle {

	public static final int DL = 1;
	public static final int DR = 0;
	public static final int UL = 2;
	public static final int UR = 3;
	private final Color color;
	private int direction;
	private float velX, velY;

	public Pelotica(int diameter) {

		super((int) (Math.random() * 500 + 20), 300, diameter, diameter);
		this.velX = (float) (Math.random() * 2 + 1);
		this.velY = (float) (Math.random() * 2 + 1);
		this.color = Color.RED;
		this.direction = UR;
	}

	public Pelotica(int x, int y, int diameter, int direction) {

		super(x, y, diameter, diameter);
		this.color = Color.RED;
		this.velX = (float) (Math.random() * 2 + 1);
		this.velY = (float) (Math.random() * 2 + 1);
		this.direction = direction;
	}

	public void setX(int x) {

		this.x = x;
	}

	public void setY(int y) {

		this.y = y;
	}

	public int getDirection() {

		return direction;
	}

	public void setDirection(int direction) {

		this.direction = direction;
	}

	public void paint(Graphics g) {

		g.setColor(color);
		g.fillOval(x, y, width, height);
	}

	public void move() {

		switch (direction) {

			case DR:

				x += velX;
				y += velY;

				if (y + height >= Game.BGHEIGHT) direction = UR;
				else if (x + width >= Game.BGWIDTH) {

					direction = DL;
				}
				//System.out.println("Abajo Derecha");
				break;

			case UL:

				x -= velX;
				y -= velY;

				if (y <= 0) direction = DL;
				else if (x <= 0) {

					direction = UR;
				}
				//System.out.println("Arriba Izquierda");
				break;

			case UR:

				x += velX;
				y -= velY;

				if (x + width >= Game.BGWIDTH) {

					direction = UL;
				} else if (y <= 0) direction = DR;
				//System.out.println("Arriba Derecha");
				break;

			case DL:

				x -= velX;
				y += velY;

				if (x <= 0) {

					direction = DR;

				} else if (y + height >= Game.BGHEIGHT) {

					direction = UL;

				}
				//System.out.println("Abajo Izquierda");
				break;
		}
	}

}

