
/**
 * TODO Put here a description of what this class does.
 *
 * @author Evan Sellers
 *         Created Dec 15, 2013.
 */
public class Two2DArrayProblems {
	
	/**
	 * 
	 * Count the number of times 4 occurs in the array.  So
	 * the array
	 * 
	 * 		int[][] intArray2 = 
     *       {{0,0,0},
     *       {4,4,0}};
     *
     *       returns 2
	 * @param data 
	 * @return the number of times 4 occurs in the array.
	 */
	public static int count4s(int[][] data) {
		int count = 0;

		for ( int[] row : data ) {
			for ( int point : row ) {
				if ( point == 4 ) count++;
			}
		}

		return count;
	}
	
	/**
	 * Takes an array of strings, all of which have equal length.
	 * 
	 * Returns a 2D array of characters, where the characters
	 * correspond to the strings.  
	 * 
	 * {"abc",
	 *  "def"} yields {{'a','b','c'},
     *                 {'d','e','f'}};
	 * @param input 
	 * @return a 2D array of characters, where the characters
	 * correspond to the strings. 
	 *  
	 */
	public static char[][] stringsToCharArrays(String[] input) {
		char[][] charMap = new char[ input.length ][ input[ 0 ].length() ];

		for ( int line = 0; line < input.length; line++ ) {
			for ( int ch = 0; ch < input[ line ].length(); ch++ ) {
				charMap[ line ][ ch ] = input[ line ].charAt( ch );
			}
		}

		return charMap;
	}
	
	/**
	 * Takes a square array of integers.
	 * 
	 * Returns true if the array is symmetric.  That is if
	 * the array[i,j] == array[j,i] for all i and j
	 * 
	 * So {{1,0,0},
	 *     {0,1,0},
	 *     {0,0,1}} returns true
     *
     *    {{1,0,3},
	 *     {0,1,0},
	 *     {0,0,1}} returns false because [0,2] != [2,0]
	 * @param input 
	 * @return true if the array is symmetric, false otherwise.
	 */
	public static boolean isSymmetric(int[][] input) {
		for ( int row = 0; row < input.length; row++ ) {
			for ( int col = 0; col < input[ row ].length; col++ ) {
				if ( input[ col ][ row ] != input[ row ][ col ] ) return false;
			}
		}

		return true;
	}
	
	/**
	 * Takes an array of integers representing a map.
	 * 
	 * On the map there is one square representing the person: '@'
	 * At least one and maybe more squares representing an exit: 'X'
	 * And empty squares: '.'
	 * 
	 * The function returns the shortest distance from the person to 
	 * an exit.  Note the person can't move diagonally so it is the
	 * Manhattan distance. 
	 * 
	 * If you're not sure what "Manhattan distance" is, be sure to 
	 * look it up! Having that definition makes things much easier.
	 * 
	 *  For example, in the map:
	 *  @...
	 *  .X.X
	 *  
	 *  The function returns 2 (east, south)
	 *  
	 *  X.XX
	 *  ....
	 *  .@.. returns 3
	 *  
	 * @param input 
	 * @return the shortest Manhattan distance from the person to 
	 * an exit. 
	 */
	public static int distanceToExit(char[][] input) {
		int[] personCord = new int[ 2 ];
		int distance = Integer.MAX_VALUE;

		// Search for Person
		for ( int row = 0; row < input.length; row++ ) {
			for ( int col = 0; col < input[ row ].length; col++ ) {
				if ( input[ row ][ col ] == '@' ){
					personCord[ 0 ] = row;
					personCord[ 1 ] = col;
				}
			}
		}

		// Search for exits
		for ( int row = 0; row < input.length; row++ ) {
			for ( int col = 0; col < input[ row ].length; col++ ) {
				if ( input[ row ][ col ] == 'X' && ( Math.abs( row - personCord[ 0 ] ) + Math.abs( col - personCord[ 1 ] ) ) < distance ){
					distance = ( Math.abs( row - personCord[ 0 ] ) + Math.abs( col - personCord[ 1 ] ) );
				}
			}
		}

		return distance;
	}
}
