package Ejercicio12_Animacion1;

import javax.swing.*;
import java.awt.*;

public class Animacion01 implements Runnable{

	private JPanel mainPanel;
	private drawPanel drawPanel1;
	private Thread animacion;

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

		JFrame frame = new JFrame("Animacion01");
		//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame.setContentPane(new Animacion01().mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public Animacion01() {

		this.animacion = new Thread(this);

		animacion.start();
	}

	private void createUIComponents() {

		drawPanel1 = new drawPanel();
	}

	@Override
	public void run() {

		do{

			drawPanel1.print(drawPanel1.getGraphics());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(true);
	}

}

class drawPanel extends JPanel {

	private String frames[] = {"*", "**", "***", "****", "*****", "******", "*****", "****", "***", "**"};
	private int actual = 0;

	public drawPanel() {

		super();
		this.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {

		super.paint(g);
		g.drawString(frames[actual], 100, 100);
		actual++;
		if (actual > frames.length) actual = 0;

	}

}
