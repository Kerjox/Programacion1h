package Ejercicio13_Mondrian;


import javax.swing.*;
import java.awt.*;

public class Mondrian2 extends JApplet implements Runnable {

	private final Color[] coloresRectangulos = {
			Color.YELLOW,
			Color.YELLOW,
			Color.YELLOW,
			Color.BLUE,
			Color.BLUE,
			Color.LIGHT_GRAY,
			Color.RED,
			Color.RED,
			Color.MAGENTA};
	private Thread animation;
	private Rectangulo[] arrayRectangulos;
	private Image image;
	private final int[][] rectangulos = {
			{0, 0, 90, 90},
			{250, 0, 40, 190},
			{80, 110, 100, 20},
			{80, 200, 220, 90},
			{100, 10, 90, 80},
			{50, 140, 120, 45},
			{200, 0, 45, 45},
			{0, 100, 45, 200},
			{200, 55, 50, 135}};
	private Graphics renderBuffer;

	static class Rectangulo {

		private final int width;
		private final Color color;
		private final int height;
		private int x;
		private int y;
		private static final int ABAJO = 1;
		private static final int ARRIBA = 0;
		private static final int DERECHA = 3;
		private static final int IZQUIERDA = 2;
		private int direction = Rectangulo.DERECHA;
		private final int limitXR, limitYU, limitXL, limitYD;

		public Rectangulo(int x, int y, int width, int height, Color color) {

			this.x = this.limitXL = x;
			this.y = this.limitYD = y;
			this.width = width;
			this.height = height;
			this.color = color;
			this.limitXR = x + 25;
			this.limitYU = y + 10;
		}

		public void paintRect(Graphics g) {

			g.setColor(color);
			g.fillRect(x, y, width, height);
		}

		public void mover() {

			switch (this.direction) {

				case Rectangulo.ARRIBA:

					this.y--;

					if (this.y <= this.limitYD) {
						this.direction = Rectangulo.DERECHA;
					}
					//System.out.println("Arriba");
					break;

				case Rectangulo.ABAJO:

					this.y++;

					if (this.y >= this.limitYU) {
						this.direction = Rectangulo.IZQUIERDA;
					}
					//System.out.println("Abajo");
					break;

				case Rectangulo.IZQUIERDA:

					this.x--;

					if (this.x <= this.limitXL) {
						this.direction = Rectangulo.ARRIBA;
					}
					//System.out.println("Izquierda");
					break;

				case Rectangulo.DERECHA:

					this.x++;
					if (this.x >= this.limitXR) {
						this.direction = Rectangulo.ABAJO;
					}
					//System.out.println(x);
					break;
			}
		}

	}

	@Override
	public void init() {

		super.init();
		image = this.createImage(300, 300);
		renderBuffer = image.getGraphics();
		arrayRectangulos = new Rectangulo[9];
		initRectangulos();
	}

	private void initRectangulos() {

		for (int i = 0; i < rectangulos.length; i++) {

			for (int j = 0; j < rectangulos[0].length; j++) {

				arrayRectangulos[i] = new Rectangulo(rectangulos[i][0], rectangulos[i][1], rectangulos[i][2], rectangulos[i][3], coloresRectangulos[i]);
			}
		}
	}

	@Override
	public void start() {

		super.start();
		animation = new Thread(this);
		animation.start();
	}

	@Override
	public void paint(Graphics g) {

		renderBuffer.setColor(Color.WHITE);
		renderBuffer.fillRect(0, 0, 300, 300);
		for (int i = 0; i < arrayRectangulos.length; i++) {

			arrayRectangulos[i].paintRect(renderBuffer);
		}

		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void update(Graphics g) {

		paint(g);

	}

	@Override
	public void run() {

		do {
			moverRectangulos();
			delay(100);
			repaint();

		} while (true);
	}

	private void moverRectangulos() {

		for (int i = 0; i < arrayRectangulos.length; i++) {

			arrayRectangulos[i].mover();
		}
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
