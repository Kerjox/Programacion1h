package Ejercicio11_Dibujar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dibujar {

	private JPanel mainPanel;
	private JRadioButton obaloRadioButton;
	private JRadioButton rectanguloRadioButton;
	private JMenuItem nuevoMenuItem;
	private JMenuItem salirMenuItem;
	private JPanelDibujar dibujerPanel;

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

		JFrame frame = new JFrame("Dibujar");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame.setContentPane(new Dibujar().mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public Dibujar() {

		listeners();

	}

	private void listeners() {

		salirMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
	}

	private void createUIComponents() {

		dibujerPanel = new JPanelDibujar();
	}

	class JPanelDibujar extends JPanel {

		public JPanelDibujar() {

			super();
			this.setBackground(Color.BLACK);

		}

		@Override
		public void paint(Graphics g) {

			super.paint(g);
		}

	}

}
