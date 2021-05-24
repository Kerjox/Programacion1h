import java.awt.*;
import java.util.List;

public class Explosion implements Runnable {

	private Thread animation;
	private List<Image> images;
	private int indexImage;
	private int x;
	private int y;

	public Explosion(int x, int y, List<Image> explosionsImages) {

		animation = new Thread(this::run);
		this.x = x;
		this.y = y;
		indexImage = 0;
		images = explosionsImages;
		animation.start();
	}

	@Override
	public void run() {

		do{

			delay(100);
			animation();
		} while (true);
	}

	private void animation() {

		indexImage++;
	}

	public boolean paint(Graphics g) {

		g.drawImage(images.get(indexImage), x, y, 40, 40, null);

		return indexImage == 14;
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
