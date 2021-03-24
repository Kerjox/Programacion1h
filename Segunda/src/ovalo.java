import Ejercicio05.Ovalos1.Ovalo;
import Ejercicio23_GoogleRun.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ovalo extends Rectangle {

	public ovalo() {

		super(50, 50, 20, 40);
	}

	public void paint(Graphics g) {

		g.setColor(Color.YELLOW);
		g.fillOval(this.x, this.y, this.width, this.height);
	}

	public void moveByKeyboard(int key) {

		switch (key){

			case 38:        // Arriba

				break;

			case 39:        // Derecha

				this.x += 10;
				break;

			case 37:        // Izquierda

				this.x -= 10;
				break;

		}
	}

	public void jump() {

		this.y -= 1;
	}

	public void down() {

		this.y += 2;
	}

}
