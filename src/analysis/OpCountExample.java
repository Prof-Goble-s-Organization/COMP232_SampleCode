package analysis;

/*
 * A few examples used for practice in finding the number of operations
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Jan 31, 2024
 */
public class OpCountExample {
    /*
     * Replace the first occurance of x in arr with y
     * 
     * @param arr
     *              the array of values
     * @param x 
     *              the value we want to replace
     * @param y 
     *              the value we want to replace x with
     */
    public static void replaceFirstX(int[] arr, int x, int y) {
        int i = 0;
        boolean done = false;

        while (!done && i < arr.length) {
            if (arr[i] == x) {
                arr[i] = y;
                done = true;
            }
            i++;
        }
    }

    /*
     * 
     * @param arr
     *              a square 2d array of values in the range [0...arr.length]
     * @return the most frequent value in arr
     */
    public static int mostFrequentValue(int[][] arr) {
        int[] counts = new int[arr.length];
        for(int row = 0; row < arr.length; row++) {
            for(int col = 0; col < arr.length; col++) {
                int val = arr[row][col];
                counts[val]++;
            }
        }

        int max = 0;
        for(int val = 0; val < counts.length; val++) {
            if(counts[val] > max) {
                max = counts[val];
            }
        }

        return max;
    }

    /*
     * Compute the sum of all the elements in the lower triangle of an array
     * 
     * @param arr
     *              a square 2d array 
     * @return the lower triangular sum of arr
     */
    public static int lowerTriangularSum(int[][] arr) {
        int total = 0;
        for(int row = 0; row < arr.length; row++) {
            for(int col = 0; col < row; col++) {
                total = total + arr[row][col];
            }
        }

        return total;
    }
}
