package Ruleta;

import javax.swing.*;
import java.awt.*;

public class Game extends JApplet {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	private Image image;
	private Graphics renderBuffer;

	@Override
	public void init() {

		this.image = this.createImage(WIDTH, HEIGHT);
	}

	@Override
	public void paint(Graphics g) {


	}

}
