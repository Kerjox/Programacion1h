package DeMemory;

import javax.swing.*;
import java.awt.*;

public class Game extends JApplet implements Runnable{

	public Dimension dimension;
	private Thread game;
	private Image image;
	private Graphics renderBuffer;
	private Cards cards;

	@Override
	public void run() {

		while(true) {


			delay(10);
		}
	}

	@Override
	public void init() {

		this.dimension = new Dimension(800, 600);
		resize(this.dimension);
		this.game = new Thread(this);
		this.image = this.createImage(this.dimension.width, this.dimension.height);
		this.renderBuffer = this.image.getGraphics();
		this.cards = new Cards();
	}

	@Override
	public void paint(Graphics g) {

		this.renderBuffer.setColor(Color.BLACK);
		this.renderBuffer.fillRect(0, 0, this.dimension.width, this.dimension.height);
		this.cards.paint(this.renderBuffer);

		g.drawImage(image, 0, 0, this.dimension.width, this.dimension.height, this);

	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
