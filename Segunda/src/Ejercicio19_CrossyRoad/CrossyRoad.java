package Ejercicio19_CrossyRoad;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CrossyRoad extends JApplet implements Runnable {

	public static final int BGWIDTH = 600;
	public static final int BGHEIGHT = 400;
	private Thread game;
	private List<Car> carList;
	private Image image;
	private Graphics renderBuffer;
	private final int spawnCarAt = 1000;
	private int contSpawn = 0;

	@Override
	public void run() {

		do {

			moverCoches();
			checkCochesFin();
			spawnNewCar();
			repaint();
			delay(20);
		}while(true);
	}

	@Override
	public void start() {

		this.game = new Thread(this);
		this.game.start();
	}

	@Override
	public void init() {

		resize(BGWIDTH, BGHEIGHT);
		this.image = this.createImage(BGWIDTH, BGHEIGHT);
		this.renderBuffer = image.getGraphics();
		initCars();
	}

	@Override
	public void paint(Graphics g) {

		drawRoad(renderBuffer);
		drawCars(renderBuffer);
		g.drawImage(image, 0, 0, this);
	}

	private void drawRoad(Graphics g) {

		g.setColor(Color.GREEN);
		g.fillRect(0, 0, BGWIDTH, BGHEIGHT);
		g.setColor(Color.BLACK);
		g.fillRect(0, 150, BGWIDTH, 100);
		g.setColor(Color.GRAY);
		g.fillRect(0, 195, BGWIDTH, 10);
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void moverCoches() {

		for (Car car: carList) {

			car.move();
		}
	}

	private void initCars() {

		carList = new ArrayList<>();

		carList.add(new Car(0, 163, Car.RIGHT, 1));
		carList.add(new Car(BGWIDTH - 50, 215, Car.LEFT, 1));
	}

	private void newCar(boolean direction) {

		if (direction) {

			carList.add(new Car(0, 163, Car.RIGHT, 1));
		} else {

			carList.add(new Car(BGWIDTH - 50, 215, Car.LEFT, 1));
		}

	}

	private void drawCars(Graphics g) {

		for (Car car : carList) {

			car.paint(g);
		}
	}

	private void checkCochesFin() {

		for (Car car : carList) {

			if (car.isDirection() == Car.RIGHT) {

				if (((int) (car.getX())) >= BGWIDTH) {

					carList.remove(car);
					break;
				}
			} else {

				if (((int) (car.getX())) + 50 <= 0) {

					carList.remove(car);
					break;
				}
			}
		}
	}

	private void spawnNewCar() {

		if (contSpawn >= spawnCarAt) {
			boolean direction = Math.random() > 0.5;
			newCar(direction);
			contSpawn = 0;
		}else {

			contSpawn += 20;
		}
	}

}
