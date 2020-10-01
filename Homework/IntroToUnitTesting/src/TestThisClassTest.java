/**
 *  Author: Evan Sellers
 *  Class: CSSE220
 *  
 *  The purpose of this class is to create tests for the TestThisClass
 *  Methods.
 * 
 *  I have taken the liberity to fixing and cleaning up all the
 *  methods in TestThisClass.java, Just for fun.
 */

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;

public class TestThisClassTest {

    @Test
    /** UPPER CASE (TEST)
     *  @see numberOfXs
     *  
     *  Test cases test a variety of values, that are
     *  only Upper Case X's.
     * 
     *  Failure Points
     *  - dsfsfAXaweqeZX
     *  - y
     *  - yY
     *  - ABCDEFGHIJKLMNOPQRSTUVWXYZ
     *  - abcdefghijklmnopqrstuvwxyz
     * 
     *  REASON
     *  The division of the number is causing promblems because of the decimal
     *  getting rounded this is causeing 121/8 = 15 and 89/8=11.12 To fix this 
     *  we can remove the the division and then use the actual assci numbers. Or
     *  we can just do it a much simplier way.
     * 
     *  FIXES
     * 
     *  Simple Fix
     *  {@code
     * 		return input.length() - input.toLowerCase().replace( "x", "" ).length();
     *  }
     * 
     *  Other Fix
     *  {@code
     * 	    int count = 0;
     *      for ( char ch : input.toCharArray() )
     *          if ( ch == 'X' || ch == 'x' ) count++;
     *      return count;
     *  }
     * 
     *  Bug Fix
     *  {@code
     * 	    int count = 0;
     *      for ( char ch : input.toCharArray() )
     *          if ( ch == 88 || ch == 120 ) count++;
     *      return count;
     *  }
     */
    public void numberOfXsAllUpperCaseTest() {

        HashMap<String,Integer> allUpperCase = new HashMap<String,Integer>();
        allUpperCase.put( "aaaaXaaa",           1 );
        allUpperCase.put( "XwerXXuhwXejkjXX",   6 );
        allUpperCase.put( "werXwejrXkvjkXdswe", 3 );
        allUpperCase.put( "aaaXaaaXaaaXaaaX",   4 );
        allUpperCase.put( "jjjjjXjjJJJXjjXjX",  4 );
        allUpperCase.put( "XXXaXXXaXXXaXXX",   12 );
        allUpperCase.put( "XXXXXXXXXXXXXXXX",  16 );
        allUpperCase.put( "abcdefghijklmnpq",   0 );
        allUpperCase.put( "1234567890",         0 );
        allUpperCase.put( "123X123X123X123X",   4 );
        allUpperCase.put( "dsfsfAXaweqeZX",     2 );
        allUpperCase.put( "dsfsfAXaweqeZX",     2 );
        allUpperCase.put( "w", 0 );
        allUpperCase.put( "yY", 0 );
        allUpperCase.put( "ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1 );
        allUpperCase.put( "abcdefghijklmnopqrstuvwxyz", 1 );

        for ( HashMap.Entry<String,Integer> entity : allUpperCase.entrySet() ) {
            assertEquals( TestThisClass.numberOfXs( entity.getKey() ), (int)entity.getValue() );
        }

    }


    @Test
    /** LOWER CASE (TEST)
     *  @see numberOfXs
     *  
     *  Test cases test a variety of values, that are
     *  only lower Case X's.
     * 
     *  Failure Points
     *  - dsfsfAXaweqeZX
     *  - y
     *  - yY
     *  - ABCDEFGHIJKLMNOPQRSTUVWXYZ
     *  - abcdefghijklmnopqrstuvwxyz
     * 
     */
    public void numberOfXsAllLowerCaseTest() {
        HashMap<String,Integer> allUpperCase = new HashMap<String,Integer>();
        allUpperCase.put( "aaaaxaaa",           1 );
        allUpperCase.put( "xwerxxuhwxejkjxx",   6 );
        allUpperCase.put( "werxwejrxkvjkxdswe", 3 );
        allUpperCase.put( "aaaxaaaxaaaxaaax",   4 );
        allUpperCase.put( "jjjjjxjjJJJxjjxjx",  4 );
        allUpperCase.put( "xxxaxxxaxxxaxxx",   12 );
        allUpperCase.put( "xxxxxxxxxxxxxxxx",  16 );
        allUpperCase.put( "abcdefghijklmnpq",   0 );
        allUpperCase.put( "1234567890",         0 );
        allUpperCase.put( "123x123x123x123x",   4 );
        allUpperCase.put( "dsfsfAxaweqeZx",     2 );
        allUpperCase.put( "dsfsfAxaweqeZx",     2 );
        allUpperCase.put( "w", 0 );
        allUpperCase.put( "yY", 0 );
        allUpperCase.put( "ABCDEFGHIJKLMNOPQRSTUVWxYZ", 1 );
        allUpperCase.put( "abcdefghijklmnopqrstuvwxyz", 1 );

        for ( HashMap.Entry<String,Integer> entity : allUpperCase.entrySet() ) {
            assertEquals( TestThisClass.numberOfXs( entity.getKey() ), (int)entity.getValue() );
        }
    }


    @Test
    /** SPECIAL CHAR MIXED CASE (TEST)
     *  @see numberOfXs
     *  
     *  Test cases test a variety of values, that are
     *  only mixed Case X's with special Chars
     * 
     *  Failure Points
     *  - !@#$%^&*()
     *  - xxxxxXXxxxXXxxx^x
     *  - dsfsfAxaweq%eZx
     *  - yY3)
     *  - AB(CDEFGHIJKLM_NOPQRSTUVWxYZ
     *  - dsfs!fAxaweqeZX
     * 
     */
    public void numberOfXsSpecialChars() {
        HashMap<String,Integer> allUpperCase = new HashMap<String,Integer>();
        allUpperCase.put( "aaaa$$#7xaaa",           1 );
        allUpperCase.put( "xwerXXuhwxejkjxx",       6 );
        allUpperCase.put( "we%$rxwejrxkvjkxdswe",   3 );
        allUpperCase.put( "aaaxaaaX!@aaaxaaax",     4 );
        allUpperCase.put( "jjjjjxjjJJJXjjxjx",      4 );
        allUpperCase.put( "xxxaxxxaxxxaxxx",       12 );
        allUpperCase.put( "xxxxxXXxxxXXxxx^x",     16 );
        allUpperCase.put( "abcdefghijklmnpq",       0 );
        allUpperCase.put( "123#4567890",            0 );
        allUpperCase.put( "123@X123x123x123x",      4 );
        allUpperCase.put( "dsfsfAxaweq%eZx",        2 );
        allUpperCase.put( "dsfs!fAxaweqeZX",        2 );
        allUpperCase.put( "@w", 0 );
        allUpperCase.put( "yY3)", 0 );
        allUpperCase.put( "AB(CDEFGHIJKLM_NOPQRSTUVWxYZ", 1 );
        allUpperCase.put( "!@#$%^&*()", 0 );

        for ( HashMap.Entry<String,Integer> entity : allUpperCase.entrySet() ) {
            assertEquals( TestThisClass.numberOfXs( entity.getKey() ), (int)entity.getValue() );
        }
    }


    @Test
    /** COUNT CHOCULA STANDARD MIXED (TEST)
     *  @see countChocula
     * 
     *  This will test a mixed values of the 
     *  countChocula method. We Will Try mixed
     *  chars and different special characters
     * 
     *  Failure Points
     *  - ChoculawerewChocula 
     *  - ChoculaChoculaChocula 
     *  - asdaChoculaChocula 
     *  - asdaChoculaChocula 
     * 
     * 
     *  PROMBLEM
     *  The promblem is your check every 7 cells. So if you place
     *  a letter first it will fail. There are many way to resolve 
     *  this promblem. I have placed the best metho below.
     * 
     *  FIX METHODS
     * 
     *  Best method
     *  {@code
     *      return ( input.length() - input.replace( "Chocula", "" ).length() ) / new String( "Chocula" ).length();
     *  }
     */
    public void countChoculaTest() {
        HashMap<String,Integer> choculaTests = new HashMap<String,Integer>();
        choculaTests.put( "ChoculaChoculaChocula",  3 );
        choculaTests.put( "asdaChoculaChocula",     2 );
        choculaTests.put( "ChoculawerewChocula",    2 );
        choculaTests.put( "asbdewrwerewrewrewr",    0 );
        choculaTests.put( "!@#$%^Chocula",          1 );
        choculaTests.put( "ChoculaChoculaChocu",    2 );
        choculaTests.put( "achoculaChoculachocula", 1 );
        choculaTests.put( "choculachoculachocula",  0 );
        choculaTests.put( "aChoculaasdChocula!@#$", 2 );
        choculaTests.put( "ChoculA",                0 );

        for ( HashMap.Entry<String,Integer> entity : choculaTests.entrySet() ) {
            assertEquals( TestThisClass.countChocula( entity.getKey() ), (int)entity.getValue() );
        }
    }


    /** PAINT COSTS STANDARD MIXED (TEST)
     *  @see paintCost
     * 
     *  This will check many values including negative numbers
     *  to see if the values come back correctly for the paint
     *  cost values. There is a large range of positive numbers
     *  and some smaller ranger of negative and 0 numbers.
     * 
     *  PROMBLEM
     *  This promblem does not appear to have any promblems with it. How ever
     *  could be written a bit better. I would also allow doubles in 
     *  the future.
     * 
     *  FIX METHODS
     *  {@code
     *      if ( ( length | width | dollarsPerSqFoot ) < 0 ) return -1;
     *	    return ( length * width * dollarsPerSqFoot );
     *  }
     *  
     */
    @Test
    public void paintCostTest() {
        assertEquals( TestThisClass.paintCost( -1, -2, 0 ),      -1 );
        assertEquals( TestThisClass.paintCost( -1, -2, 0 ),      -1 );
        assertEquals( TestThisClass.paintCost( 0, -2, 0 ),       -1 );
        assertEquals( TestThisClass.paintCost( 0, -2, 0 ),       -1 );
        assertEquals( TestThisClass.paintCost( 10, 10, 10 ),   1000 );
        assertEquals( TestThisClass.paintCost( 12,  2,  3 ),     72 );
        assertEquals( TestThisClass.paintCost(  1,  1,  9 ),      9 );
        assertEquals( TestThisClass.paintCost(  1,  1,  9 ),      9 );
        assertEquals( TestThisClass.paintCost( 99,  1,  1 ),     99 );
        assertEquals( TestThisClass.paintCost(  3,  3,  3 ),     27 );
        assertEquals( TestThisClass.paintCost( 27, 20,  4 ),   2160 );
        assertEquals( TestThisClass.paintCost( 20, 22,  5 ),   2200 );
    }


    @Test
    /** PIZZA COST CALCULATOR STANDARD (TEST)
     *  @see pizzaCostCalculator
     * 
     *  This will take many mixed pizza types and calculate different costs.
     *  We have check many combination, and based on the intrustion everything
     *  seems to calcaulte properly.
     * 
     *  PROMBLEM
     *  This promblem does not appear to have any promblems with it. How ever
     *  could be written a bit better.
     * 
     *  FIX METHODS
     *  All these need special {ArrayList<String>} defined
     * 
     *  Cleaner Version of Code provided (Okay)
     *  {@code
     * 		int numToppings = toppings.size();
     *      if ( numToppings == 0 ) return 8;
     *      if ( numToppings <  0 ) return 8 + ( 2 * numToppings );
     *      if ( numToppings == special.size() && toppings.containsAll( special ) ) return 12;
     *      return 12 + ( numToppings - 2 );
     *  }
     * 
     *  Faster but less easy to understand (Best)
     *  {@code
     * 	    int numToppings = toppings.size();
     *      if ( numToppings == special.size() && toppings.containsAll( special ) ) return 12;
     *      return 8 + Math.max( 0, ( numToppings - 2 ) ) + Math.min( 4, numToppings * 2 );
     *  }
     * 
     *  Single Line life (Worst)
     *  {@code
     *      return ( toppings.size() == special.size() && toppings.containsAll( special ) ) ? ( 12 ) : ( 8 + Math.max( 0, ( toppings.size() - 2 ) ) + Math.min( 4, toppings.size() * 2 ) );
     *  }
     * 
     */
    public void pizzaCostCalculatorTest() {
        // Deal
        ArrayList<String> pizza1 = new ArrayList<String>();
		pizza1.add( "pepperoni" );
		pizza1.add( "onions" );
        pizza1.add( "sausage" );
        assertEquals( TestThisClass.pizzaCostCalculator( pizza1 ), 12 );
        
        // 3 Topping Not Deal
        ArrayList<String> pizza2 = new ArrayList<String>();
		pizza2.add( "pepperoni" );
		pizza2.add( "onions" );
        pizza2.add( "cheese" );
        assertEquals( TestThisClass.pizzaCostCalculator( pizza2 ), 13 );
        
        // Single Topping
        ArrayList<String> pizza3 = new ArrayList<String>();
        pizza3.add( "pepperoni" );
        assertEquals( TestThisClass.pizzaCostCalculator( pizza2 ), 13 );

        // No Topping
        ArrayList<String> pizza4 = new ArrayList<String>();
        assertEquals( TestThisClass.pizzaCostCalculator( pizza4 ), 8 );

        // 5 Topping
        ArrayList<String> pizza5 = new ArrayList<String>();
        pizza5.add( "pepperoni" );
		pizza5.add( "onions" );
        pizza5.add( "cheese" );
        pizza5.add( "bacon" );
        pizza5.add( "tomato" );
        assertEquals( TestThisClass.pizzaCostCalculator( pizza5 ), 15 );
    }
}
