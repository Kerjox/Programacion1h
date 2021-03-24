package Solitario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Game extends JApplet {

	public static final int WIDTH = 900;
	public static final int HEIGHT = 600;

	private Image image;
	private Graphics renderBuffer;
	private CardPackage cardPackage;

	@Override
	public void init() {

		resize(WIDTH, HEIGHT);

		this.image = this.createImage(WIDTH, HEIGHT);
		this.renderBuffer = image.getGraphics();
		cardPackage = new CardPackage();
		initListeners();
	}



	private void initListeners() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {


			}
		});

		addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {


			}
		});
	}

	@Override
	public void paint(Graphics g) {

		renderBuffer.setColor(new Color(0, 31, 6));
		renderBuffer.fillRect(0, 0, WIDTH, HEIGHT);
		paintCards(renderBuffer);
		g.drawImage(image, 0, 0, this);
	}

	private void paintCards(Graphics g) {

		ArrayList<ArrayList<Card>> p = cardPackage.getP();

		for (int i = 0; i < 7; i++) {

			for (int j = 0; j <= i; j++) {

				if (j == i) {

					p.get(i).get(j).paint(renderBuffer, 110 * i, 30 * j);
				}else {


				}
			}
		}
	}

	private void moveStack(int stack) {


	}

}
