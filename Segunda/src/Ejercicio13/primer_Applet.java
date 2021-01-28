package Ejercicio13;

import java.applet.Applet;
import java.awt.*;

public class primer_Applet extends Applet {

	private Thread thread;

	@Override
	public void init() {

		super.init();
	}

	@Override
	public void paint(Graphics g) {

		super.paint(g);
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 90, 90);
	}

}
