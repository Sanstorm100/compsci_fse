import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Brush extends JFrame {
    final int UP = 0, DOWN = 1;
    int size;
    private int x, y;
    private boolean active, start;
    private BufferedImage img;

    public Brush(int mx, int my) {
        x = mx - 300;
        y = my - 100;
        img = new BufferedImage(920, 600, BufferedImage.TYPE_INT_ARGB);
        size = 20;
    }

    public boolean active(boolean t) {
        active = t;
        return t;
    }

    public void start(boolean t) {
        start = t;
    }

    public void brushSize(int l) {
        if (size != 0 && l == 1) {

            size -= 5;
        } else {
            size += 5;
        }
    }

    public void draw(Graphics g, int x1, int y1) throws AWTException {
        int mx = x1 - 300;
        int my = y1 - 100;
        Graphics g2 = img.getGraphics();
        g2.setColor(Color.black);

        Robot robot = new Robot();

        Point mouse = MouseInfo.getPointerInfo().getLocation();
        Color mColour = robot.getPixelColor((int) mouse.getX(), (int) mouse.getY());
        g2.setColor(mColour);

        if (start) {
            if (active) {
                double sx = (mx - x) / Math.hypot((mx - x), (my - y));
                double sy = (my - y) / Math.hypot((mx - x), (my - y));
                for (int i = 0; i < Math.hypot((mx - x), (my - y)); i++) {
                    g2.fillOval((int) (x + i * sx), (int) (y + i * sy), size, size);
                }
                g2.fillOval(mx, my, size, size);
            }
        }
        g.drawImage(img, 300, 100, null);
        x = mx;
        y = my;
    }

}
