package Ejercicio03;


import java.awt.*;

public class Tablero {

	private Boton[][] botones;
	private Point blank;

	public Tablero() {

		this.botones = new Boton[5][5];
		loadBotones();
		mixBotones();
		this.blank = getBlank();
	}

	private void loadBotones() {

		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 5; j++) {

				int index = i * 5 + j + 1;
				if (index != 25) {

					this.botones[i][j] = new Boton(index);
				}
			}
		}
	}

	private Point getBlank() {

		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 5; j++) {

				if (this.botones[i][j] == null) {

					return new Point(j, i);
				}
			}
		}

		return null;
	}

	private void mixBotones() {

		for (int i = 0; i < 1000; i++) {

			int x = (int) (Math.random() * 5);
			int y = (int) (Math.random() * 5);

			int x2 = (int) (Math.random() * 5);
			int y2 = (int) (Math.random() * 5);

			Boton boton = this.botones[x][y];

			this.botones[x][y] = this.botones[x2][y2];
			this.botones[x2][y2] = boton;
		}
	}

	public boolean move(Point p) {

		Point desplazamiento, positionToMove;

		desplazamiento = new Point(delta(p.x, this.blank.x), delta(p.y, this.blank.y));

		if ((desplazamiento.x == 0) && (desplazamiento.y == 0)) { return false; }
		if ((desplazamiento.x != 0) && (desplazamiento.y != 0)) { return false; }

		positionToMove = new Point(p.x + desplazamiento.x, p.y + desplazamiento.y);

		if (!((this.blank.x == positionToMove.x) && (this.blank.y == positionToMove.y))){

			move(positionToMove);
		}

		this.botones[positionToMove.y][positionToMove.x] = this.botones[p.y][p.x];
		this.botones[p.y][p.x] = null;
		this.blank = p;

		return true;
	}

	private int delta(int a, int b) {

		if (a == b) return 0;
		else return ((b - a) / Math.abs(b - a));
	}

	public void paint(Graphics g) {

		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 5; j++) {

				if (this.botones[i][j] != null) {

					this.botones[i][j].paint(g, j * 80, i * 80);
				}
			}
		}
	}

	public boolean verify() {

		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 5; j++) {

				int index = i * 5 + j;
				if (index == 24) break;
				if (this.botones[i][j] == null || index != this.botones[i][j].getIndex() - 1) {

					return false;
				}
			}
		}

		return true;
	}

}
