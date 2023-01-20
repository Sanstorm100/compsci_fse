import java.awt.*;



class GTools {
    public GTools() {
    }

    public static boolean intersect(Point p, Rectangle rect) {
        return p.getX() >= rect.getX() && p.getY() >= rect.getY()
        && p.getX()<=rect.getMaxX() && p.getY()<=rect.getMaxY();
    }


}
