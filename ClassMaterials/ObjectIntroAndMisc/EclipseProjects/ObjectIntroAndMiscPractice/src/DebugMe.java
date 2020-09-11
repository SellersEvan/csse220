/**
 * This class provides some buggy methods that you can use to practice with the
 * debugger. 
 */
public class DebugMe {

	/**
	 * Returns the number of permutations possible when choosing
	 * k elements from a set of size n without repetition
	 * 
	 * This formula for this is:
	 * 
	 * n!/(n-k)!
	 */
	public static int kPermutations(int n, int k) {
		long nFact = 1;
		for(int i = 2; i <= n; i++) {
			nFact *= i;
		}

		long nMinusKFact = 1;
		for(int j = 2; j <= (n - k); j++) {
			nMinusKFact *= j;
		}
		
		return (int)(nFact/nMinusKFact);
	}


	/**
	 * 
	 * If the sentence ends with "!", this function should return a string with all letters uppercase.
	 * If the sentence does not end with "!",. the function return the original string. 
	 * 
	 * For example:
	 *  
	 *  "hello!" becomes "HELLO!"
	 *  "hello?" becomes "hello?"
	 *  "I am excited to be here!" becomes "I AM EXCITED TO BE HERE!"
	 *  "boring" becomes "boring"
	 *  
	 */
	public static String uppercaseIfExclaimation(String sentence) {
		if(sentence.charAt( sentence.length() - 1 ) == '!') {
			sentence = sentence.toUpperCase();
		} 
		return sentence;
	}

	/**
	 * 
	 * Returns true if the array is the same elements repeated
	 * twice.
	 * 
	 * For example,
	 * 
	 * {1,2,1,2} returns true
	 * {7,3,7,7,3,7} returns true
	 * {1,2,3,4} returns false
	 * {1,2,2,1} returns false
	 * {1,3,1} returns false
	 *
	 * @param sentence
	 * @return
	 */
	public static boolean isArrayDoubled(int[] input) {
		if ( input.length % 2 == 1 ) return false;

		for( int i = 0; i < input.length / 2; i++ ) {
			if ( input[i] != input[input.length/2 + i] ) return false;
		}

		return true;
	}

	
	public static int praticeCreatingExceptionBreakpoint() {
		int[] foo = {1,2,3};
		return foo[2];
	}

	
}
