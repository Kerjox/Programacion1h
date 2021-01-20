package Ejercicio07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Ventana {

	private static JFrame frame;
	private JPanel panel1;
	private JRadioButtonMenuItem espanolRadioButtonMenuItem;
	private JRadioButtonMenuItem englishRadioButtonMenuItem;
	private JMenu fileMenu;
	private JButton spanishButton;
	private JButton englishButton;
	private JMenuItem newMenuItem;
	private JMenuItem openMenuItem;
	private JMenuItem saveMenuItem;
	private JMenuItem saveAsMenuItem;
	private JMenuItem exitMenuItem;
	private JButton changeTitleButton;
	private JButton bgColorButton;
	private JButton changeCursorButton;
	private JButton setTextButton;
	private JButton foregoundButton;
	private JButton changeFontButton;
	private centralPanel centralPanel1;
	private static boolean titleBoolean = false;
	private static final int[] cursores = {Cursor.DEFAULT_CURSOR, Cursor.CROSSHAIR_CURSOR, Cursor.HAND_CURSOR};
	private static int indexCursor = 0;
	private static final String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	private static int indexFont = 0;

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
		spanishButton.addActionListener(new ActionListener() {

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
		changeTitleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				changeFrameName();
			}
		});
		bgColorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Random r = new Random();
				centralPanel1.setBackground(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			}
		});
		changeFontButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setFont(new Font(fonts[indexFont], Font.BOLD, 14));
				indexFont++;
			}
		});

		setTextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {


			}
		});

		foregoundButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Random r = new Random();
				centralPanel1.setForeground(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			}
		});
	}

	private static void changeCursor() {

		if (indexCursor > 2) {
			frame.setCursor(cursores[indexCursor]);
			indexCursor++;
		}else {
			indexCursor = 0;
			frame.setCursor(cursores[indexCursor]);

		}

	}

	private static void changeFrameName() {

		if (titleBoolean) {
			titleBoolean = false;
			frame.setTitle("Alcachofa");
		}else {
			titleBoolean = true;
			frame.setTitle("Ejercicio07");
		}

	}

	private void initWindow() {

		ButtonGroup radioButtonsGroup = new ButtonGroup();
		radioButtonsGroup.add(espanolRadioButtonMenuItem);
		radioButtonsGroup.add(englishRadioButtonMenuItem);
		espanolRadioButtonMenuItem.setSelected(true);
		changeLanguage(1);
		int fontSize = 20;
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

		frame = new JFrame("Ejercicio07");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame.setContentPane(new Ventana().panel1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}

	private void createUIComponents() {
		// TODO: place custom component creation code here

		centralPanel1 = new centralPanel();


	}

}

class centralPanel extends JPanel {

	public centralPanel() {

		super();
	}

	@Override
	public void paint(Graphics g) {

		super.paint(g);
		g.drawString("Hello World", 200, 100);
	}

}
