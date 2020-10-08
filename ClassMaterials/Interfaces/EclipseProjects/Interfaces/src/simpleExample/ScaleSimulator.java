package simpleExample;

import java.util.ArrayList;


/**
 * This class allows us to weight balls and cubes of different sizes
 * Unfortunately, there is a lot of duplicated code
 * Can we develop a common interface to make this class a lot shorter?
 * 
 * @author Jason Yoder
 *
 */
public class ScaleSimulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// create a list of balls and compare them
		ArrayList<Weighable> objects = new ArrayList<Weighable>();
		for (int i=1; i<= 3; i++) {
			objects.add( new Ball( i ) );
			objects.add( new Cube( i ) );
			objects.add( new Cylinder( i, i ) );
		}
		System.out.println( "---------------------------------------" );
		reportBallComparison( objects );

	}
	



	private static void reportBallComparison( ArrayList<Weighable> objects ) {
		if ( objects.isEmpty() ) {
			return;
		}
		Weighable heaviest = objects.get( 0 );
		for( Weighable object: objects ) {
			if ( object.getWeightInLbs() > heaviest.getWeightInLbs() ) {
				System.out.println( object + " is heavier than " + heaviest );
				heaviest = object;
			} else if ( object.getWeightInLbs() < heaviest.getWeightInLbs() ) {
				System.out.println( object + " is lighter than " + heaviest );
			} else {
				System.out.println( object + " is the same as " + heaviest );
			}
		}
	}
	
	private static void reportCubeComparison( ArrayList<Weighable> object) {
		if ( object.isEmpty() ) {
			return;
		}
		Weighable heaviest = object.get(0);
		for(Weighable c: object) {
			if (c.getWeightInLbs() > heaviest.getWeightInLbs() ) {
				System.out.println( c + " is heavier than " + heaviest );
				heaviest = c;
			} else if (c.getWeightInLbs() < heaviest.getWeightInLbs()) {
				System.out.println( c + " is lighter than " + heaviest );
			} else {
				System.out.println( c + " is the same as " + heaviest );
			}
		}
	}

	private static void reportCylinderComparison(ArrayList<Cylinder> cylinders) {
		if ( cylinders.isEmpty() ) {
			return;
		}
		Cylinder heaviest = cylinders.get(0);
		for(Cylinder c: cylinders) {
			if (c.getWeightInTons() > heaviest.getWeightInTons() ) {
				System.out.println( c + " is heavier than " + heaviest );
				heaviest = c;
			} else if (c.getWeightInTons() < heaviest.getWeightInTons()) {
				System.out.println( c + " is lighter than " + heaviest );
			} else {
				System.out.println( c + " is the same as " + heaviest );
			}
		}
	}
}
