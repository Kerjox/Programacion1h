package Ruleta;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Tablero {

	private final boolean[][] colors = {
			{true, false, true, true, false, true, true, false, true, true, false, true},
			{false, true ,false, false, true, false, false, true, false, false ,true, false},
			{true, false, true, false, false, true, true, false, true, false, false, true}
	};
	private Image img;
	private ArrayList<ArrayList<Casilla>> casillas;

	public Tablero() {

		loadImage();
		initCasillas();
	}

	private void loadImage() {

		try {
			this.img = ImageIO.read(getClass().getResource("./img/mesa.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {

		g.drawImage(img, 0, 100, 800, 320, null);
	}

	private void initCasillas() {

		this.casillas = new ArrayList<>();

		for (int i = 0; i < 6; i++) {

			this.casillas.add(new ArrayList<>());
		}

		for (int i = 0, o = 390, y = 3; i < 12; i++, o += 31, y += 3) {

			this.casillas.get(0).add(new Casilla(o, 107, 31, 60, Casilla.NUMBER, y, this.colors[0][i]));
		}

		for (int i = 0, o = 390, y = 2; i < 12; i++, o += 31, y += 3) {

			this.casillas.get(1).add(new Casilla(o, 168, 31, 60, Casilla.NUMBER, y, this.colors[1][i]));
		}

		for (int i = 0, o = 390, y = 1; i < 12; i++, o += 31, y += 3) {

			this.casillas.get(2).add(new Casilla(o, 230, 31, 60, Casilla.NUMBER, y, this.colors[2][i]));
		}

		for (int i = 0, o = 390; i < 12; i++, o += 31) {

			this.casillas.get(3).add(new Casilla(o, 98, 31, 10, Casilla.ALLCOLL, i));
		}

		for (int i = 0, o = 107; i < 3; i++, o += 60) {

			this.casillas.get(4).add(new Casilla(764, o, 31, 60, Casilla.ALLROW, i));
		}

		this.casillas.get(5).add(new Casilla(390, 290, 125, 30, Casilla.FIRSTTWELVE));
		this.casillas.get(5).add(new Casilla(515, 290, 125, 30, Casilla.SECONDTWELVE));
		this.casillas.get(5).add(new Casilla(640, 290, 125, 30, Casilla.THIRDTWELVE));

		this.casillas.get(5).add(new Casilla(390, 320, 60, 31, Casilla.ONETOEIGHTEEN));
		this.casillas.get(5).add(new Casilla(453, 320, 60, 31, Casilla.PAR));
		this.casillas.get(5).add(new Casilla(516, 320, 60, 31, Casilla.REDS));
		this.casillas.get(5).add(new Casilla(578, 320, 60, 31, Casilla.BLACKS));
		this.casillas.get(5).add(new Casilla(641, 320, 60, 31, Casilla.IMPAR));
		this.casillas.get(5).add(new Casilla(702, 320, 60, 31, Casilla.NINETEENTOTHIRTYSIX));
	}

	public ArrayList<Casilla> getCasillasApostadas(Ficha ficha) {

		ArrayList<Casilla> casillasApostadas = new ArrayList<>();

		checkColls(ficha, casillasApostadas);

		if (casillasApostadas.size() > 0) return casillasApostadas;

		checkRows(ficha, casillasApostadas);

		if (casillasApostadas.size() > 0) return casillasApostadas;

		checkSpecial(ficha, casillasApostadas);

		if (casillasApostadas.size() > 0) return casillasApostadas;

		getIndividualNumbers(ficha, casillasApostadas);

		if (casillasApostadas.size() > 0) return casillasApostadas;

		return null;
	}

	private void getIndividualNumbers(Ficha ficha, ArrayList<Casilla> casillasApostadas) {

		for (int i = 0; i < 3; i++) {

			for (Casilla casilla : this.casillas.get(i)) {

				if (casilla.intersects(ficha)) {

					casillasApostadas.add(casilla);
				}
			}
		}
	}

	private void checkSpecial(Ficha ficha, ArrayList<Casilla> casillasApostadas) {

		for (Casilla casilla : this.casillas.get(5)) {

			if (casilla.intersects(ficha)) {

				getCasillas(casillasApostadas, casilla.getType());
			}
		}
	}

	private void checkRows(Ficha ficha, ArrayList<Casilla> casillasApostadas) {

		for (Casilla casilla : this.casillas.get(4)) {

			if (casilla.intersects(ficha)) {

				int index = casilla.getValue();
				for (int i = 0; i < 12; i++) {

					casillasApostadas.add(this.casillas.get(index).get(i));
				}
			}
		}
	}

	private void checkColls(Ficha ficha, ArrayList<Casilla> casillasApostadas) {

		for (Casilla casilla : this.casillas.get(3)) {

			if (casilla.intersects(ficha)) {

				int index = casilla.getValue();
				for (int i = 0; i < 3; i++) {

					casillasApostadas.add(this.casillas.get(i).get(index));
				}
			}
		}
	}

	private void getCasillas(ArrayList<Casilla> casillasApostadas, int type) {

		switch (type) {

			case Casilla.FIRSTTWELVE:

				getNumbers(casillasApostadas, 0, 4);
				break;

			case Casilla.SECONDTWELVE:

				getNumbers(casillasApostadas, 4, 8);
				break;

			case Casilla.THIRDTWELVE:

				getNumbers(casillasApostadas, 8, 12);
				break;

			case Casilla.ONETOEIGHTEEN:

				getNumbers(casillasApostadas, 0, 6);
				break;

			case Casilla.NINETEENTOTHIRTYSIX:

				getNumbers(casillasApostadas, 6, 12);
				break;

			case Casilla.PAR:

				getNumbers(casillasApostadas, Casilla.PAR);
				break;

			case Casilla.IMPAR:

				getNumbers(casillasApostadas, Casilla.IMPAR);
				break;

			case Casilla.REDS:

				getNumbers(casillasApostadas, Casilla.REDS);
				break;

			case Casilla.BLACKS:

				getNumbers(casillasApostadas, Casilla.BLACKS);
				break;
		}
	}

	private void getNumbers(ArrayList<Casilla> casillasApostadas, int from, int to) {

		for (int i = 0; i < 3; i++) {

			for (int j = from; j < to; j++) {

				casillasApostadas.add(this.casillas.get(i).get(j));
			}
		}
	}

	private void getNumbers(ArrayList<Casilla> casillasApostadas, int type) {

		switch (type) {

			case Casilla.PAR:
			case Casilla.IMPAR:

				for (int i = 0; i < 3; i++) {

					for (Casilla casilla : this.casillas.get(i)) {

						if (type != Casilla.PAR && casilla.getValue() % 2 > 0) {

							casillasApostadas.add(casilla);
						} else if (type == Casilla.PAR && casilla.getValue() % 2 == 0) {

							casillasApostadas.add(casilla);
						}
					}
				}
				break;

			case Casilla.REDS:
			case Casilla.BLACKS:

				for (int i = 0; i < 3; i++) {

					for (Casilla casilla : this.casillas.get(i)) {

						if (type == Casilla.REDS && casilla.isRed()) {

							casillasApostadas.add(casilla);
						} else if (type != Casilla.REDS && !casilla.isRed()) {

							casillasApostadas.add(casilla);
						}
					}
				}
				break;
		}
	}

}
