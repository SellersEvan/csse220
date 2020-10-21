package addlettersProblem;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddLettersViewer {

	private static char[] letters = new char[]{ 'A', 'B', 'C' };
	private String currentText = "> ";

	public static void main(String[] args) {
		new AddLettersViewer();
	}
	
	public AddLettersViewer() {	
		JFrame frame     = new JFrame();
		JPanel buttonRow = new JPanel();
		JLabel textLabel = new JLabel( currentText );

		for ( char letter : letters ) {
			JButton letterButton = new JButton( "Add " + letter );
			letterButton.addActionListener( new ActionListener() {
				public void actionPerformed( ActionEvent e ) {
					currentText += letter;
					textLabel.setText( currentText );
				}
			});
			buttonRow.add( letterButton );
		}

		frame.add( buttonRow, BorderLayout.SOUTH );
		frame.add( textLabel, BorderLayout.NORTH );

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
