package slides;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * This class demonstrates ActionListeners.
 * 
 * @author Curt Clifton. Created Oct 7, 2008.
 */
public class BreakfastMain {

	/**
	 * Starts the program.
	 * 
	 * @param args
	 *            ignored
	 */
	public static void main(String[] args) {
		// Note that it's a little complicated to create inner classes
		// if you're in a static function.  To avoid a bit of this 
		// complexity, we're initializing an instance of a class.
		BreakfastMain main = new BreakfastMain();
		main.createWindows();
	}
	
	
	public void createWindows() {
		/*
		 * TODO: Use JOptionPane to get description of porridge flavor; update
		 * inner classes to use the String.
		 */
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setTitle("Breakfast for Goldilocks");

		// Regular Class
		JButton eatButton = new JButton("Eat Porridge");
		panel.add(eatButton);
		ActionListener ear = new MyListener( frame );
		eatButton.addActionListener( ear );

		// Inclass
		JButton eatButton2 = new JButton("Eat Porridge Inclass");
		panel.add( eatButton2 );
		ActionListener ear2 = new MyListener2( frame );
		eatButton2.addActionListener( ear2 );

		// Anonymous
		JButton eatButton3 = new JButton( "Eat Porridge anonymous" );
		panel.add( eatButton3 );
		eatButton3.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				System.out.println( "To Hot!" );
				frame.setTitle( "To Hot!" );
			}
		});

		frame.add( panel, BorderLayout.SOUTH );

		/*
		 * CONSIDER: pack() sets the size of the frame based on what we've put
		 * in it:
		 */
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private class MyListener2 implements ActionListener {
		private JFrame frame;

		public MyListener2( JFrame frame ) {
			this.frame = frame;
		}
	
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println( "To Hot!" );
			frame.setTitle( "To Hot!" );
		}
	}
	


}
