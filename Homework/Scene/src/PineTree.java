/**
 *      Class: CSSE220
 *      Author: Evan Sellers
 *      Usage: Create and draw a pine tree
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;

public class PineTree {

    private static double TRUNK_WIDTH_RATIO  = ( 1.0 / 3.0 );                 // Ratio of width of the trunk
    private static double TRUNK_HEIGHT_RATIO = ( 1.0 / 3.0 );                 // Ratio of height of trunk 
    private static Color  TRUNK_COLOR_BROWN  = new Color( 145, 112, 33 );     // Brown of the tree for the trunk
    private static Color  BRANCH_COLOR_GREEN = new Color( 40, 135, 22 );      // Green of the tree for the branches

    private int x;          // X pos of Tree from TL
    private int y;          // Y pos of Tree from TL
    private int width;      // Width of the tree
    private int height;     // Height of the tree

    /** PINE TREE CONSTUCTOR (PUBLIC)
     * Main class to define the varibles for the pine tree
     * 
     * @param x { int } the x pos of the tree from TL
     * @param y { int } the y pos of the tree from TL
     * @param width { int } width of the tree
     * @param height { int } height of the tree
     */
    public PineTree( int x, int y, int width, int height ) {
        this.x      = x;
        this.y      = y;
        this.width  = width;
        this.height = height;
    }

    public void drawOn( Graphics2D g2 ) {
        Paint prePaint = g2.getPaint();
        g2.translate( x, y );
        
        // Draw Trunk
        g2.setPaint( TRUNK_COLOR_BROWN );
        g2.fillRect(
                ( int )( ( width - ( width * TRUNK_WIDTH_RATIO ) ) / 2 ),   // x
                ( int )( ( height - ( height * TRUNK_HEIGHT_RATIO ) ) ),    // y
                ( int )( width * TRUNK_WIDTH_RATIO ),                       // width
                ( int )( height * TRUNK_HEIGHT_RATIO )                      // height
            );

        // Draw Branches
        g2.setPaint( BRANCH_COLOR_GREEN );
        g2.fillPolygon( 
                new int[] {
                    0,                                                      // x0
                    ( int )( width / 2 ),                                   // x1
                    width                                                   // x2
                },
                new int[] {
                    ( int )( height - ( height * TRUNK_HEIGHT_RATIO ) ),    // y0
                    0,                                                      // y1
                    ( int )( height - ( height * TRUNK_HEIGHT_RATIO ) ),    // y2
                },
                3
            );

		g2.setPaint( prePaint );
		g2.translate( - x, - y );
    }
}
