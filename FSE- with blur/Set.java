import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

class Set extends JPanel implements KeyListener, ActionListener, MouseListener {
	private boolean[] keys;
	private final int INTRO = 0, HOWTOUSE = 1, CREATE = 2, COL = 0, BLA = 1;
	Timer timer;
	Image pic;
	private int mx, my, screen, wheel;
	Button[] b = new Button[20];
	boolean clear = false;
	Button introButton, backButton;
	Brush p, inv, er, bl, sh;

	BufferedImage img;

	// sets the default settings such as the background, starting timer, etc
	public Set() {
		keys = new boolean[KeyEvent.KEY_LAST + 1];
		setPreferredSize(new Dimension(1900, 1080));
		setFocusable(true);
		requestFocus();
		addKeyListener(this);
		addMouseListener(this);
		timer = new Timer(20, this);
		timer.start();
		pic = new ImageIcon("back.png").getImage();
		introButton = new Button(610, 230, "idk", 690, 690);
		backButton = new Button(10, 10, "idk", 75, 75);

		for (int i = 0; i < 5; i++) {
			b[i] = new Button(40, 130 + (i * 110), "idk", 100, 180);
			b[i + 5] = new Button(1300, 130 + (i * 110), "idk", 100, 180);
			b[i + 10] = new Button(320 + (i * 310), 750, "idk", 70, 260);

		}
		p = new Brush(mx, my);
		er = new Brush(mx, my);
		bl = new Brush(mx, my);
		sh = new Brush(mx, my);
		inv = new Brush(mx, my);
		wheel = COL;
		er.pickColor(Color.white);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if (isShowing()) {
			Point mouse = MouseInfo.getPointerInfo().getLocation();
			Point offset = getLocationOnScreen();
			// makes sure the mouse is tracked inside the panel
			mx = (mouse.x - offset.x);
			my = (mouse.y - offset.y);
		}

	}

	@Override
	public void keyReleased(KeyEvent ke) {
		int key = ke.getKeyCode();
		keys[key] = false;
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		int key = ke.getKeyCode();
		keys[key] = true;

	}

	@Override
	public void keyTyped(KeyEvent ke) {
	}

	/*
	 * by setting each box as a button, when the mouse clicks, it checks if the
	 * mouse interacts with any button.
	 * Whatever button is interacted with, the button will trigger the if
	 * statement activate the function.
	 */

	@Override
	public void mouseClicked(MouseEvent e) {
		if (b[12].hover(mx, my)) {
			Upload f = new Upload(img);
		}
		if (b[0].hover(mx, my)) {
			p.start(true);
			er.start(false);

		}
		if (b[1].hover(mx, my)) {
			p.start(true);
			p.clear();
		}
		if (b[3].hover(mx, my)) {
			er.start(true);
			p.start(false);

		}
		if (b[2].hover(mx, my)) {
			bl.start(true);
			er.start(false);
			p.start(false);
		}
		if (b[4].hover(mx, my)) {
			sh.start(true);
			er.start(false);
			p.start(false);
		}
		if (b[5].hover(mx, my)) {
			inv.start(true);
			er.start(false);
			p.start(false);
		}
		if (b[8].hover(mx, my)) {
			if (wheel == COL) {
				wheel = BLA;
			} else {
				wheel = COL;
			}
		}
		if (b[9].hover(mx, my)) {
			screen = HOWTOUSE;
		}
		if (b[10].hover(mx, my)) {
			p.brushSize(Brush.UP);
			er.brushSize(Brush.UP);
		}
		if (b[11].hover(mx, my)) {
			p.brushSize(Brush.DOWN);
			er.brushSize(Brush.DOWN);
		}

		if (introButton.hover(mx, my)) {
			screen = CREATE;
		}
		if (backButton.hover(mx, my)) {
			screen = CREATE;
		}

		p.pickColor();

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {

		bl.active(true);
		sh.active(true);
		inv.active(true);
		p.active(true);
		er.active(true);

	}

	@Override
	public void mouseReleased(MouseEvent e) {

		bl.start(false);
		sh.start(false);
		inv.start(false);
		p.active(false);
		er.active(false);

	}

	@Override
	public void paint(Graphics g) {
		if (screen == INTRO) {
			Graphics2D g2d = (Graphics2D) g;
			g.setColor(new Color(48, 150, 220));
			g.fillRect(0, 0, 1900, 1080);
			g.setColor(new Color(0, 0, 0));
			g.setFont(new Font("Palace Script MT", Font.ITALIC, 200));
			g.drawString("La Boutique", 500, 120);
			g.drawImage(new ImageIcon("effiel tower resize.png").getImage(), 10, 200, null);
			g.drawImage(new ImageIcon("arc resize.png").getImage(), 1110, 350, null);
			g.drawImage(new ImageIcon("beret_250.png").getImage(), 40, 150, null);
			g.drawImage(new ImageIcon("Logo_690.png").getImage(), 500, 200, null);
			if (GTools.intersect(new Point(mx, my), new Rectangle(499, 199, 600, 600))) {
				g.setColor(new Color(255, 255, 255));

			} else {
				g.setColor(new Color(12, 32, 34));
			}
			BasicStroke thickerPen = new BasicStroke(3);
			g2d.setStroke(thickerPen);

			g.drawRect(499, 199, 600, 600);

		}
		if (screen == HOWTOUSE) {
			g.setColor(Color.white);
			g.fillRect(0, 0, 1900, 1080);
			g.setColor(new Color(12, 32, 34));
			g.setFont(new Font("New Times Roman", Font.CENTER_BASELINE, 40));
			g.drawString("How To Use La Boutique", 600, 70);
			g.drawString("use arrow keys to change the thickness of the brushes and erasers", 25, 700);
			g.drawImage(new ImageIcon("backButton_75.png").getImage(), 10, 10, null);
		}
		if (screen == CREATE) {
			Graphics2D g2d = (Graphics2D) g;

			BasicStroke thickPen = new BasicStroke(3);

			g.drawImage(pic, 0, 0, null);
			if (wheel == COL)
				g.drawImage(new ImageIcon("colour wheel.png").getImage(), 1300, 710, null);
			else if (wheel == BLA)
				g.drawImage(new ImageIcon("blackToWhiteChart.png").getImage(), 1300, 710, null);

			g.setColor(Color.WHITE);
			g.fillRect(300, 100, 920, 600);
			g.fillRect(30, 100, 200, 600);
			g.fillRect(1290, 100, 200, 600);
			g.fillRect(300, 730, 920, 100);

			g.setColor(Color.BLACK);
			g2d.setStroke(thickPen);
			g.drawRect(300, 100, 920, 600);
			g.drawRect(30, 100, 200, 600);
			g.drawRect(1290, 100, 200, 600);
			g.drawRect(300, 730, 920, 100);
			g.setColor(new Color(12, 32, 34));
			g.setFont(new Font("Palace Script MT", Font.ITALIC, 100));
			g.drawString("La Boutique", 600, 70);
			/*
			 * g.drawImage(new ImageIcon(".png").getImage(), 1300, 710, null);
			 * g.drawImage(new ImageIcon("colour wheel.png").getImage(), 1300, 710, null);
			 * g.drawImage(new ImageIcon("colour wheel.png").getImage(), 1300, 710, null);
			 * g.drawImage(new ImageIcon("colour wheel.png").getImage(), 1300, 710, null);
			 * g.drawImage(new ImageIcon("colour wheel.png").getImage(), 1300, 710, null);
			 * g.drawImage(new ImageIcon("colour wheel.png").getImage(), 1300, 710, null);
			 * g.drawImage(new ImageIcon("colour wheel.png").getImage(), 1300, 710, null);
			 */
			for (int i = 0; i < 13; i++) {
				if (b[i].hover(mx, my)) {
					g.setColor(new Color(12, 32, 34));
					b[i].draw(g);
				} else {
					g.setColor(new Color(90, 113, 137));
					b[i].draw(g);
				}
			}

			img = p.getpic();
			img = er.getpic();
			if (bl.active()) {
				img = bl.blur(img, Brush.BLUR);
				bl.active(false);
			}
			if (sh.active()) {
				img = sh.blur(img, Brush.SHARP);
				sh.active(false);
			}
			if (inv.active()) {
				img = inv.blur(img, Brush.INVERT);
				inv.active(false);
			}
			er.draw(g, mx, my, img);
			p.draw(g, mx, my, img);

		}
	}
}
