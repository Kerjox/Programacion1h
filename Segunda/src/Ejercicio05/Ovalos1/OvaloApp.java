package Ejercicio05.Ovalos1;

import java.awt.*;

public class OvaloApp extends Frame {

	private Ovalo ovalo;

	public static void main(String[] args) {

		OvaloApp app = new OvaloApp();
	}

	public OvaloApp() {

		super("Ovalos");

		Button button1 = new Button("Siguiente");
		Button button2 = new Button("Salir");
		Panel panel1 = new Panel();
		ovalo = new Ovalo();

		panel1.add(button1);
		panel1.add(button2);

		this.add("South", panel1);

		this.pack();
		this.resize(300, 300);
		this.show();

	}

	public void paint(Graphics g) {

		ovalo.dibujar(g);
	}

	public boolean handleEvent(Event ev) {

		if (ev.id == Event.WINDOW_DESTROY) {

			System.exit(0);
			return true;

		}else if (ev.id == Event.ACTION_EVENT) {

			if (ev.target instanceof Button) {

				if (ev.arg.equals("Salir")) {

					System.exit(0);
					return true;

				} else if (ev.arg.equals("Siguiente")) {

						ovalo.init();
						repaint();
						//paint(getGraphics());
						return true;

				}
			}
		}

		return false;
	}

}
