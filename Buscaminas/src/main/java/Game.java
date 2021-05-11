import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JApplet {

	private Dimension dimension;
	private Image image;
	private Graphics renderBuffer;
	private Panel panel;

	@Override
	public void init() {

		this.dimension = new Dimension(600, 600);
		resize(this.dimension);
		this.image = this.createImage(this.dimension.width, this.dimension.height);
		this.renderBuffer = this.image.getGraphics();
		this.panel = new Panel();
		initListeners();
	}

	private void initListeners() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				panel.boxPressed(e.getPoint());
				//panel.showBombs();
				repaint();
			}
		});
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

	private void showAxes(Graphics g) {

		g.setColor(Color.WHITE);
		g.drawString("X", 300, 100);
		g.drawString("Y", 60,  350);

	}

}
