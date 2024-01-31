package analysis;

/**
 * A few examples used for practice in analyzing the average case
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Jan 30, 2024
 */
public class AverageCase {
    // For the average case analysis, assume that c is present in str 
    // 50% of the time. When it is present, c occurs exactly once and 
    // is equally likely to be at any location in str.

    /**
     * Find the index of the first occurence of a character in a string
     * 
     * @param c
     *              the character to serarch for
     * @param str
     *              the string to search through
     * @return      the index that the first character c in string or 
     *              -1 if c does not appear in the string.
     */
    public static int indexOf(char c, String str) {
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == c) {
                return i;
            }
        }

        // Not found
        return -1;
    }

    public static int maxElement(int[] myList) {
        int M = myList[0];
        for(var i = 0; i < myList.length; i++) {
            if(myList[i] >= M) {
                M = myList[i];
            }
        }
        return M;
    }

    public static void main(String[] args) {
        char target = 'a';
        String word = "Hello Class";
        int index = indexOf(target, word);
        String output = String.format("The letter 'a' is at index: %d", index);

        System.out.println(output);

        System.out.println("##########");
        int[] inputs = new int[] {6, 3, 4, 1, 8, 1, 3, 2};
        int maxValue = maxElement(inputs);
        System.out.println(String.format("Max Element is: %d", maxValue));

    }
}
