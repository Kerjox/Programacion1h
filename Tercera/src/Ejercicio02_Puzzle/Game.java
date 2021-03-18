package Ejercicio02_Puzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JApplet{

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	private Image image;
	private Graphics renderBuffer;
	private Puzzle puzzle;
	private Piezas piezaToMove;
	private boolean help = false;

	@Override
	public void init() {

		this.image = this.createImage(WIDTH, HEIGHT);
		this.renderBuffer = image.getGraphics();
		this.puzzle = new Puzzle();

		listeners();
	}

	private void listeners() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				switch (e.getButton()) {

					case 1:
						piezaToMove = puzzle.getObjectClicked(e.getPoint());
						if (piezaToMove != null && piezaToMove.isColocada()) {
							piezaToMove = null;
						}
						break;

					case 2:
						puzzle.getObjectClicked(e.getPoint()).setColocada(false);
						break;

					case 3:
						help = !help;
						repaint();
						break;
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {

				if (e.getButton() == 1) {

					puzzle.checkCorrectPosition(piezaToMove);
					repaint();
				}
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

		this.renderBuffer.setColor(Color.BLACK);
		this.renderBuffer.fillRect(0, 0, WIDTH, HEIGHT);

		if (help) {

			this.puzzle.paintImagePuzzle(this.renderBuffer);
		}

		this.puzzle.paintGrid(this.renderBuffer);
		this.puzzle.paint(this.renderBuffer);
		g.drawImage(this.image, 0, 0, this);
	}

}
