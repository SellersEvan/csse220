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
public class TranslateComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.translate( ( getWidth() / 2 - 100 ), ( getHeight() / 2 - 75 ) );
		g2.drawRect(0, 0, 200, 150);
		g2.drawRect(20, 20, 50, 50);
		g2.drawRect(130, 20, 50, 50);
		g2.drawRect(60, 80, 80, 40);
		g2.translate( - ( getWidth() / 2 - 100 ), - ( getHeight() / 2 - 75 ) );		
	}
	



	
	
}
