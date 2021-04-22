package BlackJack;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Card {

	private final Image img;
	private final Integer value;
	private boolean visible;

	public void setVisible(boolean visible) {

		this.visible = visible;
	}

	public boolean isVisible() {

		return this.visible;
	}

	public Card(Integer value, String palo) {

		this.img = getImage(value, palo);
		this.value = value > 10 ? 10 : value;
		this.visible = true;
	}

	public Integer getValue() {

		return value;
	}

	private Image getImage(Integer value, String palo) {

		try {
			return ImageIO.read(getClass().getResource("./Cartas/" + value + "_of_" + palo + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void paint(Graphics g, int x, int y) {

		g.drawImage(this.img, x, y, 120, 200, null);
	}

	public void paint(Image img, Graphics g, int x, int y) {

		g.drawImage(img, x, y, 120, 200, null);
	}

}
