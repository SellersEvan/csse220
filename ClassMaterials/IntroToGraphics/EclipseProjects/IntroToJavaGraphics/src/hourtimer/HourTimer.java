package hourtimer;
import java.awt.Graphics2D;
import java.awt.Color;



/**
 * Represents a circular clock with a single hand--a minute hand.
 *
 * @author TODO Evan Sellers
 *         Created Dec 18, 2013.
 */
public class HourTimer {

	
	public static final int DEFAULT_RADIUS = 300;
	public static final int DEFAULT_CENTER_X = 300;
	public static final int DEFAULT_CENTER_Y = 300;
	public static final double RATIO_OF_HAND_LENGTH_TO_RADIUS = .9;
	public static final double RATIO_OF_HAND_WIDTH_TO_RADIUS  = .1;
	public static final double RATIO_OF_BORDER_TO_RADIUS      = .05;

	private int radius;
	private int center_x;
	private int center_y;
	private double time = 0.0;

	public HourTimer( int center_x, int center_y, int radius ) {
		this.radius   = radius;
		this.center_x = center_x;
		this.center_y = center_y;
	}
	
	public HourTimer() {
		this( DEFAULT_CENTER_X, DEFAULT_CENTER_Y, DEFAULT_RADIUS );
	}

	/**
	 * Draws the timer
	 * 
	 * @param g the graphics object to draw on
	 */
	public void drawOn(Graphics2D g) {
		g.translate( center_x / 2, center_y / 2 );
		g.fillOval( 0, 0, radius, radius );
		g.setPaint( Color.WHITE );
		g.fillOval( ( int )( ( radius * RATIO_OF_BORDER_TO_RADIUS ) / 2 ),
					( int )( ( radius * RATIO_OF_BORDER_TO_RADIUS ) / 2 ),
					radius - ( int )( radius * RATIO_OF_BORDER_TO_RADIUS ),
					radius - ( int )( radius * RATIO_OF_BORDER_TO_RADIUS )
				);
		g.setPaint( Color.BLACK );
		g.translate( -center_x / 2, -center_y / 2 );

		g.translate( center_x / 2 + radius / 2, center_y / 2 + radius / 2 );
		g.rotate( Math.toRadians( 180 + ( ( time / 60 ) * 360 ) ) );
		g.drawRect( ( int )( - radius * RATIO_OF_HAND_WIDTH_TO_RADIUS / 2 ),	// x
					( int ) 0,													// y
					( int )( radius * RATIO_OF_HAND_WIDTH_TO_RADIUS ),			// width
					( int )( radius / 2 * RATIO_OF_HAND_LENGTH_TO_RADIUS )		// height
				);
		g.rotate( - Math.toRadians( 180 + ( ( time / 60 ) * 360 ) ) );
		g.translate( - center_x / 2 - radius / 2, - center_y / 2 - radius / 2 );
	}
	
	/**
	 * 
	 * Set time sets the position of the hand of the clock.
	 * 0/60 puts the hand facing upwards.
	 * 30 puts the hand facing downwards, etc.  
	 * 
	 * @param minutes the number of minutes to represent with rotation
	 */
	public void setTime( double minutes ) {
		this.time = minutes;
	}
	
}
