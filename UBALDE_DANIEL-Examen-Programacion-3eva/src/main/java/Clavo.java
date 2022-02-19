import java.awt.*;

public class Clavo extends Rectangle {

	private int color;
	private final Image img;

	public Clavo(Clavo clavo) {

		this.img = clavo.img;
		this.x = clavo.x;
		this.y = clavo.y;
		this.width = this.height = 30;
		this.color = clavo.color;
	}

	public Clavo(Image img) {

		this.img = img;
		this.width = this.height = 30;
	}

	public Clavo(Image img, int color) {

		this.img = img;
		this.width = this.height = 30;
		this.color = color;
	}

	public Clavo(Image img, int x, int y, int color) {

		this.img = img;
		this.x = x;
		this.y = y;
		this.width = this.height = 30;
		this.color = color;
	}

	public int getColor() {

		return color;
	}

	public void move(Point p) {

		this.x = p.x - 15;
		this.y = p.y - 15;
	}

	public void paint(Graphics g) {

		g.drawImage(img, x, y, width, height, null);
	}

	public void paint(Graphics g, int x, int y) {

		this.x = x;
		this.y = y;
		g.drawImage(img, x, y, width, height, null);
	}

}
