package Solitario;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Card extends Rectangle {

	public static final int TREBOLES = 0;
	public static final int ROMBOS = 1;
	public static final int COREZONES = 2;
	public static final int PICAS = 3;
	private static final int BLACK = 1;
	private static final int RED = 0;
	private final Image imageBack;
	private final int index;
	private final int color;
	private final int family;
	private boolean hidden;
	private Image img;

	public Card(int index, int family, Image imageBack) {

		this.index = index;
		this.family = family;
		this.color = setColor();
		loadImage();
		this.width = 100;
		this.height = 150;
		this.imageBack = imageBack;
		this.hidden = false;
	}

	private int setColor() {

		switch (this.family) {

			case TREBOLES:

			case PICAS:

				return BLACK;

			case ROMBOS:

			case COREZONES:

				return RED;

			default:

				throw new UnsupportedOperationException();
		}
	}

	public boolean isHidden() {

		return hidden;
	}

	public void setHidden(boolean hidden) {

		this.hidden = hidden;
	}

	public int getIndex() {

		return this.index;
	}

	public int getColor() {

		return this.color;
	}

	public int getFamily() {

		return this.family;
	}

	private void loadImage() {

		int index = getIndexImage();

		try {
			this.img = ImageIO.read(getClass().getResource("./cards/" + index + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int getIndexImage() {

		switch (this.family) {

			case TREBOLES:

				return this.index;

			case ROMBOS:

				return this.index + 13;

			case COREZONES:

				return this.index + 26;

			case PICAS:

				return this.index + 39;

			default:

				throw new UnsupportedOperationException();
		}
	}

	public void paint(Graphics g, int x, int y) {

		this.x = x;
		this.y = y;

		if (this.hidden) {

			g.drawImage(this.imageBack, x, y, this.width, this.height, null);
		} else {

			g.drawImage(this.img, x, y, this.width, this.height, null);
		}
	}

}
