import java.awt.*;
import java.util.ArrayList;



class GTools {
    public GTools() {
    }

    public static boolean intersect(Point p, Rectangle rect) {
        return p.getX() >= rect.getX() && p.getY() >= rect.getY()
        && p.getX()<=rect.getMaxX() && p.getY()<=rect.getMaxY();
    }
    public static ArrayList <Integer> convo(){
        ArrayList <Integer> output= new ArrayList <Integer>();
         
        return output;
    }

}
