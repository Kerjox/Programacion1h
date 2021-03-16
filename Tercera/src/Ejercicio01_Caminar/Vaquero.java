package Ejercicio01_Caminar;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Vaquero extends Rectangle implements Runnable{

	public Thread animation;
	private ArrayList<Image> images;
	private int indexImage;

	public Vaquero(int x, int y) {

		super(x, y, 100, 200);

		loadImagesGuerrillero();

		this.indexImage = 0;

		this.animation = new Thread(this::run);
		this.animation.start();
	}

	@Override
	public void run() {

		do {

			if (this.indexImage == 3) {

				this.indexImage = 0;
			}else {

				this.indexImage++;
			}

			delay(100);
		}while (true);
	}

	private void loadImagesGuerrillero() {

		images = new ArrayList<>();

		for (int i = 1; i <= 4; i++) {

			Image imageToLoad = null;
			try {
				imageToLoad = ImageIO.read(getClass().getResource("./Sprites/Vaquero/v" + i + ".gif"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			images.add(imageToLoad);
		}
	}

	public void paint(Graphics g) {

		//this.width = images.get(indexImage).getWidth(null);
		//this.height = images.get(indexImage).getHeight(null);

		g.drawImage(images.get(indexImage), this.x, this.y, this.width, this.height, null);
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

