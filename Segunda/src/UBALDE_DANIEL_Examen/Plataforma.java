package UBALDE_DANIEL_Examen;

import java.awt.*;
import java.util.Random;

public class Plataforma extends Rectangle {

	private Color color;
	private Random r = new Random();

	public Plataforma() {

		super(Game.BGWIDTH, (int) (Math.random() * 14) * 25 + 100, (int) (Math.random() * 60 + 40), 20);
		color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}

	public Plataforma(int x) {

		super(x, (int) (Math.random() * 14) * 25 + 100, (int) (Math.random() * 60 + 40), 20);
		color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}

	public void paint(Graphics g) {

		g.setColor(color);
		g.fillRect(this.x, this.y, this.width, this.height);
	}

	public void mover() {

		this.x -= 1;
	}

}
