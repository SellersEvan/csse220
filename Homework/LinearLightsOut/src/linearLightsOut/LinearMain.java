/*
 *   Edited by Evan Sellers <sellersew@gmail.com> on
 *   behalf of Rose-Hulman Institute of Technology
 *
 *   author: Evan Sellers <sellersew@gmail.com>
 *   date: Sun Oct 18 2020
 *   original: Jan 18, 2010.
 *   file: LinearMain.java
 *   project: Runs the Linear Lights Out application.
 *   purpose: N/A
 *
 */

package linearLightsOut;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LinearMain {

	public static void main(String[] args) {
		String nButtonsString = JOptionPane.showInputDialog("How many buttons would you like?");
		int nButtons = Integer.parseInt(nButtonsString);

		Game gameBoard      = new Game(nButtons);
		JButton[] switches  = new JButton[nButtons];
		JFrame myFrame      = new JFrame();
		JPanel boardPanel   = new JPanel();
		JPanel controlPanel = new JPanel();

		// New Game Button
		JButton newGameBtn = new JButton("New Game");
		controlPanel.add( newGameBtn );
		newGameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				gameBoard.init();
				updateButtons( switches, gameBoard );
			}
		});

		// Quit Button
		JButton quitBtn = new JButton("Quit");
		controlPanel.add(quitBtn);
		quitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				myFrame.setVisible(false);
				myFrame.dispose();
			}
		});

		// Add Buttons
		for (int i = 0; i < switches.length; i++) {
			switches[i] = new JButton( gameBoard.getGame()[ i ] + "" );
			switches[i].putClientProperty("id", i);
			boardPanel.add( switches[i] );
			switches[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					gameBoard.takeTurn((int) ((JButton) event.getSource()).getClientProperty("id"));
					updateButtons( switches, gameBoard );
					if ( gameBoard.hasWon() )
						JOptionPane.showMessageDialog( null, 
                              "You have won!", 
                              "Linear Lights Out!", 
                              JOptionPane.PLAIN_MESSAGE );
				}
			});
		}

		// Build Frame
		myFrame.add( boardPanel, BorderLayout.CENTER );
		myFrame.add( controlPanel, BorderLayout.SOUTH );
		myFrame.setTitle( "Linear Lights Out!" );
		myFrame.pack();
		myFrame.setVisible( true );
	}


	// Update Button
	public static void updateButtons( JButton[] switches, Game board ) {
		for (int i = 0; i < switches.length; i++)
			switches[ i ].setText( board.getGame()[ i ] + "" );
	}
}
