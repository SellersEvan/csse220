package clicksProblem;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Square implements ShapeAbstract {

    private int x;
    private int y;
    private int width;

    public Square( int x, int y, int width ) {
        this.x      = x;
        this.y      = y;
        this.width = width;
    }

    public Square( int x, int y ) {
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
        g2.setColor( Color.red );
        g2.translate( x - ( width / 2 ), y - ( width / 2 ) );
        g2.fillRect( 0, 0, width, width );
        g2.translate( ( width / 2 ) - x, ( width / 2 ) - y );
        g2.setColor( preColor );
    }
    
}
