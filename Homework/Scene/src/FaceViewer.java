/**
 *      Class: CSSE220
 *      Author: Evan Sellers
 *      Usage: View the scene of faces
 */

import java.awt.Dimension;
import javax.swing.JFrame;

public class FaceViewer {
	public static final Dimension FACE_VIEWER_SIZE = new Dimension( 800, 600 );
	
    // Display Face
	public static void main( String[] args ) {
		JFrame frame = new JFrame();

		frame.setSize( FACE_VIEWER_SIZE );
		frame.setTitle( "I see that Face!" );

		frame.add( new FaceComponent() );

		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setVisible( true );
	}
}
