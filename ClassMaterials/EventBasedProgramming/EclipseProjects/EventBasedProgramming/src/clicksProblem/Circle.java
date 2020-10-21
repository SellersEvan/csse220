package clicksProblem;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;


public class Circle implements ShapeAbstract {

    private int x;
    private int y;
    private int radius;

    public Circle( int x, int y, int radius ) {
        this.x      = x;
        this.y      = y;
        this.radius = radius;
    }

    public Circle( int x, int y ) {
        this( x, y, 10 ); 
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void draw( Graphics g ) {
        Graphics2D g2 = ( Graphics2D ) g;
        Color preColor = g2.getColor();
        g2.setColor( Color.blue );
        g2.translate( x - ( radius / 2 ), y - ( radius / 2 ) );
        g2.fillOval( 0, 0, radius, radius );
        g2.translate( ( radius / 2 ) - x, ( radius / 2 ) - y );
        g2.setColor( preColor );
    }
    
}
