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
	private int radius;
	private int speed;
	private Color color;
	private Random r;
	private int direction;

	public Pelota(int radius, int speed, Color color) {

		this.x = 120 + r.nextInt(60);
		this.y = 120 + r.nextInt(60);
		this.radius = radius;
		this.speed = speed;
		this.color = color;
	}

	public void mover() {

		switch (this.direction) {

			case Pelota.DR:

				this.y--;
				this.x++;

				if (this.y <= 300) {
					this.direction = Pelota.UR;
				}else if (this.x + height >= 300) {
					this.direction = Pelota.DL;
				}
				//System.out.println("Arriba");
				break;

			case Pelota.UL:

				this.y++;
				this.x--;

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

				if (this.x >= 300) {
					this.direction = Pelota.UL;
				}else if (this.y >= 300) {
					this.direction = Pelota.DR;
				}
				//System.out.println("Izquierda");
				break;

			case Mondrian2.Rectangulo.DERECHA:

				this.x++;
				if (this.x >= this.limitXR) {
					this.direction = Mondrian2.Rectangulo.ABAJO;
				}
				//System.out.println(x);
				break;
		}
	}

}
