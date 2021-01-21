package Ejercicio08_CustomClasses;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Locale;

public class Ejercicio08 {

	private static JFrame frame;
	private final String[] options = {"Si", "No", "Quizás"};
	private final String[] sports = {"Natación", "Baloncesto", "Futbol", "Badminton", "Tiro con Arco"};
	private final String[] sports2 = {"Natación", "Baloncesto", "Futbol", "Badminton", "Tiro con Arco"};
	private MyButton clearButton;
	private JPanel mainPanel;
	private MycomboBox mycomboBox1;
	private MytextField mytextField1;
	private JTextArea textArea1;
	private MyList myList1;
	private MyCanvas myCanvas1;
	private JCheckBox peraCheckBox;
	private JCheckBox alcachofaCheckBox;
	private JCheckBox manzanaCheckBox;
	private JCheckBox quesoCheckBox;
	private JPanel checkBoxes;
	private JLabel checkBoxLeaver;

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

		frame = new JFrame("Ejercicio08_CustomClasses");
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
		peraCheckBox.addActionListener(new checkCheckBoxes());
		alcachofaCheckBox.addActionListener(new checkCheckBoxes());
		manzanaCheckBox.addActionListener(new checkCheckBoxes());
		quesoCheckBox.addActionListener(new checkCheckBoxes());
	}

	class checkCheckBoxes implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String thingToPrint = "";
			if (peraCheckBox.isSelected()) {
				thingToPrint = thingToPrint.concat(peraCheckBox.getText() + " ");
			}
			if (alcachofaCheckBox.isSelected()) {
				thingToPrint = thingToPrint.concat(alcachofaCheckBox.getText() + " ");
			}
			if (manzanaCheckBox.isSelected()) {
				thingToPrint = thingToPrint.concat(manzanaCheckBox.getText() + " ");
			}
			if (quesoCheckBox.isSelected()) {
				thingToPrint = thingToPrint.concat(quesoCheckBox.getText() + " ");
			}
			checkBoxLeaver.setText(thingToPrint);
		}

	}

	private void createUIComponents() {
		// TODO: place custom component creation code here

		textArea1 = new JTextArea();
		textArea1.setBackground(new Color(129, 189, 192));

		mytextField1 = new MytextField();
		clearButton = new MyButton(textArea1);

		mycomboBox1 = new MycomboBox(options, textArea1);

		myList1 = new MyList(sports, textArea1);

		myCanvas1 = new MyCanvas();

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

		DefaultListModel<String> objects = new DefaultListModel<>();
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

class MyCanvas extends JPanel {

	private int posX = 0, posY = 0;

	public MyCanvas() {
		super();
		this.setBackground(Color.BLACK);
		this.setForeground(Color.RED);
		this.setVisible(true);

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				super.mouseClicked(e);
				posX = e.getX();
				posY = e.getY();
				repaint();
			}
		});
	}

	@Override
	public void paint(Graphics g) {

		super.paint(g);
		g.setColor(Color.WHITE);
		g.drawRect(posX, posY, 10, 10);
	}

}