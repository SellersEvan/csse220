/**
 *      Class: CSSE220
 *      Author: Evan Sellers
 *      Usage: Create Main Scene with components
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.GradientPaint;

public class SceneComponent extends JComponent {

    @Override
    protected void paintComponent( Graphics graphics ) {
        super.paintComponent( graphics );
        Graphics2D graphics2 = ( Graphics2D ) graphics;

        // Create Sky
        graphics2.setPaint( new GradientPaint( 10, 10, Color.decode( "#56CCF2" ), 10, 375, Color.decode( "#2F80ED" ) ) );
        graphics2.fillRect( 0, 0, 750, 375 );


        // Create Ground
        graphics2.setPaint( new GradientPaint( 10, 10, Color.decode( "#DCE35B" ), 10, 375, Color.decode( "#45B649" ) ) );
        graphics2.fillRect( 0, 375, 750, 600 );


        // Create Sun
        Sun sun = new Sun();
        sun.drawOn( graphics2 );


        // Back row of trees
        int   X_POS_BACK_TREES        = 150;               // X offset for back row trees
        int   Y_POS_BACK_TREES        = 335;               // Y offset for back row trees
        int[] Y_SEPERATION_BACK_TREES = { 5, 20 };         // Y Seperation range for each tree on back row tress
        int[] X_SEPERATION_BACK_TREES = { 10, 30 };        // X Seperation range for each tree on back row tress
        int   TOTAL_BACK_TREES        = 25;                // Total number of tress in back row
        int   WIDTH_BACK_TREES        = 10;                // width of back row trees
        int   HEIGHT_BACK_TREES       = 40;                // height of back row trees
        int   x_pos_current           = X_POS_BACK_TREES;  // Storage of current x pos

        for ( int _tree = 0; _tree < TOTAL_BACK_TREES; _tree++ ) {
            x_pos_current += getRandomNumber( X_SEPERATION_BACK_TREES[ 0 ], X_SEPERATION_BACK_TREES[ 1 ] );
            PineTree tree = new PineTree( 
                    x_pos_current,
                    ( int ) ( Y_POS_BACK_TREES + getRandomNumber( Y_SEPERATION_BACK_TREES[ 0 ], Y_SEPERATION_BACK_TREES[ 1 ] ) ),
                    WIDTH_BACK_TREES,
                    HEIGHT_BACK_TREES
                );
            tree.drawOn( graphics2 );
        }


        // Front row of trees
        int   X_POS_FRONT_TREES        = 150;               // X offset for front row trees
        int   Y_POS_FRONT_TREES        = 320;               // Y offset for front row trees
        int[] Y_SEPERATION_FRONT_TREES = { 0, 30 };         // Y Seperation range for each tree on front row tress
        int[] X_SEPERATION_FRONT_TREES = { 20, 40 };        // X Seperation range for each tree on front row tress
        int   TOTAL_FRONT_TREES        = 15;                // Total number of tress in front row
        int   WIDTH_FRONT_TREES        = 20;                // width of front row trees
        int   HEIGHT_FRONT_TREES       = 80;                // height of front row trees
              x_pos_current           = X_POS_FRONT_TREES;  // Storage of current x pos

        for ( int _tree = 0; _tree < TOTAL_FRONT_TREES; _tree++ ) {
            x_pos_current += getRandomNumber( X_SEPERATION_FRONT_TREES[ 0 ], X_SEPERATION_FRONT_TREES[ 1 ] );
            PineTree tree = new PineTree( 
                    x_pos_current,
                    ( int ) ( Y_POS_FRONT_TREES + getRandomNumber( Y_SEPERATION_FRONT_TREES[ 0 ], Y_SEPERATION_FRONT_TREES[ 1 ] ) ),
                    WIDTH_FRONT_TREES,
                    HEIGHT_FRONT_TREES
                );
            tree.drawOn( graphics2 );
        }


        // Row of Houses
        int   X_POS_HOUSES        = 30;                // X offset for front houses
        int   Y_POS_HOUSES        = 400;               // Y offset for front houses
        int[] Y_SEPERATION_HOUSES = { 0, 50 };         // Y Seperation range for each tree on front houses
        int[] X_SEPERATION_HOUSES = { 110, 150 };        // X Seperation range for each tree on front houses
        int   TOTAL_HOUSES        = 5;                 // Total number of houses in front row
              x_pos_current           = X_POS_HOUSES;  // Storage of current x pos

        for ( int _house = 0; _house < TOTAL_HOUSES; _house++ ) {
            House house = new House( 
                    x_pos_current,
                    ( int ) ( Y_POS_HOUSES + getRandomNumber( Y_SEPERATION_HOUSES[ 0 ], Y_SEPERATION_HOUSES[ 1 ] ) ),
                    Color.BLACK
                );
            house.drawOn( graphics2 );
            x_pos_current += getRandomNumber( X_SEPERATION_HOUSES[ 0 ], X_SEPERATION_HOUSES[ 1 ] );
        }

    }


    /** RANDOM NUMBER BETWEEN (PUBLIC)
     * @param min { int } the min number possible
     * @param max { int } the max number possible
     * @return { int } a randam number between min and max
     */
    public int getRandomNumber(int min, int max) {
        return ( int ) ( ( Math.random() * ( max - min ) ) + min );
    }

}
