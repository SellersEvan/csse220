/**
 *      Class: CSSE220
 *      Author: Evan Sellers
 *      Usage: display pine tree test scene
 */

import java.awt.Dimension;
import javax.swing.JFrame;

public class PineTreeViewer {
	public static final Dimension PINETREE_VIEWER_SIZE = new Dimension(500, 400);
	
    // Display Pine Tree
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setSize( PINETREE_VIEWER_SIZE );
		frame.setTitle( "I see PineTree!" );

		frame.add( new PineTreeComponent() );

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
