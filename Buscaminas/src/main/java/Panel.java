import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Panel {

	private final Dimension posPanel;
	private Dimension dimension;
	private List<List<Box>> boxes;
	private final int numBombs = 10;
	private Image bombImg, boxImg;

	public Panel() {

		this.posPanel = new Dimension(80, 120);
		this.dimension = new Dimension(10, 10);
		initImages();
		this.boxes = initBoxes();
		plantBombs();
		initBombsAround();

		/*
		for (List<Box> list : this.boxes) {

			System.out.println("");

			for (Box box : list) {

				System.out.printf("%d, ", box.getBombsAround());
			}
		}*/
	}

	private void initBombsAround() {

		for (int i = 0; i < this.dimension.width; i++) {

			for (int j = 0; j < this.dimension.height; j++) {

				int bombsAround = findBombsAround(j, i);
				this.boxes.get(j).get(i).setBombsAround(bombsAround);
			}
		}
	}

	private void plantBombs() {

		int cont = 0;

		while (cont <= this.numBombs) {

			int x = (int) (Math.random() * 10);
			int y = (int) (Math.random() * 10);

			Box box = this.boxes.get(x).get(y);
			if (!box.isBomb()) {

				box.setBomb(true);
				cont++;
			}
		}
	}

	private void initImages() {

		try {

			this.bombImg = ImageIO.read(Panel.class.getClassLoader().getResource("mina.png"));
			this.boxImg = ImageIO.read(Panel.class.getClassLoader().getResource("casilla.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private List<List<Box>> initBoxes() {

		List<List<Box>> boxes = new ArrayList<>();

		for (int i = 0; i < this.dimension.width; i++) {

			boxes.add(new ArrayList<>());

			for (int j = 0; j < this.dimension.width; j++) {

				boxes.get(i).add(new Box(this.bombImg, this.boxImg));
			}
		}

		return boxes;
	}

	public void paintPanel(Graphics g) {

		for (int i = 0, x = this.posPanel.width; i < this.dimension.width; i++, x += Box.DIMENSION.width) {

			for (int j = 0, y = this.posPanel.height; j < this.dimension.height; j++, y += Box.DIMENSION.height) {

				this.boxes.get(i).get(j).paint(g, x, y);
			}
		}
	}

	public void paintGrid(Graphics g) {

		g.setColor(Color.red);

		for (int i = 0, x = this.posPanel.width; i < this.dimension.width; i++, x += Box.DIMENSION.width) {

			for (int j = 0, y = this.posPanel.height; j < this.dimension.height; j++, y += Box.DIMENSION.height) {

				g.drawRect(x, y, Box.DIMENSION.width, Box.DIMENSION.height);
			}
		}
	}

	public void boxPressed(Point point) {

		for (int i = 0; i < this.boxes.size(); i++) {

			for (int y = 0; y < this.boxes.get(i).size(); y++) {

				Box box = this.boxes.get(i).get(y);

				if (box.contains(point)) {

					if (box.isBomb()) {

						showBombs();
					} else {

						box.setVisible(true);
						if (box.getBombsAround() == 0) {

							openPanel(i, y);
						}
					}
				}
			}
		}
	}

	private void openPanel(int x, int y) {

		this.boxes.get(x).get(y).setVisible(true);
		//System.out.printf("%d, %d \n", x, y);

		if (canOpen(x + 1, y)) {

			openPanel(x + 1, y);
		}

		if (canOpen(x, y + 1)) {

			openPanel(x, y + 1);
		}

		if (canOpen(x - 1, y)) {

			openPanel(x - 1, y);
		}

		if (canOpen(x, y - 1)) {

			openPanel(x, y - 1);
		}
	}

	private boolean canOpen(int x, int y) {

		if (x < 0 || x > 9 || y < 0 || y > 9) return false;

		Box box = this.boxes.get(x).get(y);

		if (!box.isVisible()) {

			if (box.getBombsAround() == 0) {

				return true;
			} else {

				this.boxes.get(x).get(y).setVisible(true);
			}
		}

		return false;
	}

	private int findBombsAround(int i, int f) {

		if (this.boxes.get(i).get(f).isBomb()) {

			return -1;
		}

		int cont = 0;
		int x, y, finX, finY;

		if (i + 1 >= this.dimension.width) {

			x = i - 1;
			finX = i;
		} else if (i - 1 < 0) {

			x = i;
			finX = i + 1;
		} else {

			x = i - 1;
			finX = i + 1;
		}

		if (f + 1 >= this.dimension.height) {

			y = f - 1;
			finY = f;
		} else if (f - 1 < 0) {

			y = f;
			finY = f + 1;
		} else {

			y = f - 1;
			finY = f + 1;
		}

		for (int j = x; j <= finX; j++) {

			for (int k = y; k <= finY; k++) {

				if (this.boxes.get(j).get(k).isBomb()) {

					cont++;
				}
			}
		}

		return cont;
	}

	public void showBombs() {

		for (List<Box> box : this.boxes) {

			for (Box value : box) {

				if (value.isBomb()) {

					value.setVisible(true);
				}
			}
		}
	}

}
