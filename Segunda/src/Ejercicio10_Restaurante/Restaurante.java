package Ejercicio10_Restaurante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Restaurante {

	private JPanel mainPanel;
	private JComboBox<String> comidasComboBox;
	private JLabel elijeTuComidaLabel;
	private JList<String> list1;
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
		listeners();
		setList("Desayuno");
	}

	private void listeners() {

		comidasComboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				setList(comidasComboBox.getItemAt(comidasComboBox.getSelectedIndex()));
			}
		});
	}

	private void setList(String itemAt) {

		DefaultListModel<String> objets = new DefaultListModel<>();
		int index = 0;
		switch (itemAt) {
			case "Desayuno":
				index = 0;
				break;
			case "Comida":
				index = 1;
				break;
			case "Cena":
				index = 2;
				break;
		}
		for (int i = 0; i < platos[index].length; i++) {

			objets.addElement(platos[index][i]);
		}

		list1.setModel(objets);
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
