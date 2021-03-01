package Ejercicio18_SpaceInvaders;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Ship {

	private int bullets;
	private int posX;
	private final int posY;
	private BufferedImage ship;

	public Ship() {

		try {
			this.ship = ImageIO.read(Ship.class.getResource("destroying.png"));
		} catch (
				IOException e) {
			e.printStackTrace();
		}

		this.posX = 200;
		this.posY = 370;

		this.bullets = 10;
	}

	public int getBullets() {

		return bullets;
	}

	public void setBullets(int bullets) {

		this.bullets = bullets;
	}

	public void move(int x) {

		if (x < SpaceInvaders.BGWIDTH - 56 && x > 0) {

			this.posX = x;
		}
	}

	public void paint(Graphics g) {

		g.drawImage(ship, this.posX, this.posY, null);
	}

}
