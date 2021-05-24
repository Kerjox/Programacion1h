import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Jugador extends Rectangle implements Runnable {

	public static final int GUERRILLERO = 0;
	public static final int GANSTER = 1;
	public static final int LUKE = 2;

	public static final int UP = 0;
	public static final int RIGHT = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;

	private int type;
	private List<Image> images;
	private Thread animation;
	private int imageIndex;
	private List<Bullet> bullets;

	public Jugador(int type, int x, int y, int width, int height, List<Image> images) {

		this.type = type;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.images = images;

		this.animation = new Thread(this::run);
		this.animation.start();
	}

	@Override
	public void run() {

		do {

			delay(100);
			animation();
		} while(true);
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void animation() {

		if (imageIndex == 3) {

			imageIndex = 0;
		} else imageIndex++;
	}

	public void paint(Graphics g) {

		g.drawImage(images.get(imageIndex), this.x, this.y, this.width, this.height, null);
	}

	public void move(int direction) {

		switch (direction) {

			case UP:

				y -= 2;
				break;

			case RIGHT:

				x += 2;
				break;

			case DOWN:

				y += 2;
				break;

			case LEFT:

				x -= 2;
				break;
		}
	}

	public void shoot() {

		if (bullets == null) {

			bullets = new ArrayList<>();
		}

		bullets.add(new Bullet(x + width, y + 35));
	}

	public void paintBullets(Graphics g) {

		if (bulletsAreEmpty()) return;
		for (Bullet bullet : bullets) {

			bullet.paint(g);
		}
	}

	public void moveBullets(Dimension dim) {

		if (bulletsAreEmpty()) return;

		List<Bullet> newBullets = new ArrayList<>(bullets);

		for (Bullet bullet : newBullets) {

			if (bullet.getX() >= dim.width - 60) {

				Game.makeExplosion( (int) bullet.getX(), (int) bullet.getY());
				bullets.remove(bullet);
			} else {

				bullet.move();
			}
		}
	}

	private boolean bulletsAreEmpty() {

		return bullets == null || bullets.size() == 0;
	}

}
