package Ejercicio06;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {

	private JPanel panel1;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JMenuItem Exit;

	public Ventana() {

		Exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {

		JFrame frame = new JFrame("Ventana2");
		frame.setContentPane(new Ventana().panel1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
