package Ruleta;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;

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

			this.casillas.get(0).add(new Casilla(o, 107, 31, 60, y, this.colors[0][i]));
		}

		for (int i = 0, o = 390, y = 2; i < 12; i++, o += 31, y += 3) {

			this.casillas.get(1).add(new Casilla(o, 168, 31, 60, y, this.colors[1][i]));
		}

		for (int i = 0, o = 390, y = 1; i < 12; i++, o += 31, y += 3) {

			this.casillas.get(2).add(new Casilla(o, 230, 31, 60, y, this.colors[2][i]));
		}

		for (int i = 0, o = 390; i < 12; i++, o += 31) {

			this.casillas.get(3).add(new Casilla(o, 98, 31, 10, Casilla.ALLCOLL));
		}

		for (int i = 0, o = 107; i < 3; i++, o += 60) {

			this.casillas.get(4).add(new Casilla(764, o, 31, 60, Casilla.ALLROW));
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

	public String getCasilla(Ficha ficha) {

		for (ArrayList<Casilla> arrayList : casillas) {

			for (Casilla casilla : arrayList) {

				if (casilla.intersects(ficha)) {

					return String.valueOf(casilla.getValue());
				}
			}
		}

		return null;
	}

}
