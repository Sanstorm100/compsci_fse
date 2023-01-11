import javax.swing.*;
import java.awt.*;


public class Brush extends JFrame {
    BufferedImage b= new BrushBufferedImage(10,10);
    int x,y;
    public Brush( int x1, int y1){
x=x1;
y=y1;

    }
    public void paint(Graphics g) {
g.drawArc(x, y, 20, 20, 0, 100);
    }
    
}


