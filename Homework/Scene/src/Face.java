/**
 *      Class: CSSE220
 *      Author: Evan Sellers
 *      Usage: Create and draw a smily face
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;

public class Face {

    // Statics
    private static final double MOUTH_RATIO_RADIUS      = 0.7;    // the mouth ratio to the the head radius
    private static final double EYE_RATIO_RADIUS        = 0.28;   // the eye ratio to the head radius
    private static final double EYE_OFFSET_RATIO_RADIUS = 0.5;    // the distance from the center for the eye
    private static final double EYE_RIGHT_POS           = 45.0;   // the degree location of the right eye
    private static final double EYE_LEFT_POS            = -45.0;  // the degree location of the right eye
    private static final double MOUTH_START_POS         = 195.0;   // the starting position of the mouth
    private static final double MOUTH_END_POS           = 150.0;  // the ending position of the mouth


    // Defualts
    private static final int   POS_X            = 0;              // Default X pos relative to TL
    private static final int   POS_Y            = 0;              // Default Y pos relative to TL
    private static final int   RADIUS           = 100;            // Defualt Radius
    private static final int   DEG_ROTATION     = 0;              // Default Rotation in Degrees
    private static final Color EYE_COLOR        = Color.BLACK;    // Default Eye Color
    private static final Color MOUTH_COLOR      = Color.BLACK;    // Default Mouth Color
    private static final Color OUTLINE_COLOR    = Color.BLACK;    // Default Mouth Color
    private static final Color BACKGROUND_COLOR = Color.YELLOW;   // Defautl Background Color

    // Storage
	private int   x;
    private int   y;
    private int   radius;
    private int   rotation;
    private Color eyeColor;
    private Color mouthColor;
    private Color outlineColor;
    private Color backgroundColor;
    

    /** CONSTUCTOR MAIN (PUBLIC)
     *  Use all default values
     */
	public Face() {
		this.x               = POS_X;
        this.y 	             = POS_Y;
        this.radius          = RADIUS;
        this.rotation        = DEG_ROTATION;
        this.eyeColor        = EYE_COLOR;
        this.mouthColor      = MOUTH_COLOR;
        this.outlineColor    = OUTLINE_COLOR;
        this.backgroundColor = BACKGROUND_COLOR;
    }

    /** CONSTUCTOR OVERLOADED (PUBLIC)
     * 
     * @param radius { int }
     */
    public Face( int radius ) {
        this();
        this.radius = radius;
    }
    
    /** SET FACE POSITION (PUBLIC)
     * 
     * @param x { double }
     * @param y { double }
     */
    public void translate( double x, double y ) {
        this.x = ( int )( x );
        this.y = ( int )( y );
    }

    /** ROTATE FACE (PUBLIC)
     * 
     * @param deg { double }
     */
    public void rotate( double deg ) {
        this.rotation = ( int )( deg );
    }

    /** DRAW ON (PUBLIC)
     * 
     * @param g2 { Graphics2D }
     */
	public void drawOn( Graphics2D g2 ) {
        Paint prePaint = g2.getPaint();
        g2.translate( x, y );
        g2.rotate( Math.toRadians( rotation ) );
        
        // Main Body
        g2.setPaint( backgroundColor );
        g2.fillOval( 0, 0, radius * 2, radius * 2 );
        g2.setPaint( outlineColor );
        g2.drawOval( 0, 0, radius * 2, radius * 2 );


        // Eyes Right
        g2.translate( radius, radius );
        g2.setPaint( eyeColor );
        g2.rotate( Math.toRadians( EYE_RIGHT_POS ) );
        g2.fillOval( 
                ( int )( - EYE_RATIO_RADIUS * radius ),
                ( int )( - EYE_OFFSET_RATIO_RADIUS * radius - EYE_RATIO_RADIUS * radius ),
                ( int )( EYE_RATIO_RADIUS * radius * 2 ),
                ( int )( EYE_RATIO_RADIUS * radius * 2 )
            );
        g2.rotate( - Math.toRadians( EYE_RIGHT_POS ) );
        g2.translate( - radius, - radius );

        // Eyes LEFT
        g2.translate( radius, radius );
        g2.setPaint( eyeColor );
        g2.rotate( Math.toRadians( EYE_LEFT_POS ) );
        g2.fillOval( 
                ( int )( - EYE_RATIO_RADIUS * radius ),
                ( int )( - EYE_OFFSET_RATIO_RADIUS * radius - EYE_RATIO_RADIUS * radius ),
                ( int )( EYE_RATIO_RADIUS * radius * 2 ),
                ( int )( EYE_RATIO_RADIUS * radius * 2 )
            );
        g2.rotate( - Math.toRadians( EYE_LEFT_POS ) );
        g2.translate( - radius, - radius );


        // draw mouth
        g2.translate( radius, radius );
        g2.setPaint( mouthColor );
        g2.drawArc(
                ( int )( - radius * MOUTH_RATIO_RADIUS ),
                ( int )( - radius * MOUTH_RATIO_RADIUS ),
                ( int )( radius * MOUTH_RATIO_RADIUS * 2 ),
                ( int )( radius * MOUTH_RATIO_RADIUS * 2 ),
                ( int )( MOUTH_START_POS ),
                ( int )( MOUTH_END_POS )
            );
        g2.drawLine( 
                ( int )( Math.cos( Math.toRadians( MOUTH_START_POS ) ) * radius * MOUTH_RATIO_RADIUS ),
                ( int )( - Math.sin( Math.toRadians( MOUTH_START_POS ) ) * radius * MOUTH_RATIO_RADIUS ),
                ( int )( - Math.cos( Math.toRadians( MOUTH_START_POS ) ) * radius * MOUTH_RATIO_RADIUS ),
                ( int )( - Math.sin( Math.toRadians( MOUTH_START_POS ) ) * radius * MOUTH_RATIO_RADIUS )
            );
        g2.translate( - radius, - radius );

        g2.rotate( - Math.toRadians( rotation ) );
        g2.translate( - x, - y );
        g2.setPaint( prePaint );
	}

}
