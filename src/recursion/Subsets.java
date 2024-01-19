package recursion;

import java.util.ArrayList;

/**
 * Recursive generation of all subsets of the characters in a string.
 * 
 * @author William Goble
 * @author Dickinson College
 */

public class Subsets {
	/**
	 * Generate all subsets of the characters in the string str.
	 * 
	 * @param str
	 *            a string.
	 * @return a list of all of the subsets of the characters in str.
	 */
	public static ArrayList<String> subsets(String str) {
		return subsets("", str); 							// Line 2
	}
	/**
	 * Recursive Problem Transformation:
	 * 
	 * Generate all subsets of the characters in rest prefixed by the characters
	 * in head.
	 * 
	 * <code> 
	 * For example: 
	 *   subsets("", "ABC") -> "" before {ABC, AB, AC, A, BC, B, C, ""}
	 *                      -> {ABC, AB, AC, A, BC, B, C, ""}
	 *                      
	 *   subsets("A", "BC") -> A before {BC, B, C, ""} 
	 *                      -> {ABC, AB, AC, A} 
	 *                      
	 *   subsets("", "BC")  -> "" before {BC, B, C, ""} 
	 *                      -> {BC, B, C, ""} 
	 *                      
	 *   subsets("AB", "C") -> AB before {C, ""}
	 *                      -> {ABC, AB}
	 * </code>
	 */
	private static ArrayList<String> subsets(String head, String rest) {
		/**
		 * If rest is empty then head is the only subset of rest prefixed by
		 * head.
		 * 
		 * If rest is not empty then the full list of sub-sets can be obtained
		 * by combining all subsets that include the first character of rest and
		 * all subsets that do not contains the first character of rest.
		 * 
		 * <code>
		 * For example:
		 *   subsets("","ABC") -> subsets("A","BC") + subsets("","BC")
		 *                     -> {ABC, AB, AC, A}  + {BC, B, C, ""}
		 * </code>
		 */
		ArrayList<String> subs = new ArrayList<String>();
		if (rest.length() == 0) {
			// rest is empty, then head is the only subset
			subs.add(head);
		} else {
			// add all subsets that have the first character of rest
			ArrayList<String> include = subsets(head + rest.charAt(0), rest.substring(1));	// Line 3
			subs.addAll(include);
			
			// Add all subsets that do not include the first char of rest
			ArrayList<String> exclude = subsets(head, rest.substring(1)); 		// Line 4
			subs.addAll(exclude);
		}
		return subs;
	}
	
	public static void main(String[] args) {
		ArrayList<String> subs = subsets("ABC"); 		// Line 1
		System.out.println("Size: " + subs.size());
		for (int i = 0; i < subs.size(); i++) {
			System.out.println((i + 1) + ":" + subs.get(i));
		}
	}
}