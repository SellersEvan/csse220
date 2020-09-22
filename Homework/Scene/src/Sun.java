/**
 *      Class: CSSE220
 *      Author: Evan Sellers
 *      Usage: Create and draw the sun
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;

public class Sun {
    
    // Static Constant
    private static final Color  BORDER_COLOR                = Color.BLACK;      // border color of the sun
    private static final int    NUMBER_OF_RAYS              = 8;                // total numbers of rays on sun
    private static final double RAY_LENGTH_SCALE            = 0.5;              // length of ray ratio based on radius
    private static final double RAY_WIDTH_SCALE             = 0.1;              // width of ray ratio based on radius
    private static final double RAY_DISTANCE_FROM_SUN_SCALE = .2;               // distance from main circle ratio based on radius

    // Defaults
    public static final double DEFAULT_SUN_DIAMETER         = 100.0;            // Diameter of the sun
    public static final double DEFAULT_SUN_X                = 100.0;            // x pos of the sun from TL
    public static final double DEFAULT_SUN_Y                = 100.0;            // y pos of the sun from TL
    public static final Color  DEFAULT_SUN_COLOR            = Color.YELLOW;     // color of the sun

    // Object Properties
    private int x;              // x pos from TL
    private int y;              // y pos from TL
    private int diameter;       // diameter of the sun
    private Color color;        // Color of the sun

    /** SUN CONSTRUCTOR (PUBLIC)
     *  The main method to create the and init the varibles
     * 
     * @param x { int } x pos of sun from TL
     * @param y { int } y pos of sun from TL
     * @param diameter { int } diameter of the sun
     * @param color { Color } color of the sun
     */
    public Sun( int x, int y, int diameter, Color color ) {
        this.x        = x;
        this.y        = y;
        this.diameter = diameter;
        this.color    = color;
    }

    /** SUN CONSTRUCTOR (OVERLOADED)
     *  The main method to create the and init the varibles
     */
    public Sun() {
        this( ( int ) DEFAULT_SUN_X, ( int ) DEFAULT_SUN_Y, ( int ) DEFAULT_SUN_DIAMETER, DEFAULT_SUN_COLOR );
    }

    public void drawOn( Graphics2D g2 ) {
        Paint prePaint = g2.getPaint();
        g2.translate( x, y );
        g2.setPaint( color );

        g2.fillOval( 
                0,          // x
                0,          // y
                diameter,   // width
                diameter    // height
            );

        g2.setPaint( Color.BLACK );

        g2.drawOval( 
                0,          // x
                0,          // y
                diameter,   // width
                diameter    // height
            );

        g2.setPaint( color );
        g2.translate( diameter / 2, diameter / 2 );

        for ( int _ray = 0; _ray < NUMBER_OF_RAYS; _ray++ ) {
            g2.fillRect(
                    ( int )( ( diameter / 2 ) + ( diameter * RAY_DISTANCE_FROM_SUN_SCALE ) ), 
                    ( int )( - ( diameter * RAY_WIDTH_SCALE ) / 2 ),
                    ( int )( diameter * RAY_LENGTH_SCALE ),
                    ( int )( diameter * RAY_WIDTH_SCALE )
                );
            g2.setPaint( Color.BLACK );
            g2.drawRect(
                    ( int )( ( diameter / 2 ) + ( diameter * RAY_DISTANCE_FROM_SUN_SCALE ) ), 
                    ( int )( - ( diameter * RAY_WIDTH_SCALE ) / 2 ),
                    ( int )( diameter * RAY_LENGTH_SCALE ),
                    ( int )( diameter * RAY_WIDTH_SCALE )
                );
            g2.setPaint( color );
            g2.rotate( Math.toRadians( 360 / NUMBER_OF_RAYS ) );
        }

        g2.setPaint( prePaint );
        g2.translate( - ( x + (  diameter / 2 ) ), - ( y + (  diameter / 2 ) ) );
    }
}
