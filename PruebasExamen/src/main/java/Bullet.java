import java.awt.*;

public class Bullet extends Rectangle {

	private int vel = 2;

	public Bullet(int x, int y) {

		this.x = x;
		this.y = y;
	}

	public void paint(Graphics g) {

		g.setColor(Color.WHITE);
		g.fillRect(x, y, 10, 3);
	}

	public void move() {

		x += vel;
	}

}
