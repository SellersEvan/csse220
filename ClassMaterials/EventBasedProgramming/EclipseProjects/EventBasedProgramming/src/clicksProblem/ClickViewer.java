package clicksProblem;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class ClickViewer {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(400,600);
		
		ClickComponent component = new ClickComponent();
		
		//TODO: Create a clickListener that takes in a ClickComponent and 
		//implements MouseListener, then comment in the next two lines
		MouseListener dl = new ClickListener(component);
		component.addMouseListener(dl);

		
		frame.add(component, BorderLayout.CENTER);
		
		
		//TODO: Add ActionListener for the clearButton by
		//implementing an anonymous class that calls the
		//clear method of the ClickComponent. You may need
		//to make a minor change to the ClickComponent declaration above.
		JButton clearButton = new JButton( "Clear Screen" );
		frame.add( clearButton, BorderLayout.SOUTH );
		clearButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				component.clearShapes();
				component.repaint();
			}
		});

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
