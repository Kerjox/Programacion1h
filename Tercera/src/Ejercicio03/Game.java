package Ejercicio03;

import sun.applet.AppletAudioClip;
import sun.applet.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

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

					tablero.move(e.getPoint());
					correct.play();
				}
			}
		});
	}

	@Override
	public void paint(Graphics g) {

		tablero.paint(renderBuffer);
		g.drawImage(image, 0, 0, this);
	}

	private void loadSounds() {

		this.correct = getAudioClip(getCodeBase(), "/home/kerjox/IdeaProjects/Programacion1h/Tercera/src/Ejercicio03/src/sonidos/correct.wav");
		this.error = getAudioClip(getCodeBase(), "/home/kerjox/IdeaProjects/Programacion1h/Tercera/src/Ejercicio03/src/sonidos/error.wav");
		this.exito = getAudioClip(getCodeBase(), "/home/kerjox/IdeaProjects/Programacion1h/Tercera/src/Ejercicio03/src/sonidos/exito.wav");
	}

}
