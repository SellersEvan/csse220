/*
 *   Edited by Evan Sellers <sellersew@gmail.com> on
 *   behalf of Rose-Hulman Institute of Technology
 *
 *   author: Evan Sellers <sellersew@gmail.com>
 *   date: Sun Oct 18 2020
 *   original: N/A
 *   file: Tracker.java
 *   project: Ball Strike Counter GUI
 *   purpose: N/A
 *
 */


package ballStrikeCounter;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tracker {
	private JLabel label = new JLabel();

	// Call this to update the text on the label.
	public void updateLabel(int numBalls, int numStrikes) {
		this.label.setText("<html>Balls: " + numBalls + "<br />Strikes: " + numStrikes + "</HTML>");
	}

	public static void main(String[] args) {
		new Tracker();
	}

	public Tracker() {
		JFrame frame   = new JFrame();
		JPanel panel   = new JPanel();
		Count  counter = new Count();

		frame.add(label, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		
		// Add Ball
		JButton addBall = new JButton( "Add Ball" );
		panel.add( addBall );
		addBall.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent event ) {
				updateLabel( counter.addBall(), counter.getStrikes() );
			}
		});

		// Add Ball
		JButton addStrike = new JButton( "Add Strike" );
		panel.add( addStrike );
		addStrike.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent event ) {
				counter.addStrike();
				updateLabel( counter.getBalls(), counter.getStrikes() );
			}
		});

		// The following line is given to show you how to use the given method:
		updateLabel(0, 0);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
