import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * A sample class for practicing implementing UML
 * 
 * @author yoder1
 *
 */
public class Main {

	//TODO add instance variables for class Main
	private ArrayList<A> myAs = new ArrayList<A>();
	
	public Main() {
		
		//TODO create 5 As for Main object
		// names should be "A" "B" "C" "D" "E"

		myAs.add( new A( "A" ) );
		myAs.add( new A( "B" ) );
		myAs.add( new A( "C" ) );
		myAs.add( new A( "D" ) );
		myAs.add( new A( "E" ) );

	}
	

	/**
	 *  Used to create
	 * 
	 * @param args Command line arguments (ignored)
	 */
	public static void main(String[] args) {
		
		Main myExample = new Main();



		myExample.setAllBValuesTo3();



	}
	
	public void setAllBValuesTo3() {
		for ( A a : myAs ) {
			System.out.println( a );
		}	

		for ( A a : myAs ) {
			a.setBvalue( 3 );
		}		

		for ( A a : myAs ) {
			System.out.println( a );
		}	
	}
	
	
	
	
}
