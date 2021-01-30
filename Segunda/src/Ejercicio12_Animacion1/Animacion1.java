package Ejercicio12_Animacion1;

import javax.swing.*;
import java.awt.*;

public class Animacion1 implements Runnable {

	private JPanelDraw JPanelDraw;
	private JPanel mainPanel;
	private int cont = 0;
	private final String[] data = {"", "*", "**", "***", "****", "*****", "****", "***", "**", "*"};
	private Thread animacion = new Thread(this);

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

		JFrame frame = new JFrame("Animacion1");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame.setContentPane(new Animacion1().mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public Animacion1() {

		animacion.start();
	}

	private void createUIComponents() {

		JPanelDraw = new JPanelDraw();
	}

	@Override
	public void run() {

		do {

			JPanelDraw.repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);
	}

	class JPanelDraw extends JPanel {

		public JPanelDraw() {

			super();
		}

		@Override
		public void paint(Graphics g) {

			super.paint(g);
			g.drawString(data[cont], 100, 100);
			cont++;
			if (cont > data.length - 1) cont = 0;
		}

	}

}
