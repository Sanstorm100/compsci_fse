import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.*;


public class Brush extends JFrame {
    final static int UP = 0, DOWN = 1, SHARP=0 ,BLUR=1;
    int size;
    private int x, y;
    private boolean active, start;
    private BufferedImage img;
    Color color = new Color(0, 0, 0);;
    Graphics g2;

    public Brush(int mx, int my) {
        x = mx - 300;
        y = my - 100;
        img = new BufferedImage(920, 600, BufferedImage.TYPE_INT_ARGB);
        size = 20;

    }

    public void  active(boolean t) {
        active = t;
       
    }
    
    public boolean active() {
        return active;
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
    public BufferedImage  blur(BufferedImage bufferedImage, int i){
        if(i==1){
        
    Kernel kernel = new Kernel(3, 3, new float[] { 1f / 9f, 1f / 9f, 1f / 9f,
        1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f });
    BufferedImageOp op = new ConvolveOp(kernel);
    return bufferedImage = op.filter(bufferedImage, null);
        }
        else{
            Kernel kernel = new Kernel(3, 3, new float[] {  0,  -1,  0,
                 -1,  5, -1, 0,  -1,  0 });
            BufferedImageOp op = new ConvolveOp(kernel);
            return bufferedImage = op.filter(bufferedImage, null);
        }

        
    }

    public void pickColor() {
        Rectangle rect = new Rectangle(1300, 710, 200, 290);

        if (GTools.intersect(MouseInfo.getPointerInfo().getLocation(), rect)) {
            try {
                Robot robot = new Robot();

                Point mouse = MouseInfo.getPointerInfo().getLocation();

                color = robot.getPixelColor((int) mouse.getX(), (int) mouse.getY());

            } catch (AWTException e) {
                e.printStackTrace();
            }
        }

    }

    public void pickColor(Color c) {
        color = c;
    }

    public BufferedImage getpic() {
        return img;
    }

    public void draw(Graphics g, int x1, int y1, BufferedImage pic) {
        img = pic;
        int mx = x1 - 300;
        int my = y1 - 100;
        g2 = img.getGraphics();
        g2.setColor(color);

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
