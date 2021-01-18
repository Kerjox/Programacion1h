package Ejercicio08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ejercicio09 {
	private static JFrame frame;
	private JPanel mainPanel;
	private JTextField textField;
	private JTextArea textArea1;
	private JButton clearButton;

	public Ejercicio09() {


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
		});
	}

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

		frame = new JFrame("Ejercicio09");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame.setContentPane(new Ejercicio09().mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	private void createUIComponents() {
		// TODO: place custom component creation code here
		textArea1 = new JTextArea();
		textArea1.setBackground(new Color(14,45,78));
	}

}

class MytextField extends JTextField {


}
