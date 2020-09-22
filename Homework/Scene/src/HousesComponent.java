/**
 *      Class: CSSE220
 *      Author: Evan Sellers
 *      Usage: Create the house scene
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

/**
 * Draws some Houses on a graphics area.
 * 
 * @author Matt Boutell
 */
public class HousesComponent extends JComponent {

	/**
	 * Draws Houses.
	 */
	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D graphics2 = (Graphics2D) graphics;

		House house = new House(200, 100, Color.RED);
		house.drawOn(graphics2);

		// I found the RGB values for the aqua color from colorpicker.com
		Color aqua = new Color(50, 230, 92);
		House house2 = new House(50, 250, aqua);
		house2.drawOn(graphics2);
		
	}
}
