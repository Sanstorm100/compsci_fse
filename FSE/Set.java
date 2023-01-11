import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Set extends JPanel implements KeyListener, ActionListener, MouseListener {
	private boolean[] keys;
	Timer timer;
	Image pic;
	private int mx, my;
	Button[] b = new Button[20];

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
		for (int i = 0; i < 5; i++) {
			b[i] = new Button(40, 130 + (i * 110), "idk", 100, 180);
			b[i + 5] = new Button(1300, 130 + (i * 110), "idk", 100, 180);
			b[i + 10] = new Button(320 + (i * 180), 750, "idk", 70, 150);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if (isShowing()) {
			Point mouse = MouseInfo.getPointerInfo().getLocation();
			Point offset = getLocationOnScreen();
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

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
			if (b[14].hover(mx, my)) {
Upload f= new Upload();
			}
		

	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		BasicStroke thickPen = new BasicStroke(3);

		g.drawImage(pic, 0, 0, null);
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
		for (int i = 0; i < 15; i++) {
			if (b[i].hover(mx, my)) {
				g.setColor(new Color(12, 32, 34));
				b[i].draw(g);
			} else {
				g.setColor(new Color(90, 113, 137));
				b[i].draw(g);
			}

		}
	}
}
