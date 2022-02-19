import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tablero {

	private List<Image> imagesClavos;
	private List<Clavo> clavosIniciales;
	private List<Slot> slotsJugador;
	private List<Slot> slotsSoluciones;
	private Slot slotMaquina;
	private Clavo clavoPulsado;
	private int indexSlotActivo;
	boolean juegoIniciado;
	private Clavo clavoNegro;
	private Clavo clavoGris;

	public Tablero() {

		juegoIniciado = false;
		initImagesClavos();
		initClavos();
		initSlotMaquina();
		initSlotsJugador();
		initSlotsSoluciones();
		initClavosSoluciones();
		indexSlotActivo = 0;
		setSlotActivo(indexSlotActivo);
	}

	private void initClavosSoluciones() {

		Image imgNegro = null;
		Image imgGris = null;

		try {

			imgNegro = ImageIO.read(Objects.requireNonNull(Game.class.getClassLoader().getResource("clavos/10.png")));
			imgGris = ImageIO.read(Objects.requireNonNull(Game.class.getClassLoader().getResource("clavos/11.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		clavoNegro = new Clavo(imgNegro);
		clavoGris = new Clavo(imgGris);
	}

	private void setSlotActivo(int indexSlotActivo) {

		for (Slot slot : slotsJugador) {

			slot.setActivo(false);
		}

		slotsJugador.get(indexSlotActivo).setActivo(true);
	}

	private void initSlotsJugador() {

		slotsJugador = new ArrayList<>();

		for (int i = 0, y = 70; i < 10; i++, y += 60) {

			slotsJugador.add(new Slot(20, y, false));
		}
	}

	private void initSlotMaquina() {

		slotMaquina = new Slot(20, 20, true);
	}

	private void initSlotsSoluciones() {

		slotsSoluciones = new ArrayList<>();

		for (int i = 0, y = 70; i < 10; i++, y += 60) {

			slotsSoluciones.add(new Slot(250, y, false));
		}
	}

	private void initImagesClavos() {

		imagesClavos = new ArrayList<>();

		try {

			for (int i = 0; i < 7; i++) {

				imagesClavos.add(ImageIO.read(Objects.requireNonNull(Game.class.getClassLoader().getResource("clavos/" + i + ".png"))));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initClavos() {

		clavosIniciales = new ArrayList<>();

		for (int i = 0, y = 200; i < 7; i++, y += 35) {

			clavosIniciales.add(new Clavo(imagesClavos.get(i), 700, y, i));
		}
	}

	public void paintClavosIniciales(Graphics g) {

		for (Clavo clavo :clavosIniciales) {

			clavo.paint(g);
		}
	}

	public void jugar() {

		if (juegoIniciado) return;
		setClavosMaquina();
		juegoIniciado = true;
	}

	private void setClavosMaquina() {

		Clavo[] clavos = new Clavo[4];

		for (int i = 0; i < 4; i++) {

			int randomNumber = (int) (Math.random() * 7);
			clavos[i] = new Clavo(imagesClavos.get(randomNumber), randomNumber);
		}

		slotMaquina.setClavos(clavos);
		slotMaquina.setHide(true);
	}

	public void clavoPulsado(Point point) {

		for (Clavo clavo : clavosIniciales) {

			if (clavo.contains(point)) {

				clavoPulsado = new Clavo(clavo);
			}
		}
	}

	public void moveClavo(Point p) {

		if (clavoPulsado != null) {

			clavoPulsado.move(p);
		}
	}

	public void paintClavoPulsado(Graphics g) {

		if (clavoPulsado != null) {

			clavoPulsado.paint(g);
		}
	}

	public void paintSlotsJugador(Graphics g) {

		for (Slot slot : slotsJugador) {

			slot.paint(g);
		}
	}

	public void mouseSoltado() {

		if (clavoPulsado == null) return;

		for (Slot slot : slotsJugador) {

			if (slot.isActivo()) {

				if (slot.putClavo(clavoPulsado)) {

					checkAnswers();
					indexSlotActivo++;
					setSlotActivo(indexSlotActivo);
				}
			}
		}
		clavoPulsado = null;
	}

	private void checkAnswers() {

		Slot activo = slotsJugador.get(indexSlotActivo);
		int cont = 0;

		for (int i = 0; i < 4; i++) {

			if (activo.getClavos()[i].getColor() == slotMaquina.getClavos()[i].getColor()) {

				slotsSoluciones.get(indexSlotActivo).setClavo(clavoNegro, i);
				cont++;
			} else if (isClavoInMaquinaSlot(activo.getClavos()[i].getColor())) {

				slotsSoluciones.get(indexSlotActivo).setClavo(clavoGris, i);
			}
		}

		if (cont == 4) {

			slotMaquina.setHide(false);
		}
	}

	private boolean isClavoInMaquinaSlot(int color) {

		for (Clavo clavo : slotMaquina.getClavos()) {

			if (clavo.getColor() == color) {

				return true;
			}
		}

		return false;
	}

	public void paintSlotMaquina(Graphics g) {

		slotMaquina.paint(g);
	}

	public void paintSlotsSoluciones(Graphics g) {

		for (Slot slot : slotsSoluciones) {

			slot.paint(g);
		}
	}

}
