package Ejercicio03;

import java.awt.*;

public class Tablero {

	private Boton[][] botones;

	public Tablero() {

		this.botones = new Boton[5][5];
		loadBotones();
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

	public void move(Point p) {

		Boton botonToMove = null;

		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 4; j++) {

				if (this.botones[i][j].contains(p)) {

					botonToMove = this.botones[i][j];

					for (int k = 0; k < 5; k++) {

						for (int l = 0; l < 5; l++) {

							if (this.botones[k][l] == null) {

								this.botones[k][l] = botonToMove;
								this.botones[i][j] = null;
							}
						}
					}

					return;
				}
			}
		}
	}

	public void paint(Graphics g) {

		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 5; j++) {

				if (this.botones[i][j] != null) {

					this.botones[i][j].paint(g, j * Boton.SIZE, i * Boton.SIZE);
				}
			}
		}
	}
}
