import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.SecureRandom;
import java.util.Arrays;

public class Pruebas extends JApplet implements Runnable, KeyEventDispatcher {

	private static final int BGWIDTH = 800;
	private static final int BGHEIGHT = 600;
	private Thread game;
	private Image image;
	private Graphics renderbuffer;
	private ovalo player;
	private boolean jumpInProgress = false;
	private int steepsToJump = 100;

	@Override
	public void run() {

		do {

			checkIfPlayerHasToJump();
			repaint();
			delay(10);
		}while (true);
	}

	@Override
	public void start() {

		resize(BGWIDTH, BGHEIGHT);
		requestFocusInWindow();
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
		game.start();
	}

	@Override
	public void init() {

		game = new Thread(this);
		image = this.createImage(BGWIDTH, BGHEIGHT);
		renderbuffer = image.getGraphics();
		player = new ovalo();

	}

	@Override
	public void paint(Graphics g) {

		renderbuffer.setColor(Color.BLACK);
		renderbuffer.fillRect(0, 0, BGWIDTH, BGHEIGHT);
		player.paint(renderbuffer);
		g.drawImage(image, 0, 0, this);
	}

	private static void delay(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {

		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 38) {

			jumpInProgress = true;
		}
		player.moveByKeyboard(e.getKeyCode());

		//System.out.println(e.getKeyCode());
		return false;
	}

	private void checkIfPlayerHasToJump() {

		if (jumpInProgress) {

			if(steepsToJump-- > 0) {

				player.jump();
			}else {

				if (player.getY() <= 500) {

					player.down();
				} else {

					jumpInProgress = false;
					steepsToJump = 100;
				}

			}

		}
	}

}
