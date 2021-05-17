import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JApplet implements Runnable{

	private Dimension dimension;
	private Thread game;
	private Tablero tablero;
	private Image image;
	private Graphics renderBuffer;

	@Override
	public void init() {

		dimension = new Dimension(600, 600);
		this.game = new Thread(this);
		this.tablero = new Tablero();
		this.image = createImage(this.dimension.width, this.dimension.height);
		this.renderBuffer = this.image.getGraphics();
		initListeners();
	}

	private void initListeners() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				tablero.pelotaTirada(e.getPoint());
			}
		});
	}

	@Override
	public void start() {

		resize(dimension.width, dimension.height);
		game.start();
	}

	@Override
	public void paint(Graphics g) {
		this.renderBuffer.setColor(Color.BLACK);
		this.renderBuffer.fillRect(0, 0, this.dimension.width, this.dimension.height);
		this.tablero.paintPelotasATirar(this.renderBuffer);
		this.tablero.paintNextPelotas(this.renderBuffer);
		this.tablero.paintPelotaTirada(this.renderBuffer);
		this.tablero.paintTableroPelotas(this.renderBuffer);
		g.drawImage(image, 0, 0, this.dimension.width, this.dimension.height, this);
	}

	@Override
	public void run() {

		do {

			this.tablero.movePelotaTirada();
			this.tablero.checkLimitPelotaTirada();

			repaint();
			delay(2);
		}while(true);
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
