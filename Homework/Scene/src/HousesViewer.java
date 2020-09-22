/**
 *      Class: CSSE220
 *      Author: Evan Sellers
 *      Usage: House Scene Viewer
 */

import java.awt.Dimension;
import javax.swing.JFrame;

public class HousesViewer {
	public static final Dimension HOUSES_VIEWER_SIZE = new Dimension(500, 400);
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setSize(HOUSES_VIEWER_SIZE);
		frame.setTitle("I see houses!");

		frame.add(new HousesComponent());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
