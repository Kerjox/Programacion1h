import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tablero {

	private List<Pelota> pelotasATirar;
	private List<Image> imagesPelotas;
	private Pelota pelotaTirada;
	private double posXPelotaMovimiento;
	private double posYPelotaMovimiento;
	private double velXPelotaMovimiento;
	private double velYPelotaMovimiento;
	private Pelota[][] tableroPelotas;

	public Tablero() {

		this.imagesPelotas = new ArrayList<>();
		this.pelotasATirar = new ArrayList<>();
		this.tableroPelotas = new Pelota[10][20];
		initImagesPelotas();
		initPelotasATirar();
	}

	private void initImagesPelotas() {

		for (int i = 0; i < 4; i++) {

			this.imagesPelotas.add(getImage(i));
		}
	}

	protected Image getImage(Integer value) {

		try {
			return ImageIO.read(Pelota.class.getClassLoader().getResource("pelotas/" + value + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Never here
		return null;
	}

	private void initPelotasATirar() {

		for (int i = 0; i < 10; i++) {

			int n = (int) (Math.random() * 4);
			Image img = this.imagesPelotas.get(n);
			this.pelotasATirar.add(new Pelota(img));
		}
	}

	public void paintPelotasATirar(Graphics g) {

		this.pelotasATirar.get(0).paint(g, 300, 560);
	}

	public void pelotaTirada(Point p) {

		if (this.pelotaTirada != null) return;

		this.pelotaTirada = this.pelotasATirar.get(0);
		this.pelotaTirada.setX(300);
		this.pelotaTirada.setY(560);
		this.pelotasATirar.remove(this.pelotaTirada);
		this.posXPelotaMovimiento = 300;
		this.posYPelotaMovimiento = 560;
		calculateVel(p);
	}

	public void movePelotaTirada() {

		if (this.pelotaTirada != null) {

			this.posXPelotaMovimiento += velXPelotaMovimiento;
			this.posYPelotaMovimiento += velYPelotaMovimiento;
		}
	}

	private void calculateVel(Point p) {

		Pelota pelota = this.pelotaTirada;
		this.velXPelotaMovimiento = (p.x - pelota.getX()) / 1000.0;
		this.velYPelotaMovimiento = (p.y - pelota.getY()) / 1000.0;
	}

	public void paintNextPelotas(Graphics g) {

		if (this.pelotasATirar.size() < 4) {

			initPelotasATirar();
		}

		this.pelotasATirar.get(1).paint(g, 20, 560);
		this.pelotasATirar.get(2).paint(g, 50, 560);
		this.pelotasATirar.get(3).paint(g, 80, 560);
	}

	public void paintPelotaTirada(Graphics g) {

		if (this.pelotaTirada != null) {

			this.pelotaTirada.paint(g, (int) posXPelotaMovimiento, (int) posYPelotaMovimiento);
		}
	}

	public void checkLimitPelotaTirada() {

		if (this.pelotaTirada != null) {

			if (this.pelotaTirada.getY() <= 0 || estaColisionando()) {

				int posX = (int) this.pelotaTirada.getX() / 30;
				int posY = (int) this.pelotaTirada.getY() / 29;

				this.tableroPelotas[posY][posX] = this.pelotaTirada;
				this.pelotaTirada = null;
			}
		}
	}

	private boolean estaColisionando() {

		for (int i = 0; i < this.tableroPelotas.length; i++) {

			for (int j = 0; j < this.tableroPelotas[0].length; j++) {

				if (this.tableroPelotas[i][j] != null && this.pelotaTirada.intersects(this.tableroPelotas[i][j])) {

					return true;
				}
			}
		}

		return false;
	}

	public void paintTableroPelotas(Graphics g) {

		for (int i = 0; i < this.tableroPelotas.length; i++) {

			for (int t = 0; t < this.tableroPelotas[0].length; t++) {

				if (this.tableroPelotas[i][t] != null) {

					if (i % 2 == 0) {

						this.tableroPelotas[i][t].paint(g, t * 30, i * 30);
					} else {

						this.tableroPelotas[i][t].paint(g, t * 30 + 15, i * 30);
					}
				}
			}
		}
	}

}
