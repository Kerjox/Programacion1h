import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JApplet {

	private Dimension dim;
	private Image image;
	private Graphics renderBuffer;
	private Tablero tablero;
	private Rectangle botonJugar;

	@Override
	public void init() {

		dim = new Dimension(800, 600);
		image = createImage(dim.width, dim.height);
		renderBuffer = image.getGraphics();
		tablero = new Tablero();
		botonJugar = new Rectangle(560, 20, 100, 30);

		initListeners();
	}

	@Override
	public void start() {

		resize(dim);
	}

	@Override
	public void paint(Graphics g) {

		renderBuffer.setColor(Color.WHITE);
		renderBuffer.fillRect(0, 0, dim.width, dim.height);
		tablero.paintClavosIniciales(renderBuffer);
		tablero.paintSlotsJugador(renderBuffer);
		tablero.paintSlotMaquina(renderBuffer);
		tablero.paintSlotsSoluciones(renderBuffer);
		paintButton(renderBuffer);
		tablero.paintClavoPulsado(renderBuffer);
		g.drawImage(image, 0, 0, dim.width, dim.height, this);
	}

	private void paintButton(Graphics g) {

		g.setColor(Color.RED);
		g.fillRect(botonJugar.x, botonJugar.y, botonJugar.width, botonJugar.height);
		g.setColor(Color.WHITE);
		g.drawString("Jugar", botonJugar.x + 40, botonJugar.y + 15);
	}


	private void initListeners() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				if (botonJugar.contains(e.getPoint())) {

					tablero.jugar();
				} else {

					tablero.clavoPulsado(e.getPoint());
				}

				repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {

				tablero.mouseSoltado();
				repaint();
			}
		});

		addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {

				tablero.moveClavo(e.getPoint());
				repaint();
			}
		});
	}

}
