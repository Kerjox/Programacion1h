package Ejercicio11_Dibujar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Dibujar {

	private JPanel mainPanel;
	private JRadioButton obaloRadioButton;
	private JRadioButton rectanguloRadioButton;
	private JMenuItem nuevoMenuItem;
	private JMenuItem salirMenuItem;
	private JPanelDibujar dibujarPanel;
	private JRadioButton lineaRadioButton;
	private JRadioButton rojoRadioButton;
	private JRadioButton verdeRadioButton;
	private JRadioButton azulRadioButton;
	private JRadioButton blancoRadioButton;
	private ButtonGroup radioButtonsMenu2;
	private ButtonGroup radioButtonsColors;
	private List<DosPuntos> register = new ArrayList<>();
	private Color color = Color.WHITE;
	private DosPuntos dp = new DosPuntos();

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

		JFrame frame = new JFrame("Dibujar");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame.setContentPane(new Dibujar().mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public Dibujar() {

		initMenu2();
		initColors();
		listeners();
	}

	private void initColors() {

		radioButtonsColors = new ButtonGroup();

		radioButtonsColors.add(rojoRadioButton);
		radioButtonsColors.add(azulRadioButton);
		radioButtonsColors.add(verdeRadioButton);
		radioButtonsColors.add(blancoRadioButton);

		blancoRadioButton.setSelected(true);
	}

	private void initMenu2() {

		radioButtonsMenu2 = new ButtonGroup();

		radioButtonsMenu2.add(obaloRadioButton);
		radioButtonsMenu2.add(rectanguloRadioButton);
		radioButtonsMenu2.add(lineaRadioButton);
		obaloRadioButton.setSelected(true);
	}

	private void listeners() {


		ActionListener changeColor = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				color = (getColorSelected());
			}
		};

		salirMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});

		nuevoMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				register.clear();
				dp = new DosPuntos(0, 0, 0, 0, DosPuntos.OVALO, color);
				dibujarPanel.paint(dibujarPanel.getGraphics());
			}
		});

		dibujarPanel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				super.mousePressed(e);
				register.add(dp);
				dp = new DosPuntos(e.getX(), e.getY(), getSelectedRadioButton(), color);
				dibujarPanel.paint(dibujarPanel.getGraphics());
			}
		});

		dibujarPanel.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {

				super.mouseDragged(e);
				int x = e.getX();
				int y = e.getY();
				dp.setFinX(x);
				dp.setFinY(y);
				dibujarPanel.paint(dibujarPanel.getGraphics());
			}
		});

		rojoRadioButton.addActionListener(changeColor);
		verdeRadioButton.addActionListener(changeColor);
		azulRadioButton.addActionListener(changeColor);
		blancoRadioButton.addActionListener(changeColor);
	}

	private Color getColorSelected() {

		if (rojoRadioButton.isSelected()){

			return Color.RED;
		}else if (verdeRadioButton.isSelected()) {

			return Color.GREEN;
		}else if (azulRadioButton.isSelected()) {

			return Color.BLUE;
		}else {

			return Color.WHITE;
		}
	}

	private int getSelectedRadioButton() {

		if (obaloRadioButton.isSelected()) {

			return DosPuntos.OVALO;
		}else if (rectanguloRadioButton.isSelected()) {

			return DosPuntos.RECTANGULO;
		} else {

			return DosPuntos.LINEA;
		}
	}

	private void createUIComponents() {

		dibujarPanel = new JPanelDibujar();
	}

	class JPanelDibujar extends JPanel {

		public JPanelDibujar() {

			super();
			this.setBackground(Color.BLACK);
			this.setVisible(true);

		}

		@Override
		public void paint(Graphics g) {

			super.paint(g);

			for (DosPuntos object: register) {
				object.pintar(g);
			}

			dp.pintar(g);
		}

	}
}
