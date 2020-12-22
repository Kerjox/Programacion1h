package Ejercicio05.Ovalos2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OvalosApp extends JFrame{

	Ovalo ovalo;

	public static void main(String[] args) {

		OvalosApp app = new OvalosApp();
	}

	private JButton exit;
	private JButton next;

	public OvalosApp() {

		Panel panel1 = new Panel();
		ovalo = new Ovalo();

		panel1.add(exit);
		panel1.add(next);

		this.add("South", panel1);

		this.pack();
		this.resize(300, 300);
		this.show();


		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});

		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ovalo.init();
				repaint();

			}
		});
	}

	public void paint(Graphics g) {

		ovalo.dibujar(g);

	}


}
