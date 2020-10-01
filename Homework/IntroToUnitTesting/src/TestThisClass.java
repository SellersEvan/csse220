import java.util.ArrayList;

/**\
 * 
 * You should not need to modify or submit this class.
 * 
 * This is code for four methods, THREE of which have errors.
 * You should create a second file called TestThisClassTest.java
 * which provides at least FOUR test cases (assertions) for each method.
 * 
 * The methods with errors should be left with errors, but the
 * code should expose the problem with them.
 * 
 * Each problem is worth 5 points:
 * 
 * 4 x 1pt each test case (4 assertions minimum, must test different categories)
 * 1 points for CODE COMMENTS explaining WHY cases are DIFFERENT and identifying failing conditions
 * 
 * Total possible: 20 points.
 * 
 * 
 * @author Jason Yoder, Aaron Wilkin, and Joe Hollingsworth
 *
 */

public class TestThisClass {

	
	/** NUMBER OF X's (PUBLIC)
	 *  This will check a string and count the times
	 *  that an X both upper case and lower case appears
	 * 
	 * @param input { String } the buffer to scan
	 * @return { int } total times X and x appears
	 */
	public static int numberOfXs(String input) {
		return input.length() - input.toLowerCase().replace( "x", "" ).length();
	}
	

	/** COUNT CHOCULA APPEARENCE (PUBLIC)
	 *  Given an input string, count the number of occurrences of 
	 *  the string "Chocula", case-sensitive.
	 * 
	 * @param input { String } buffer to check
	 * @return { int } times that "Chocula" appeared
	 */
	public static int countChocula(String input) {	
		return ( input.length() - input.replace( "Chocula", "" ).length() ) / new String( "Chocula" ).length();
	}
	
	
	/** PAINT COST CALC (PUBLIC)
	 *	Given a length and width of a floor in feet and the cost of
	 * 	paint in dollar per square foot, calculate the cost to paint the room.
	 * 
	 *  If any non-positive values are used for any parameters the result should be -1.
	 *  The cost in dollars should be rounded up to the nearest whole dollar.
	 * 
	 * @param length { int }, width { int }, dollarsPerSqFoot { int }
	 * @return { int } the total cost
	 */
	public static int paintCost(int length, int width, int dollarsPerSqFoot) {
		if ( ( length | width | dollarsPerSqFoot ) < 0 ) return -1;
		return ( length * width * dollarsPerSqFoot );
	}
	
	
	/** PIZZA COST CALC (PUBLIC)
	 *  Given an ArrayList of String describing Pizza, the cost should be calculated as follows:
	 *  Zero toppings means the pizza costs $8. The first two toppings are $2 each and after that
	 *  each other topping costs $1. There is a special if there are exactly the toppings:
	 *  "pepperoni", "onions" and "sausage" (order does not matter) and then the cost is $12.
	 * 
	 * @param toppings { ArrayList<String> } array list of topping
	 * @return { int } cost 
	 */
	public static int pizzaCostCalculator(ArrayList<String> toppings) {
		ArrayList<String> special = new ArrayList<String>();
		special.add( "pepperoni" );
		special.add( "onions" );
		special.add( "sausage" );
		
		int numToppings = toppings.size();
		if ( numToppings == special.size() && toppings.containsAll( special ) ) return 12;
		return 8 + Math.max( 0, ( numToppings - 2 ) ) + Math.min( 4, numToppings * 2 );
	}
		
	
	
}
