package Ejercicio02_Puzzle;

import java.awt.*;
import java.util.ArrayList;

public class Puzzle {

	private ArrayList<Pieza> piezasList;

	public Puzzle() {

		loadPiezas();
	}

	private void loadPiezas() {

		piezasList = new ArrayList<>();

		for (int i = 1; i < 25; i++) {

			piezasList.add(new Pieza(i));
		}
	}

	public void paint(Graphics g) {

		for (Pieza pieza : piezasList) {

			pieza.paint(g);
		}
	}

	public Pieza getObjectClicked(Point p) {

		for (Pieza pieza : piezasList) {

			if (pieza.contains(p)) {

				return pieza;
			}
		}

		return null;
	}
}
