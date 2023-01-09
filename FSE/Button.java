
import java.awt.*;
import javax.swing.*;
class Button extends JFrame {
    int x,y;
    String name;
    Rectangle rect;
    
    
public Button(int x1, int y1,String s){
x=x1;
y=y1;
name =s;
}


public void draw (Graphics g){
    g.setColor(Color.BLACK);
    g.drawRect(x,y,180,100);
    g.setFont(new Font(" Times New Roman", Font.BOLD, 50));

    g.drawString(name , x+30, y+65);
}

}
