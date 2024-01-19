package recursion;

import java.util.ArrayList;

/**
 * Generates a list of all of the permutations of the characters of a given
 * string.
 * 
 * @author William Goble
 * @author Dickinson College
 */
public class Permutations {
	/**
	 * Generate all of the permutations of the characters in the specified
	 * String.
	 * 
	 * @param str
	 *            the string of characters to permute.
	 * @return the permutations of the characters in str.
	 */
	public static ArrayList<String> permute(String str) {
		/*
		 * If str has one character (or none) then str is its only permutation.
		 * 
		 * Otherwise, for each character c in str, get the permutations of str
		 * without c. Then prepend c to each of those permutations. E.g. for ABC
		 * we prepend A onto BC and CB, giving ABC and ACB. We then prepend B
		 * onto AC and CA, giving BAC and BCA. Finally, we prepend C onto AB and
		 * BA, giving CAB and CBA.
		 */
		ArrayList<String> perms = new ArrayList<String>();
		
		if (str.length() <= 1) {
			// str is its own (and only) permutation.
			perms.add(str);
		} else {
			// for each character c in str
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				//get the permutations of str without c
				String strWithoutC = str.substring(0, i) + str.substring(i + 1);
				ArrayList<String> subPerms = permute(strWithoutC);					// Line 1
				// Prepend c to each of the permutations of str without C
				for (String subPerm: subPerms) {
					perms.add(new String(c + subPerm));
				}
			}
		}
		return perms;
	}
	
	public static void main(String[] args) {
		ArrayList<String> perms = permute("ABC");									// Line 2
		for (String str : perms) {
			System.out.println(str);
		}
	}
}