package Ejercicio10_Restaurante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

public class Restaurante {

	private JPanel mainPanel;
	private JComboBox<String> comidasComboBox;
	private JLabel elijeTuComidaLabel;
	private JList list1;
	private String[] comidas = {"Desayuno", "Comida", "Cena"};
	private String[][] platos = {{"Leche", "Colacao", "Café"}, {"Pasta", "Bocadillo", "Alubias"}, {"Sopa Castellana", "Hamburguesa", "Salchichas"}};

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

		JFrame frame = new JFrame("Restaurante");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame.setContentPane(new Restaurante().mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public Restaurante() {

		initTitle();
		initComboBox();

		comidasComboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				System.out.println(comidasComboBox.getItemAt(comidasComboBox.getSelectedIndex()));

			}
		});
	}

	private void initTitle() {

		elijeTuComidaLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
	}

	private void initComboBox() {

		for (String comida : comidas) {

			comidasComboBox.addItem(comida);
		}
	}

}
