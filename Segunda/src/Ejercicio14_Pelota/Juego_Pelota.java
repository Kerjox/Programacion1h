package Ejercicio14_Pelota;

import javax.swing.*;
import java.awt.*;

public class Juego_Pelota extends JApplet implements Runnable {

	private Image image;
	private Graphics renderBuffer;
	private Thread animacion;

	@Override
	public void run() {

		do {


		}while (true);

	}

	@Override
	public void init() {

		super.init();
		image = this.createImage(300, 300);
		renderBuffer = image.getGraphics();
	}

	@Override
	public void start() {

		super.start();
		animacion = new Thread(this);
		animacion.start();
	}

}
