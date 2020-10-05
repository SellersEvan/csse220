package examples;

/**
 * A triangular shape composed of stacked unit squares like this:
 * 
 * <pre>
 * []
 * [][]
 * [][][]
 * [][][][]
 * </pre>
 * 
 * Based on example from Chapter 13 of Big Java, 3e.
 * 
 * Modified by Buffalo to pass width as a parameter
 * 
 * @author Cay Horstmann.
 */
public class Triangle {
	private int width;

	/**
	 * Constructs a triangular shape with the given width (and height).
	 * 
	 * @param width
	 */
	public Triangle(int width) {
		this.width = width;
	}
	
	/**
	 * returns the area of this triangle.
	 *
	 * @return the area
	 */
	public int getArea() {
		return computeAreaRecursively(this.width);
	}
	
	/**
	 * Computes the area of this triangle recursively.
	 *
	 * @return the area
	 */
	private static int computeAreaRecursively(int inputWidth) {
		return ( inputWidth < 1 ) ? 0 : computeAreaRecursively( inputWidth - 1 ) + inputWidth;
	}


	
}
