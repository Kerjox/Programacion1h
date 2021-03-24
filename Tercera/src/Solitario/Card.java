package Solitario;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Card extends Rectangle {

	private static final int BLACK = 1;
	private static final int COREZONES = 2;
	private static final int PICAS = 3;
	private static final int RED = 0;
	private static final int ROMBOS = 1;
	private static final int TREBOLES = 0;
	private final Image imageBack;
	private int color;
	private int family;
	private boolean hidden;
	private Image img;
	public Card(int index, Image imageBack) {

		getFamilyAndColor(index);
		loadImage(index);
		this.width = 100;
		this.height = 150;
		this.imageBack = imageBack;
		this.hidden = false;
	}

	public boolean isHidden() {

		return hidden;
	}

	public void setHidden(boolean hidden) {

		this.hidden = hidden;
	}

	public int getColor() {

		return this.color;
	}

	public int getFamily() {

		return this.family;
	}

	private void loadImage(int index) {

		//System.out.println(index);
		try {
			this.img = ImageIO.read(getClass().getResource("./cards/" + index + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics g, int x, int y) {

		if (this.hidden) {

			g.drawImage(this.imageBack, x, y, this.width, this.height, null);
		} else {

			g.drawImage(this.img, x, y, this.width, this.height, null);
		}
	}

	private void getFamilyAndColor(int index) {

		if (index <= 13) {

			this.family = ROMBOS;
			this.color = RED;
		} else if (index <= 26) {

			this.family = PICAS;
			this.color = BLACK;
		} else if (index <= 39) {

			this.family = COREZONES;
			this.color = RED;
		} else {

			this.family = TREBOLES;
			this.color = BLACK;
		}
	}

}
