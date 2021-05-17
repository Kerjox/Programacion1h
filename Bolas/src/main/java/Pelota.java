import java.awt.*;

public class Pelota extends Rectangle {

	private int color;
	private final Image img;

	public Pelota(Image img) {

		this.width = this.height = 30;
		this.img = img;
	}

	public void paint(Graphics g, int x, int y) {

		this.x = x;
		this.y = y;
		g.drawImage(this.img, this.x, this.y, this.width, this.height, null);
	}

	public void setX(int x) {

		this.x = x;
	}

	public void setY(int y) {

		this.y = y;
	}

}
