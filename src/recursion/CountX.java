package recursion;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Illustrates the use of recursion to count the number of 'x' characters in a
 * string.
 * 
 * @author William Goble
 * @author Dickinson College
 */
public class CountX {
	/**
	 * Count the number of the character 'x' in str.
	 * 
	 * This version of the method is written to emphasize the recursive view of
	 * the problem.
	 * 
	 * @param str
	 *            the string.
	 * @return the number of 'x's in str.
	 */
	public static int countX(String str) {
		if (str.length() == 0) {
			return 0;
		}
		else {
			String subString = str.substring(1);
			if (str.charAt(0) == 'x') {
				return 1 + countX(subString);
			}
			else {
				return countX(subString);
			}
		}
	}
	
    public static void main(String[] args) {
        System.out.println(countX("axbxc"));
    }
    
    @Test
    public void testEmpty() {
    	assertEquals("Incorrect result on empty string", 0, countX(""));
    }
    
    @Test
    public void testNoX() {
    	assertEquals("Incorrect result on string with no X", 0, countX("abc"));
    }
    
    @Test
	public void testSomeX() {
		assertEquals("Incorrect result with some x's.", 3, countX("abxcxxd"));
	}

	@Test
	public void testXStartEnd() {
		assertEquals("Incorrect result with x on beginning and end.", 5,
				countX("xabxcxxdx"));
	}
}