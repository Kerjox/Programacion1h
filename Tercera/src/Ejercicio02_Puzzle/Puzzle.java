package Ejercicio02_Puzzle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Puzzle {

	private Piezas[][] piezas;
	private Image puzzleImage;

	public Puzzle() {

		loadPiezas();
		loadPuzzleImage();
	}

	private void loadPiezas() {

		piezas = new Piezas[5][5];

		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 5; j++) {

				piezas[i][j] = new Piezas(i * 5 + j);
			}
		}

	}

	private void loadPuzzleImage() {

		try {
			puzzleImage = ImageIO.read(getClass().getResource("img/mapamundi3.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {

		for (Piezas[] piezas : piezas) {

			for (Piezas pieza : piezas) {

				pieza.paint(g);
			}
		}
	}

	public void paintImagePuzzle(Graphics g) {

		g.drawImage(puzzleImage, 50, 100, null);
	}

	public void paintGrid(Graphics g) {

		g.setColor(Color.GREEN);
		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 5; j++) {

				g.drawRect(50 + (i * 60), 100 + (j * 60), 60, 60);
			}
		}
	}

	public Piezas getObjectClicked(Point p) {

		for (Piezas[] piezas : piezas) {

			for (Piezas pieza : piezas) {

				if (pieza.contains(p)) {

					return pieza;
				}
			}
		}

		return null;
	}

	public void checkCorrectPosition(Piezas pieza) {

		if (pieza == null) return;

		int index = pieza.getIndex();

		Point correctPosition = getCorrectPoints(index);

		if (pieza.contains(correctPosition)) {

			pieza.setPos(correctPosition);
			pieza.setColocada(true);
			//System.out.println("Posicion correcta");
		}
	}

	private Point getCorrectPoints(int i) {

		int x = 60 * (i % 5) + 30 + 50;
		int y = 60 * (i / 5) + 30 + 100;

		//System.out.printf("%d %d \n", x, y);

		return new Point(x, y);
	}
}
