package Ejercicio11_Dibujar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Map;

public class Dibujar {

	private JPanel mainPanel;
	private JRadioButton obaloRadioButton;
	private JRadioButton rectanguloRadioButton;
	private JMenuItem nuevoMenuItem;
	private JMenuItem salirMenuItem;
	private JPanelDibujar dibujarPanel;
	private JRadioButton lineaRadioButton;
	private DosPuntos dp = new DosPuntos();
	private ButtonGroup radioButtonsGroup;

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

		JFrame frame = new JFrame("Dibujar");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame.setContentPane(new Dibujar().mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public Dibujar() {

		initRadioButtons();
		listeners();
	}

	private void initRadioButtons() {

		radioButtonsGroup = new ButtonGroup();

		radioButtonsGroup.add(obaloRadioButton);
		radioButtonsGroup.add(rectanguloRadioButton);
		radioButtonsGroup.add(lineaRadioButton);
		obaloRadioButton.setSelected(true);
	}

	private void listeners() {

		salirMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});

		nuevoMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dp = new DosPuntos(20, 20, 100, 100, DosPuntos.OVALO);
				dibujarPanel.paint(dibujarPanel.getGraphics());
			}
		});

		dibujarPanel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				super.mousePressed(e);

				dp = new DosPuntos(e.getX(), e.getY(), getSelectedRadioButton());
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
			g.setColor(Color.WHITE);
			dp.pintar(g);
		}

	}
}
