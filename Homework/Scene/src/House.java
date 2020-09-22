/**
 *      Class: CSSE220
 *      Author: Evan Sellers
 *      Usage: create and draw a house
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;

public class House {
	private static final int HEIGHT = 50;
	private static final int WIDTH = 100;
	private static final int ROOF_HEIGHT = 20;

	private int x;
	private int y;
	private Color color;

	public House(int x, int y, Color color) {
		this.x     = x;
		this.y 	   = y;
		this.color = color;
	}

	public void drawOn(Graphics2D g2) {
		Paint prePaint = g2.getPaint();
		g2.translate( x, y );
		g2.setPaint( color );
		g2.fillRect( 0, ROOF_HEIGHT, WIDTH, HEIGHT );
		g2.drawLine( 0, ROOF_HEIGHT, WIDTH / 2, 0 );
		g2.drawLine( WIDTH, ROOF_HEIGHT, WIDTH / 2, 0 );
		g2.setPaint( prePaint );
		g2.translate( - x, - y );
	}

}
