package Ejercicio12_Animacion1;

import javax.swing.*;
import java.awt.*;

public class Animacion01 implements Runnable{

	private JPanel mainPanel;
	private Thread animacion;

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

		JFrame frame = new JFrame("Animacion01");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame.setContentPane(new Animacion01().mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public Animacion01() {

		this.animacion = new Thread(this);
		animacion.start();
	}

	@Override
	public void run() {

		do{

		}while(true);
	}

}
