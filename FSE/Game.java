
import java.awt.*;
import javax.swing.*;

class Game extends JFrame {
	Set n = new Set();
	Image logo = new ImageIcon("logo.png").getImage();

	public Game() {
		super("La Boutique");
		setIconImage(logo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(n);
		pack();
		setVisible(true);

	}

	public static void main(String[] arguments) {
		Game frame = new Game();
		frame.setResizable(false);
	}

}