package Ejercicio05;

import java.awt.*;

public class AvaloApp extends Frame {

	public static void main(String[] args) {
		AvaloApp app = new AvaloApp();

	}

	public AvaloApp() {

		super("Hola");

		Button button1 = new Button("Siguiente");
		Button button2 = new Button("Salir");
		Panel panel1 = new Panel();

		panel1.add(button1);
		panel1.add(button2);

		this.add("South", panel1);

		this.pack();
		this.resize(300, 300);
		this.show();

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
				}
			}
		}
		return false;
	}

}
