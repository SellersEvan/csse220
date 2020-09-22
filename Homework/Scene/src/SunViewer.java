/**
 *      Class: CSSE220
 *      Author: Evan Sellers
 *      Usage: display test scene for sun scene
 */

import java.awt.Dimension;
import javax.swing.JFrame;

public class SunViewer {
	public static final Dimension SUN_VIEWER_SIZE = new Dimension( 800, 600 );
	
    // Display Sun
	public static void main( String[] args ) {
		JFrame frame = new JFrame();

		frame.setSize( SUN_VIEWER_SIZE );
		frame.setTitle( "I see Sun!" );

		frame.add( new SunComponent() );

		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setVisible( true );
	}
}
