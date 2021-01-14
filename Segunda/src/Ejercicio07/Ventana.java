package Ejercicio07;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {

	private JPanel spainButton;
	private JRadioButtonMenuItem espanolRadioButtonMenuItem;
	private JRadioButtonMenuItem englishRadioButtonMenuItem;
	private JMenu fileMenu;
	private JMenu archivoMenu;
	private JButton button1;
	private JButton englishButton;

	public Ventana() {

		initWindow();

		espanolRadioButtonMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				changeLanguage(1);
			}
		});

		englishRadioButtonMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				changeLanguage(2);
			}
		});
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				changeLanguage(1);
			}
		});
		englishButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				changeLanguage(2);
			}
		});
	}

	private void initWindow() {

		ButtonGroup radioButtonsGroup = new ButtonGroup();
		radioButtonsGroup.add(espanolRadioButtonMenuItem);
		radioButtonsGroup.add(englishRadioButtonMenuItem);
		espanolRadioButtonMenuItem.setSelected(true);
		changeLanguage(1);
	}

	private void changeLanguage(int n) {

		hideMenus();

		switch (n){

			case 1:
				archivoMenu.setVisible(true);
				break;

			case 2:
				fileMenu.setVisible(true);
				break;
		}
	}

	private void hideMenus() {

		fileMenu.setVisible(false);
		archivoMenu.setVisible(false);
	}

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

		JFrame frame = new JFrame("Ejercicio07");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame.setContentPane(new Ventana().spainButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}

}
