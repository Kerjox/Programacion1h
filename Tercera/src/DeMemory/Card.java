package DeMemory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Card extends Rectangle {

	private Image img;

	public Integer getColor() {

		return color;
	}

	private Integer color;
	private boolean reversed;
	private Image backImage;

	public boolean isReversed() {

		return reversed;
	}

	public void setReversed(boolean reversed) {

		this.reversed = reversed;
	}

	public Card(Integer indexImg, Integer color, Image backImage) {

		this.width = this.height = 80;
		this.reversed = true;
		this.color = color;
		this.backImage = backImage;
		this.img = getImage(indexImg);
	}

	private Image getImage(Integer value) {

		try {
			return ImageIO.read(getClass().getResource("./images/img" + value + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void paint(Graphics g, int x, int y) {

		this.x = x;
		this.y = y;

		if (this.reversed) {

			g.drawImage(this.backImage, this.x, this.y, this.width, this.height, null);
		} else {

			g.drawImage(this.img, this.x, this.y, this.width, this.height, null);
		}
	}

}
