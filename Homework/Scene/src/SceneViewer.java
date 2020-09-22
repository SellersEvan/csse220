/**
 *      Class: CSSE220
 *      Author: Evan Sellers
 *      Usage: Create Scene Viewer for main scene
 */

import java.awt.Dimension;
import javax.swing.JFrame;

public class SceneViewer {
	public static final Dimension SCENE_VIEWER_SIZE = new Dimension( 750, 600 );
	
    // Display Full Scene
	public static void main( String[] args ) {
		JFrame frame = new JFrame();

		frame.setSize( SCENE_VIEWER_SIZE );
		frame.setTitle( "I have Scene this before!" );

		frame.add( new SceneComponent() );

		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setVisible( true );
	}
}
