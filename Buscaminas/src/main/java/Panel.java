import exceptions.BombsRebaseNumberOfBoxesException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Panel {

	protected Image bombImg, boxImg;
	protected List<List<Box>> boxes;
	protected Dimension dimension;
	protected int numBombs = 50;
	protected Dimension posPanel;

	public Panel() {

	}

	public Panel(int posX, int posY, int casX, int casY) {

		this.posPanel = new Dimension(posX, posY);
		this.dimension = new Dimension(casX, casY);

		initImages();
		initBoxes();
		initBombs();
		initBombsAround();

		/*
		for (List<Box> list : this.boxes) {

			System.out.println("");

			for (Box box : list) {

				System.out.printf("%d, ", box.getBombsAround());
			}
		}*/
	}

	public Dimension getDimension() {

		return dimension;
	}

	public void setDimension(Dimension dimension) {

		this.dimension = dimension;
	}

	public Dimension getPosPanel() {

		return posPanel;
	}

	public void setPosPanel(Dimension posPanel) {

		this.posPanel = posPanel;
	}

	public List<List<Box>> getBoxes() {

		return boxes;
	}

	public void setBoxes(List<List<Box>> boxes) {

		this.boxes = boxes;
	}

	protected void initBombs() {

		try {
			plantBombs();
		} catch (BombsRebaseNumberOfBoxesException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void setNumBombs(int numBombs) {

		this.numBombs = numBombs;
	}

	protected void initBombsAround() {

		for (int i = 0; i < this.dimension.width; i++) {

			for (int j = 0; j < this.dimension.height; j++) {

				int bombsAround = findBombsAround(j, i);
				this.boxes.get(j).get(i).setBombsAround(bombsAround);
			}
		}
	}

	protected void plantBombs() throws BombsRebaseNumberOfBoxesException {

		if (this.numBombs > this.dimension.width * this.dimension.height) {

			throw new BombsRebaseNumberOfBoxesException();
		}

		int cont = 0;

		while (cont < this.numBombs) {

			int x = (int) (Math.random() * this.dimension.width);
			int y = (int) (Math.random() * this.dimension.height);

			Box box = this.boxes.get(x).get(y);
			if (! box.isBomb()) {

				box.setBomb(true);
				cont++;
			}
		}
	}

	protected void initImages() {

		try {

			this.bombImg = ImageIO.read(Panel.class.getClassLoader().getResource("mina.png"));
			this.boxImg = ImageIO.read(Panel.class.getClassLoader().getResource("casilla.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	protected void initBoxes() {

		this.boxes = new ArrayList<>();

		for (int i = 0; i < this.dimension.width; i++) {

			this.boxes.add(new ArrayList<>());

			for (int j = 0; j < this.dimension.width; j++) {

				this.boxes.get(i).add(new Box(this.bombImg, this.boxImg));
			}
		}
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

	public boolean boxPressed(Point point) {

		for (int i = 0; i < this.boxes.size(); i++) {

			for (int y = 0; y < this.boxes.get(i).size(); y++) {

				Box box = this.boxes.get(i).get(y);

				if (box.contains(point)) {

					if (! box.isMarked()) {

						if (box.isBomb()) {

							showBombs();

							return true;
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

		return false;
	}

	protected void openPanel(int x, int y) {

		this.boxes.get(x).get(y).setVisible(true);
		open(x, y);
	}

	protected void open(int x, int y) {

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

	protected boolean canOpen(int x, int y) {

		if (isBoxOnLimits(x, y)) return false;

		Box box = this.boxes.get(x).get(y);

		if (! box.isVisible()) {

			if (box.getBombsAround() == 0) {

				return true;
			} else {

				box.setVisible(true);
				return false;
			}
		} else {

			return false;
		}

	}

	protected boolean isBoxOnLimits(int x, int y) {

		return x < 0 || x > this.dimension.width - 1 || y < 0 || y > this.dimension.height - 1;
	}

	protected int findBombsAround(int i, int f) {

		if (isBomb(i, f)) {

			return - 1;
		}

		int x = checkLimit(i, false);
		int y = checkLimit(f, false);
		int finX = checkLimit(i, true);
		int finY = checkLimit(f, true);

		int cont = 0;

		for (int j = x; j <= finX; j++) {

			for (int k = y; k <= finY; k++) {

				if (isBomb(j, k)) {

					cont++;
				}
			}
		}

		return cont;
	}

	protected boolean isBomb(int i, int f) {

		return this.boxes.get(i).get(f).isBomb();
	}

	protected int checkLimit(int o, boolean fin) {

		int out;

		if (o + 1 >= this.dimension.width) {

			out = fin ? o : o - 1;
		} else if (o - 1 < 0) {

			out = fin ? o + 1 : o;
		} else {

			out = fin ? o + 1 : o - 1;
		}

		return out;
	}

	public void showBombs() {

		for (List<Box> boxes : this.boxes) {

			for (Box box : boxes) {

				if (box.isBomb()) {

					box.setVisible(true);
				}
			}
		}
	}

	public void toggleMark(Point point) {

		for (List<Box> boxList : this.boxes) {

			for (Box box : boxList) {

				if (box.contains(point)) {

					box.setMarked(! box.isMarked());
				}
			}
		}
	}

}
