package Ejercicio09_CheckBoxses;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio09 {

	private JPanel mainPanel;
	private JCheckBox checkBox1;
	private JCheckBox checkBox2;
	private JCheckBox checkBox3;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JRadioButton radioButton3;
	private ButtonGroup radioButtonsGroup;
	private List<JRadioButton> radioButtonsList;
	private List<JCheckBox> checkBoxList;
	private String[] sports = {"Baloncesto", "Futbol", "Tennis"};
	private String[] ageRanges = {"10-12", "13-15", "16-18"};

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

		JFrame frame = new JFrame("Ejercicio09");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame.setContentPane(new Ejercicio09().mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public Ejercicio09() {

		initRadioButtons();
		initCheckBoxes();

	}

	private void initCheckBoxes() {

		checkBoxList = new ArrayList<>();
		checkBoxList.add(checkBox1);
		checkBoxList.add(checkBox2);
		checkBoxList.add(checkBox3);

		int i = 0;
		for (JCheckBox checkBox : checkBoxList) {

			checkBox.setText(sports[i++]);
		}
	}

	private void initRadioButtons() {

		radioButtonsGroup = new ButtonGroup();
		radioButtonsList = new ArrayList<>();

		radioButtonsList.add(radioButton1);
		radioButtonsList.add(radioButton2);
		radioButtonsList.add(radioButton3);

		int i = 0;
		for (JRadioButton radioButton : radioButtonsList) {

			radioButtonsGroup.add(radioButton);
			radioButton.setText(ageRanges[i++]);
		}
	}

}
