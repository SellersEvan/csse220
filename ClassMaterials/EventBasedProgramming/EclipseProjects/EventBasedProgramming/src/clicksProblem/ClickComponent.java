package clicksProblem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class ClickComponent extends JComponent {
	
	private ArrayList<ShapeAbstract> shapes = new ArrayList<>();

	public void addCircle( int x, int y ) {
		shapes.add( new Circle(x, y, 10));
	}

	public void addSquare( int x, int y ) {
		shapes.add( new Square(x, y, 10));
	}

	public void clearShapes() {
		shapes = new ArrayList<>();
	}

	public void paintComponent(Graphics g) {
		for ( ShapeAbstract r : shapes ) r.draw(g);
	}
	
}
