package Ejercicio14_Pelota.Juego1;

import java.awt.*;
import java.util.Random;

public class Pelota {

	public static final int DL = 1;
	public static final int DR = 0;
	public static final int UL = 2;
	public static final int UR = 3;
	private Color color;
	private int direction;
	private final Random r = new Random();
	private final int width;
	private final int height;
	private int x, y;
	private int bgWidth, bgHeight;

	public Pelota(int diameter, int bgWidth, int bgHeight) {

		this.x = r.nextInt(bgWidth - diameter);
		this.y = r.nextInt(bgHeight - diameter);
		this.width = this.height = diameter;
		this.bgWidth = bgWidth;
		this.bgHeight = bgHeight;
		randomColor();
		this.direction = r.nextInt(3);
	}

	public Pelota(int bgWidth, int bgHeight) {

		this((int) (Math.random() * 25) + 5, bgWidth, bgHeight);
	}

	private void randomColor() {

		this.color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}

	public void mover() {

		//System.out.printf("X: %d \n", x);
		//System.out.printf("Y: %d \n", y);
		switch (this.direction) {


			case Pelota.DR:

				this.x++;
				this.y++;

				if (this.y + height >= bgHeight) {
					this.direction = Pelota.UR;
					randomColor();
				} else if (this.x + width >= bgWidth) {
					this.direction = Pelota.DL;
					randomColor();
				}
				//System.out.println("Abajo Derecha");
				break;

			case Pelota.UL:

				this.x--;
				this.y--;

				if (this.y <= 0) {
					this.direction = Pelota.DL;
					randomColor();
				} else if (this.x <= 0) {
					this.direction = Pelota.UR;
					randomColor();
				}
				//System.out.println("Arriba Izquierda");
				break;

			case Pelota.UR:

				this.x++;
				this.y--;

				if (this.x + width >= bgWidth) {
					this.direction = Pelota.UL;
					randomColor();
				} else if (this.y <= 0) {
					this.direction = Pelota.DR;
					randomColor();
				}
				//System.out.println("Arriba Derecha");
				break;

			case Pelota.DL:

				this.x--;
				this.y++;
				if (this.x <= 0) {
					this.direction = Pelota.DR;
					randomColor();
				} else if (this.y + height >= bgHeight) {
					this.direction = Pelota.UL;
					randomColor();
				}
				//System.out.println("Abajo Izquierda");
				break;
		}
	}

	public void pintarPelota(Graphics g) {

		g.setColor(color);
		g.fillOval(x, y, width, height);
	}

}
