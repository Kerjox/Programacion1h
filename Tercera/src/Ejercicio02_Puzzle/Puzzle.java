package Ejercicio02_Puzzle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Puzzle extends Pieza{

	private static final int[][] coordsPiezas = {
			{30, 30}, {90, 30}, {150, 30}, {210, 30}, {270, 30},
			{30, 90}, {90, 90}, {150, 90}, {210, 90}, {270, 90},
			{30, 150}, {90, 150}, {150, 150}, {210, 150}, {270, 150},
			{30, 210}, {90, 210}, {150, 210}, {210, 210}, {270, 210},
			{30, 270}, {90, 270}, {150, 270}, {210, 270}, {270, 270}
	};
	private ArrayList<Pieza> piezasList;
	private Image puzzleImage;

	public int[][] getCoordsPiezas() {

		return coordsPiezas;
	}

	public Puzzle() {

		loadPiezas();
		loadPuzzleImage();
	}

	private void loadPuzzleImage() {

		try {
			puzzleImage = ImageIO.read(getClass().getResource("img/mapamundi3.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadPiezas() {

		piezasList = new ArrayList<>();

		for (int i = 1; i <= 25; i++) {

			piezasList.add(new Pieza(i));
		}
	}

	public void paint(Graphics g) {

		for (Pieza pieza : piezasList) {

			pieza.paint(g);
		}
	}

	public void paintImagePuzzle(Graphics g) {

		g.drawImage(puzzleImage, 50, 100, null);
	}

	public Pieza getObjectClicked(Point p) {

		for (Pieza pieza : piezasList) {

			if (pieza.contains(p)) {

				return pieza;
			}
		}

		return null;
	}

	public void moveToCorrectPosition(Pieza pieza) {

		if (pieza == null) return;

		int index = pieza.getIndex();
		System.out.println(index);

		int posX = coordsPiezas[index][0] + 50;
		int posY = coordsPiezas[index][1] + 100;

		if (pieza.contains(posX, posY)) {

			pieza.setPos(new Point(posX, posY));
			System.out.println("Posicion correcta");
		}
	}
}
