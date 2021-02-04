package Ejercicio10_Restaurante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Restaurante {

	private final String[] comidas = {"Desayuno", "Comida", "Cena"};
	private JComboBox<String> comidasComboBox;
	private JLabel comidasElegidas;
	private JList<String> list1;
	private JPanel mainPanel;
	private final String[][] platos = {
			{"Leche", "Colacao", "Café"},
			{"Pasta", "Bocadillo", "Alubias", "Carrilleras"},
			{"Sopa Castellana", "Hamburguesa", "Salchichas"}};
	private JLabel titulo;

	public Restaurante() {

		initTitle();
		initComboBox();
		initList();
		listeners();

	}

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

		JFrame frame = new JFrame("Restaurante");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame.setContentPane(new Restaurante().mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	private void initList() {

		list1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		setList("Desayuno");
	}

	private void listeners() {

		comidasComboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				setList(comidasComboBox.getItemAt(comidasComboBox.getSelectedIndex()));
			}
		});

		list1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				super.mouseClicked(e);
				String comboBoxSelected = comidasComboBox.getItemAt(comidasComboBox.getSelectedIndex());
				comidasElegidas.setText(comboBoxSelected + ": " + getSelectedItems());

			}
		});
	}

	private String getSelectedItems() {

		int[] numberItems = list1.getSelectedIndices();
		String data = "";
		if (numberItems.length != 0) {

			for (int numberItem : numberItems) {

				data = data.concat(list1.getModel().getElementAt(numberItem) + ", ");
			}

			data = data.substring(0, data.length() - 2);
		} else data = "Selecciona al menos 1 elemento";
		return data;

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

		titulo.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
	}

	private void initComboBox() {

		for (String comida : comidas) {

			comidasComboBox.addItem(comida);
		}
	}

}
