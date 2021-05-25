import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Slot extends Rectangle {

	private final boolean slotMaquina;
	private boolean activo;
	private Clavo[] clavos;
	private boolean hide;
	private List<Rectangle> ovalos;
	public Slot(int x, int y, boolean slotMaquina) {

		this.activo = false;
		this.hide = false;
		this.slotMaquina = slotMaquina;

		this.x = x;
		this.y = y;
		this.width = 200;
		this.height = 30;

		initOvalos();
		clavos = new Clavo[4];
	}

	public Clavo[] getClavos() {

		return clavos;
	}

	public void setClavos(Clavo[] clavos) {

		this.clavos = clavos;
	}

	public void setHide(boolean hide) {

		this.hide = hide;
	}

	public boolean isActivo() {

		return activo;
	}

	public void setActivo(boolean activo) {

		this.activo = activo;
	}

	public void setClavo(Clavo clavo, int index) {

		clavos[index] = clavo;
	}

	public boolean putClavo(Clavo clavo) {

		if (clavo.intersects(this)) {

			for (int i = 0; i < 4; i++) {

				if (ovalos.get(i).intersects(clavo)) {

					clavos[i] = clavo;
				}
			}
		}

		return isFull();
	}

	private boolean isFull() {

		int cont = 0;

		for (int i = 0; i < 4; i++) {

			if (clavos[i] != null) {

				cont++;
			}
		}

		return cont == 4;
	}

	private void initOvalos() {

		ovalos = new ArrayList<>();

		for (int i = 0, x = this.x + 10; i < 4; i++, x += 50) {

			ovalos.add(new Rectangle(x, this.y, 30, 30));
		}
	}

	public void paint(Graphics g) {

		g.setColor(activo || slotMaquina ? Color.BLACK : Color.GRAY);
		g.drawRect(x, y, 200, 30);

		for (Rectangle rectangle : ovalos) {

			g.drawOval(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		}

		for (int i = 0; i < 4; i++) {

			if (clavos[i] != null) {

				clavos[i].paint(g, ovalos.get(i).x, ovalos.get(i).y);
			}
		}

		if (hide) {

			g.setColor(Color.GRAY);
			g.fillRect(x, y, width, height);
		}
	}

}
