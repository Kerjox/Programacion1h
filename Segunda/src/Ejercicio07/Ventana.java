package Ejercicio07;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {

	private JPanel spainButton;
	private JRadioButtonMenuItem espanolRadioButtonMenuItem;
	private JRadioButtonMenuItem englishRadioButtonMenuItem;
	private JMenu fileMenu;
	private JButton button1;
	private JButton englishButton;
	private JMenuItem newMenuItem;
	private JMenuItem openMenuItem;
	private JMenuItem saveMenuItem;
	private JMenuItem saveAsMenuItem;
	private JMenuItem exitMenuItem;

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
		exitMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
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

		switch (n){

			case 1:
				espanolRadioButtonMenuItem.setSelected(true);
				fileMenu.setText("Archivo");
				newMenuItem.setText("Nuevo");
				openMenuItem.setText("Abrir");
				saveMenuItem.setText("Guardar");
				saveAsMenuItem.setText("Guardar Como");
				exitMenuItem.setText("Salir");
				break;

			case 2:
				englishRadioButtonMenuItem.setSelected(true);
				fileMenu.setText("File");
				newMenuItem.setText("New");
				openMenuItem.setText("Open");
				saveMenuItem.setText("Save");
				saveAsMenuItem.setText("Save AS");
				exitMenuItem.setText("Exit");
				break;
		}
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
