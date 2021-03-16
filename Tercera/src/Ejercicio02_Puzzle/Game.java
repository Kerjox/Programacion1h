package Ejercicio02_Puzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JApplet {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	private Image image;
	private Graphics renderBuffer;
	private Puzzle puzzle;
	private Pieza piezaToMove;

	@Override
	public void init() {

		this.image = this.createImage(WIDTH, HEIGHT);
		this.renderBuffer = image.getGraphics();
		this.puzzle = new Puzzle();

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				piezaToMove = puzzle.getObjectClicked(e.getPoint());
			}
		});

		addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {

				if (piezaToMove != null) {

					piezaToMove.setPos(e.getPoint());
					repaint();
				}
			}
		});
	}

	@Override
	public void start() {

		resize(WIDTH, HEIGHT);
	}

	@Override
	public void paint(Graphics g) {

		renderBuffer.setColor(Color.BLACK);
		renderBuffer.fillRect(0, 0, WIDTH, HEIGHT);
		puzzle.paint(renderBuffer);
		g.drawImage(image, 0, 0, this);
	}

}
