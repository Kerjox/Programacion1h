import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JApplet {

	private Dimension dimension;
	private boolean fin;
	private Image image;
	private Panel panel;
	private Graphics renderBuffer;

	@Override
	public void init() {

		this.dimension = new Dimension(1080, 1080);
		resize(this.dimension);
		this.image = this.createImage(this.dimension.width, this.dimension.height);
		this.renderBuffer = this.image.getGraphics();
		this.panel = new Panel(80, 120, 20, 20);
		this.fin = false;
		initListeners();
	}

	@Override
	public void paint(Graphics g) {

		this.renderBuffer.setColor(Color.BLACK);
		this.renderBuffer.fillRect(0, 0, this.dimension.width, this.dimension.height);
		this.panel.paintPanel(this.renderBuffer);
		this.panel.paintGrid(this.renderBuffer);

		//showAxes(this.renderBuffer);
		g.drawImage(image, 0, 0, this);
	}

	private void initListeners() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				if (fin) return;

				switch (e.getButton()) {

					case 1:

						fin = panel.boxPressed(e.getPoint());
						//panel.showBombs();
						repaint();
						break;
					case 3:

						panel.toggleMark(e.getPoint());
						repaint();
						break;
				}
			}

		});
	}

	private void showAxes(Graphics g) {

		g.setColor(Color.WHITE);
		g.drawString("X", 300, 100);
		g.drawString("Y", 60, 350);

	}

}
