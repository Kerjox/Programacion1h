package Ejercicio15_Arkanoid;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class Brick extends Rectangle {

	protected Color color;
	private final Color[] colorLevels = {Color.BLUE, Color.GREEN, Color.YELLOW, Color.RED};
	private int level;

	public Brick(int x, int y, int width, int height, int level) {

		super(x, y, width, height);
		this.color = colorLevels[level - 1];
		this.level = level;
	}


	public Brick(int x, int y, int width, int height) {

		this(x, y, width, height, 1);
	}

	public void setColor(Color color) {

		this.color = color;
	}

	public void pintar(Graphics g) {

		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
	}

	public void removeBrick(ArrayList<Brick> bricks) {

		this.level--;
		if (this.level <= 0) {

			bricks.remove(this);
		} else {

			this.setColor(this.colorLevels[this.level - 1]);
		}
	}

}

class Raqueta extends Brick {

	public MouseMotionAdapter mover;
	private final Color color;

	public Raqueta(int x, int y, int width, int height, Color color) {

		super(x, y, width, height);
		this.color = color;
		mouseMove();

	}

	public void pintar(Graphics g) {

		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
	}

	public void mouseMove() {

		mover = new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {

				x = e.getX() - width / 2;
			}
		};

	}

}
