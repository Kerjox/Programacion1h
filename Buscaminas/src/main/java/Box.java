import java.awt.*;

public class Box extends Rectangle {

	public static final Dimension DIMENSION = new Dimension(40, 40);
	private final Image bombImg;
	private final Image boxImg;
	private boolean bomb;
	private int bombsAround;
	private boolean visible;
	public Box(Image bombImg, Image boxImg) {

		this.bomb = false;
		this.visible = false;
		this.bombImg = bombImg;
		this.boxImg = boxImg;
		this.width = DIMENSION.width;
		this.height = DIMENSION.height;
		this.bombsAround = 0;
	}

	public int getBombsAround() {

		return bombsAround;
	}

	public void setBombsAround(int bombsAround) {

		this.bombsAround = bombsAround;
	}

	public boolean isVisible() {

		return visible;
	}

	public void setVisible(boolean visible) {

		this.visible = visible;
	}

	public boolean isBomb() {

		return bomb;
	}

	public void setBomb(boolean bomb) {

		this.bomb = bomb;
	}


	public void paint(Graphics g, int x, int y) {

		this.x = x;
		this.y = y;

		if (this.visible) {
			if (this.bomb) {

				g.drawImage(this.bombImg, x, y, DIMENSION.width, DIMENSION.height, null);
			} else {

				g.setColor(Color.GRAY);
				g.fillRect(x, y, DIMENSION.width, DIMENSION.height);
				g.setColor(getColor(this.bombsAround));
				if (this.bombsAround > 0) {

					g.setFont(new Font("Arial", Font.BOLD, 25));
					g.drawString(String.valueOf(this.bombsAround), x + 12, y + 30);
				}
			}
		} else {

			g.drawImage(this.boxImg, x, y, DIMENSION.width, DIMENSION.height, null);
		}
	}

	private Color getColor(int n) {

		switch (n) {

			case 1:

				return new Color(5, 22, 71);
			case 2:

				return new Color(19, 85, 3);

			case 3:

				return new Color(187, 0, 0);

			case 4:

				return Color.BLUE;

			case 5:

				return Color.RED;

			default:

				return Color.BLACK;
		}
	}

}
