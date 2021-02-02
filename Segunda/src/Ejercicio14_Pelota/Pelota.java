package Ejercicio14_Pelota;

import Ejercicio13_Mondrian.Mondrian2;

import java.awt.*;
import java.util.Random;

public class Pelota {

	public static final int DR = 0;
	public static final int DL = 1;
	public static final int UL = 2;
	public static final int UR = 3;
	private int x, y;
	private int width = 20, height = 20;
	private int speed;
	private Color color;
	private Random r = new Random();
	private int direction;

	public Pelota(int radius, Color color) {

		this.x = r.nextInt(300);
		this.y = r.nextInt(300);
		this.width = this.height = radius * 2;
		this.color = color;
	}

	public void mover() {

		switch (this.direction) {

			case Pelota.DR:

				this.x++;
				this.y--;

				if (this.y + height <= 300) {
					this.direction = Pelota.UR;
				}else if (this.x + width >= 300) {
					this.direction = Pelota.DL;
				}
				//System.out.println("Arriba");
				break;

			case Pelota.UL:

				this.x--;
				this.y++;

				if (this.y >= 0) {
					this.direction = Pelota.DL;
				}else if (this.x <= 0) {
					this.direction = Pelota.UR;
				}
				//System.out.println("Abajo");
				break;

			case Pelota.UR:

				this.x++;
				this.y++;

				if (this.x + width >= 300) {
					this.direction = Pelota.UL;
				}else if (this.y >= 300) {
					this.direction = Pelota.DR;
				}
				//System.out.println("Izquierda");
				break;

			case Pelota.DL:

				this.x--;
				this.y--;
				if (this.x <= 0) {
					this.direction = Pelota.DR;
				}else if (this.y <= 0) {
					this.direction = Pelota.UR;
				}
				//System.out.println(x);
				break;
		}
	}

	public void pintarPelota(Graphics g) {

		g.setColor(color);
		g.fillOval(x, y, width, height);
	}

}
