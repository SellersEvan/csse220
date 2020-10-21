package clicksProblem;
import java.awt.Graphics;

public interface ShapeAbstract {
    int getX();
    int getY();
    void setX( int x );
    void setY( int y );
    void draw( Graphics g );
}