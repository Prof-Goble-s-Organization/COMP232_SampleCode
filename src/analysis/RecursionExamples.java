package analysis;

/*
 * An example used for practice in analyzing recursive algorithms 
 * using recurrence relations.
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Jan 31, 2024
 */
public class RecursionExamples {
    /*
     * Compute the factorial of n
     * 
     * @param 
     *          n the value
     * @return the factorial of n => n!
     */

    public static long factorial(long n) {
        if(n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
