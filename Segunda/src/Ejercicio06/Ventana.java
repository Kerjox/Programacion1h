package Ejercicio06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JPanel{

	private JPanel mainPanel;
	private JPanel topMenu;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem exitItem;

	public Ventana() {

		mainPanel = new JPanel();
		topMenu = new JPanel();
		topMenu.setLayout(new GridLayout());
		topMenu.setBackground(new Color(255, 15, 78));
		mainPanel.add(topMenu);

		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		exitItem = new JMenuItem("Exit");
		menuBar.add(fileMenu);
		fileMenu.add(exitItem);
		topMenu.add(menuBar);

		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	public JPanel getMainPanel() {

		return mainPanel;
	}

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

		Ventana ui = new Ventana();
		JPanel main = ui.getMainPanel();
		JFrame frame = new JFrame("Ventana2");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame.setContentPane(main);
		frame.pack();
		frame.setSize(600, 400);
		frame.setVisible(true);

	}

}
