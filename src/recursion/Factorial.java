package recursion;

/*
 * Illustrates the recursive definition of the 
 * factorial function
 * 
 * @author William Goble
 * @author Dickinson College
 */
public class Factorial {
	/*
	 * We know that fact(n) = n * (n - 1) * (n - 2) * ... * 1
	 * Which can be written recursively as fact(n) = n * fact(n - 1)
	 * Remember: when writing recursive functions we want to identify 
	 * the base case first, and then combine the base case with the 
	 * results from a similar subproblem. 
	 */
	public static int fact(int n) {
		System.out.println(String.format("Calling factorial(%d)", n));
		// Establishing our base case
		
		if (n <= 1) {
			System.out.println("Returning 1");
			return 1;
		}
		// trusting that the recursive call will solve our subproblem
		int previous = fact(n - 1);
		int result = n * previous;
		String output = String.format("Returning %d * %d = %d", n, previous, result);
		System.out.println(output);
		return result;
	}
	
	public static void main(String[] args) {
		int outcome = fact(5);
		String result = String.format("Result: %d", outcome);
		System.out.println(result);
	}
}