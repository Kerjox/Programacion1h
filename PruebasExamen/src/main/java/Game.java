import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game extends JApplet implements Runnable, KeyEventDispatcher {

	private static List<Image> explosionImages;
	private static List<Explosion> explosions;
	private Dimension dim;
	private Thread game;
	private Image image;
	private List<List<Image>> playerImages;
	private List<Jugador> players;
	private Graphics renderBuffer;
	private AudioClip[] sounds;

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {

		switch (e.getKeyCode()) {

			case 38:        // Up

				players.get(0).move(Jugador.UP);
				break;

			case 39:        // Right

				players.get(0).move(Jugador.RIGHT);
				break;

			case 40:        // Down

				players.get(0).move(Jugador.DOWN);
				break;

			case 37:        // Left

				players.get(0).move(Jugador.LEFT);
				break;

			case 32:

				players.get(0).shoot();
				break;

			default:

				System.out.println(e.getKeyCode());
				break;
		}
		return false;
	}

	@Override
	public void init() {

		dim = new Dimension(800, 600);
		image = createImage(dim.width, dim.height);
		renderBuffer = image.getGraphics();
		game = new Thread(this::run);
		explosionImages = new ArrayList<>();
		explosions = new ArrayList<>();

		initPlayerImages();
		initExplosionImages();

		initSound();

		initJugadores();

		initListeners();
	}

	@Override
	public void paint(Graphics g) {

		renderBuffer.setColor(Color.BLACK);
		renderBuffer.fillRect(0, 0, dim.width, dim.height);
		paintPlayers(renderBuffer);
		paintBullets(renderBuffer);
		paintExplosions(renderBuffer);
		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void run() {

		do {

			repaint();
			moveBullets();
			delay(10);
		} while (true);
	}

	@Override
	public void start() {

		resize(dim);
		requestFocusInWindow();
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
		sounds[0].play();
		game.start();
	}

	private void initListeners() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				switch (e.getButton()) {

					case 1:

						players.get(0).shoot();
						break;

					case 2:

						System.out.println("Click central");
						break;

					case 3:

						System.out.println("Click derecho");
						break;
				}
			}
		});
	}

	private void moveBullets() {

		for (Jugador player : players) {

			player.moveBullets(dim);
		}
	}

	private void paintPlayers(Graphics g) {

		for (Jugador player : players) {

			player.paint(g);
		}
	}

	private void paintBullets(Graphics g) {

		for (Jugador player : players) {

			player.paintBullets(g);
		}
	}

	private void paintExplosions(Graphics g) {

		if (explosions.size() == 0) return;

		List<Explosion> explosionsCopy = new ArrayList<>(explosions);

		for (Explosion explosion : explosionsCopy) {

			if (explosion.paint(g)) {

				explosions.remove(explosion);
			}

		}
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void initExplosionImages() {

		explosionImages = new ArrayList<>();


		try {

			for (int i = 0; i < 15; i++) {

				explosionImages.add(ImageIO.read(Objects.requireNonNull(Game.class.getClassLoader().getResource("sprites/Explosion/" + i + ".png"))));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initSound() {

		sounds = new AudioClip[3];

		sounds[0] = getAudioClip(Game.class.getClassLoader().getResource("sounds/correct.wav"));
		sounds[1] = getAudioClip(Game.class.getClassLoader().getResource("sounds/error.wav"));
		sounds[2] = getAudioClip(Game.class.getClassLoader().getResource("sounds/exito.wav"));
	}

	private void initJugadores() {

		players = new ArrayList<>();
		players.add(new Jugador(Jugador.GUERRILLERO, 10, 10, 60, 120, playerImages.get(Jugador.GUERRILLERO)));
		//players.get(0).;
	}

	private void initPlayerImages() {

		playerImages = new ArrayList<>();

		try {

			playerImages.add(new ArrayList<>());

			for (int i = 1; i <= 4; i++) {

				playerImages.get(0).add(ImageIO.read(Objects.requireNonNull(Game.class.getClassLoader().getResource("sprites/Guerrillero/g" + i + ".gif"))));
			}

			playerImages.add(new ArrayList<>());

			for (int i = 1; i <= 4; i++) {

				playerImages.get(1).add(ImageIO.read(Game.class.getClassLoader().getResource("sprites/Hampon/h" + i + ".gif")));
			}

			playerImages.add(new ArrayList<>());

			for (int i = 1; i <= 4; i++) {

				playerImages.get(2).add(ImageIO.read(Game.class.getClassLoader().getResource("sprites/Vaquero/v" + i + ".gif")));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void makeExplosion(int x, int y) {

		explosions.add(new Explosion(x, y - 20, explosionImages));
	}



}
