/**
 *      Class: CSSE220
 *      Author: Evan Sellers
 *      Usage: Place Smily Faces
 */

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

// Draw a smily face
public class FaceComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D graphics2 = (Graphics2D) graphics;

		Face face = new Face();
		face.drawOn( graphics2 );

		Face face2 = new Face( 50 );
		face2.rotate( 45 );
		face2.translate( 300, 300 );
		face2.drawOn( graphics2 );

	}
}
