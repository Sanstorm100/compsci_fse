
import java.awt.*;
import javax.swing.*;

class Button extends JFrame {
    int x, y, length, width;
    String name;
    Rectangle rect;
    Boolean b;

    public Button(int x1, int y1, String s, int l, int w) {
        x = x1;
        y = y1;
        name = s;
        length = l;
        width = w;
        rect = new Rectangle(x, y, width, length);
    }

    public boolean hover(int x, int y) {
        Point p = new Point(x, y);
       return GTools.intersect(p, rect);
    }

    public void draw(Graphics g) {
        g.fillRect(x, y, width, length);

        g.setFont(new Font(" Times New Roman", Font.BOLD, 50));

        g.drawString(name, x + 30, y + 65);
    }

}
