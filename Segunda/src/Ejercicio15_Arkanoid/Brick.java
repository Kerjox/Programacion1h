package Ejercicio15_Arkanoid;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Brick extends Rectangle {

	public static final Color RED = Color.RED;
	public static final Color YELLOW = Color.YELLOW;
	public static final Color GREEN = Color.GREEN;
	public static final Color BLUE = Color.BLUE;
	private Color color;


	public Brick(int x, int y, int width, int height, Color color) {

		super(x, y, width, height);
		this.color = color;
	}

	public void pintar(Graphics g) {

		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
	}

}

class raqueta extends Brick{

	public raqueta(int x, int y, int width, int height, Color color) {

		super(x, y, width, height, color);
		mouseMove();

	}

	private void mouseMove() {

		MouseMotionAdapter mover = new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {


			}
		};

	}

}
