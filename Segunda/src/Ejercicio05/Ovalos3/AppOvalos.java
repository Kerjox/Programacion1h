package Ejercicio05.Ovalos3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppOvalos extends JFrame {

	private JPanel OvalosApp;
	private JButton nextButton;
	private JPanel container;
	private final Ovalo ovalo;

	public static void main(String[] args) {

		JFrame frame = new JFrame("AppOvalos");
		frame.setContentPane(new AppOvalos().OvalosApp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public AppOvalos() {

		ovalo = new Ovalo();

		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ovalo.init();
				paint(container.getGraphics());

			}
		});
	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0,0,400,400);         //Funciona pero no como se espera
		ovalo.dibujar(g);
	}

}
