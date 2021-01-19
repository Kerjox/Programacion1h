package Ejercicio08;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;

public class Ejercicio08 {

	private static JFrame frame;
	private final String[] options = {"Si", "No", "Quizás"};
	private final String[] sports = {"Natación", "Baloncesto", "Futbol", "Badminton", "Tiro con Arco"};
	private MyButton clearButton;
	private JPanel mainPanel;
	private MycomboBox mycomboBox1;
	private MytextField mytextField1;
	private JTextArea textArea1;
	private MyList myList1;

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

		frame = new JFrame("Ejercicio08");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame.setContentPane(new Ejercicio08().mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public Ejercicio08() {


/*
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				super.keyPressed(e);
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					textField.setText(textField.getText().toUpperCase());
				}
			}
		});

		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textArea1.setText("");
			}
		});*/

	}

	private void createUIComponents() {
		// TODO: place custom component creation code here

		textArea1 = new JTextArea();
		textArea1.setBackground(new Color(129, 189, 192));

		mytextField1 = new MytextField();
		clearButton = new MyButton(textArea1);

		mycomboBox1 = new MycomboBox(options, textArea1);

		myList1 = new MyList(sports, textArea1);

	}

}

class MytextField extends JTextField {

	public MytextField() {

		super();

		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				super.keyPressed(e);
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					textToUppercase();
				}
			}
		});
	}

	private void textToUppercase() {

		this.setText(getText().toUpperCase(Locale.ROOT));
	}

}

class MyButton extends JButton {

	public MyButton(JTextArea textArea) {

		super();

		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textArea.setText("");
			}
		});
	}

}

class MycomboBox extends JComboBox {

	public MycomboBox(String[] objects, JTextArea textArea) {

		super();

		for (String object : objects) {

			this.addItem(object);
		}

		this.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				textArea.setText((String) e.getItem());
			}
		});
	}

}

class MyList extends JList {

	public MyList(String[] sports, JTextArea textArea) {

		super();
		this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		this.setLayoutOrientation(JList.VERTICAL);

		DefaultListModel objects = new DefaultListModel();
		for (String sport : sports) {

			objects.addElement(sport);
		}

		this.setModel(objects);

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				super.mouseClicked(e);
				showValues(textArea);
			}
		});
	}

	private void showValues(JTextArea textArea) {

		textArea.setText("");

		int[] list = this.getSelectedIndices();

		for (int element : list) {

			textArea.append(this.getModel().getElementAt(element).toString() + "\n");
		}
	}

}
