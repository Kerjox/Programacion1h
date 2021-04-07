package Ejercicio03;


import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JApplet {

	private Image image;
	private Graphics renderBuffer;
	private AudioClip correct, error, exito;

	private Tablero tablero;

	@Override
	public void init() {

		this.image = this.createImage(400, 400);
		this.renderBuffer = this.image.getGraphics();
		this.tablero = new Tablero();
		loadSounds();
		initListeners();
		resize(400, 400);
	}

	private void initListeners() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				if (e.getButton() == 1) {

					if (tablero.move(new Point(e.getPoint().x / 80, e.getPoint().y / 80))) {

						correct.play();
					} else {

						error.play();
					}
					if (tablero.verify()) {

						System.out.println("Correcto");
						exito.play();
					}
					repaint();
				}
			}
		});
	}

	@Override
	public void paint(Graphics g) {

		this.renderBuffer.setColor(Color.WHITE);
		this.renderBuffer.fillRect(0, 0, 400, 400);
		tablero.paint(renderBuffer);
		g.drawImage(image, 0, 0, this);
	}

	private void loadSounds() {

		this.correct = getAudioClip(getCodeBase(), "/home/kerjox/IdeaProjects/Programacion1h/Tercera/src/Ejercicio03/src/sonidos/correct.wav");
		this.error = getAudioClip(getCodeBase(), "/home/kerjox/IdeaProjects/Programacion1h/Tercera/src/Ejercicio03/src/sonidos/error.wav");
		this.exito = getAudioClip(getCodeBase(), "/home/kerjox/IdeaProjects/Programacion1h/Tercera/src/Ejercicio03/src/sonidos/exito.wav");
	}

}
