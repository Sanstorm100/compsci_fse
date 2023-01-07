import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Set extends JPanel implements KeyListener, ActionListener, MouseListener {
	private boolean[] keys;
	Timer timer;
	Image pic;

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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
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
	}
}
