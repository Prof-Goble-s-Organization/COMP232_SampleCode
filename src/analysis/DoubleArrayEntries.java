package analysis;

/**
 * First example used in introducing and practing analysis of algorithms. 
 * Used to illustrate basic operation counts and the idea that the constants
 * and slower growing terms do not matter as much as problems get larger.
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Jan 31, 2024
 */
public class DoubleArrayEntries {
    
    public static void doubleArrayEntriesLong(int[] arr) {
        int len = arr.length;
        for(int i = 0; i < len; i++) {
            int cur = arr[i];
            int doubleCur = cur * 2;
            arr[i] = doubleCur;
        }
    }

    public static void doubleArrayEntriesShort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * 2;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
