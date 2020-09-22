/**
 *      Class: CSSE220
 *      Author: Evan Sellers
 *      Usage: Create test scene for Sun
 */

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class SunComponent extends JComponent {

    // little sun constants
    private static final int LITTLE_SUNS_X_OFFSET            = 50;               // x offset for the little sun
    private static final int LITTLE_SUNS_Y_OFFSET            = 400;              // y offset for the little sun
    private static final int NUM_LITTLE_SUNS                 = 5;                // number of little suns
    private static final int LITTLE_SUN_DIAMETER             = 35;               // diameter of the little sun
    private static final int LITTLE_SUN_SEPARATION           = 100;               // seperatation between each sun
    private static final Color LITTLE_SUN_COLOR              = Color.RED;        // color of the little sun


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
   
        // Get the 2D graphics object
        Graphics2D g2 = ( Graphics2D )g;
        // Create a Sun using the default (parameterless) constructor, 
        // then draw it to the frame
        Sun s = new Sun();
        s.drawOn(g2);
   
        // Draw a rectangle around the default sun
        g2.drawRect(30, 30, 240, 240);
   
        // Draw a rectangle around a new sun in a particular position
        s = new Sun(550, 100, 50, Color.BLUE);
        s.drawOn(g2);
        g2.drawRect(515, 65, 120, 120);
   
        // Draw little suns
        int x = LITTLE_SUNS_X_OFFSET;
        for (int i = 0; i < NUM_LITTLE_SUNS; i++) {	
            s = new Sun(
                    x,
                    LITTLE_SUNS_Y_OFFSET,
                    LITTLE_SUN_DIAMETER,
                    LITTLE_SUN_COLOR
                );
            s.drawOn(g2);
            x+= LITTLE_SUN_SEPARATION;
        }
    }	

}
