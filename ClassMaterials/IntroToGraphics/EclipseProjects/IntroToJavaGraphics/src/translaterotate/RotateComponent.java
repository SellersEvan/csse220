package translaterotate;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

/**
 * Component on which to display HourTimer instances.
 *
 */
public class RotateComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		
		

	

		
		// TODO 1: Play with rotation so you get a feel how it works
		// 
		// TODO 2: Modify the code so that it rotates around the center
		// the face, rather than the upper left corner
		//
		// HINT: You'll have to adjust the way the drawing code
		// In particular, you'll have to draw centered at 0,0
		// not with 0,0 as the upper left corner
		// HINT 2: You may have to adjust the translate or the
		// Pink rectangle too
		double radiansToRotate = Math.toRadians( 30 );
		g2.translate(
				( int )( ( getWidth() / 2 - 100 ) + ( ( Math.sin( radiansToRotate ) * 200 ) / 2 ) ),
				( int )( ( getHeight() / 2 - 75 ) - ( ( Math.sin( radiansToRotate ) * 150 ) / 2 ) )
			);

		g2.rotate( radiansToRotate );

		// draws a face, with upper left hand corner 0 0
		// you need to edit this code for TODO2
		g2.drawRect(0, 0, 200, 150);
		g2.drawRect(20, 20, 50, 50);
		g2.drawRect(130, 20, 50, 50);
		g2.drawRect(60, 80, 80, 40);
		
		//WARNING: be sure to always undo any translations you may have done
		g2.rotate( - radiansToRotate );
		g2.translate(
				- ( int )( ( getWidth() / 2 - 100 ) + ( ( Math.sin( radiansToRotate ) * 200 ) / 2 ) ),
				- ( int )( ( getHeight() / 2 - 75 ) - ( ( Math.sin( radiansToRotate ) * 150 ) / 2 ) )
			);		
	}
	
	
}
