package clicksProblem;

import javax.swing.Action;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickListener implements MouseListener {

    private ClickComponent component;
	private int x1;
	private int y1;


    public ClickListener( ClickComponent component ) {
        this.component = component;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if( e.getButton() == MouseEvent.BUTTON1 ) component.addCircle( this.x1, this.y1 );
        if( e.getButton() == MouseEvent.BUTTON2 ) component.addCircle( this.x1, this.y1 );
        if( e.getButton() == MouseEvent.BUTTON3 ) component.addSquare( this.x1, this.y1 );
        component.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    
}
