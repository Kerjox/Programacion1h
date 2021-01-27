package Ejercicio11_Dibujar;

import java.awt.*;

public class DosPuntos {

	public static final int LINEA = 1;
	public static final int OVALO = 0;
	public static final int RECTANGULO = 2;
	private int inicioX, inicioY, finX, finY, tipo;
	private Color color;

	public DosPuntos() {

		this(0, 0, LINEA, Color.WHITE);
	}

	public DosPuntos(int inicioX, int inicioY, int tipo, Color color) {

		this(inicioX, inicioY, inicioX, inicioY, tipo, color);
	}

	public DosPuntos(int inicioX, int inicioY, int finX, int finY, int tipo, Color color) {

		this.inicioX = inicioX;
		this.inicioY = inicioY;
		this.finX = finX;
		this.finY = finY;
		this.tipo = tipo;
		this.color = color;
	}

	public int getInicioX() {

		return inicioX;
	}

	public void setInicioX(int inicioX) {

		this.inicioX = inicioX;
	}

	public int getInicioY() {

		return inicioY;
	}

	public void setInicioY(int inicioY) {

		this.inicioY = inicioY;
	}

	public int getFinX() {

		return finX;
	}

	public void setFinX(int finX) {

		this.finX = finX;
	}

	public int getFinY() {

		return finY;
	}

	public void setFinY(int finY) {

		this.finY = finY;
	}

	public int getTipo() {

		return tipo;
	}

	public void setTipo(int tipo) {

		this.tipo = tipo;
	}

	public void pintar(Graphics g) {

		int anchura = Math.abs(finX - inicioX);
		int altura = Math.abs(finY - inicioY);
		g.setColor(color);

		switch (this.tipo) {

			case OVALO:

				g.fillOval(inicioX, inicioY, anchura, altura);
				break;

			case LINEA:

				g.drawLine(inicioX, inicioY, finX, finY);
				break;

			case RECTANGULO:

				g.fillRect(inicioX, inicioY, anchura, altura);
				break;
		}
	}

}
