package Ejercicio20_Pong;

import java.awt.*;

public class Pelota extends Rectangle {

	public static final int DL = 1;
	public static final int DR = 0;
	public static final int UL = 2;
	public static final int UR = 3;
	private Color color;
	private int direction;

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

	public Pelota(int diameter) {

		super((int) (Math.random()* 500 + 20), 300, diameter, diameter);
		this.color = Color.RED;
		this.direction = Pelota.UR;
	}

	public void paint(Graphics g) {

		g.setColor(color);
		g.fillOval(x, y, width, height);
	}

	public void move() {

		switch (direction) {

			case DR:

				x += 1;
				y += 1;

				if (y + height >= Pong.BGHEIGTH) direction = UR;
				else if (x + width >= Pong.BGWIDTH) {
					direction = DL;
					System.out.println("Punto LEFT");
				}
				//System.out.println("Abajo Derecha");
				break;

			case UL:

				x -= 1;
				y -= 1;

				if (y <= 0) direction = DL;
				else if (x <= 0) {

					direction = UR;
					System.out.println("Punto RIGHT");
				}
				//System.out.println("Arriba Izquierda");
				break;

			case UR:

				x += 1;
				y -= 1;

				if (x + width >= Pong.BGWIDTH) {

					direction = UL;
					System.out.println("Punto LEFT");
				} else if (y <= 0) direction = DR;
				//System.out.println("Arriba Derecha");
				break;

			case DL:

				x -= 1;
				y += 1;

				if (x <= 0) {

					direction = DR;
					System.out.println("Punto RIGHT");

				} else if (y + height >= Pong.BGHEIGTH) {

					direction = UL;

				}
				//System.out.println("Abajo Izquierda");
				break;
		}
	}

}
