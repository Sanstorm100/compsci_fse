
import java.awt.*;
import javax.swing.*;
class Button extends JFrame {
    boolean ouPut;
    int x,y;
    String name;
    
public Button(int x1, int y1,String s){
x=x1;
y=y1;
name =s;
}


public void draw (Graphics g){
    g.setColor(Color.GREEN);
    g.fillRect(x,y,10,10);
    g.drawString(name , x, y);
}

}
