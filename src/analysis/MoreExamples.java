package analysis;

import java.util.Arrays;

/*
 * A few examples of different run times
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 6, 2024
 */
public class MoreExamples {
    
    // Here we just have a simple assignment statement, so no matter the 
    // size of n, we have a constant run time.
    // O(1 + 1) = O(1)
    public static int constant(int n) {
        int a = n;                  // constant operation
        return a;                   // constant operation
    }

    // Next, let's look at what happens when we start introducing loops
    // we will find the summation of the value n, n times.
    // O(1 + 2n + 2 + 1 + 1) = O(n)
    public static int linear(int n) {
        int sum = 0;                    // here we have a constant operation
        for(int i = 1; i <= n; i++) {   // technically we have 2N + 2 operations, 
                                        // this is simply O(n) operations
            sum += n;                   // another constant operation
        }
        return sum;                     // constant operation
    }

    // O(c + dn + e(n**2)) = O(n**2)

    public static void foo(int[] A, int n) {
        int sum = 0;
        for(int j = 1; j < n; j++) {
            for(int i = 1; i <= j; i++) {
                sum++;
            }
        }

        for(int k = 0; k < n; k++) {
            A[k] = sum + k;
        }
    }

    public static void bar(int n) {
        int sum1 = 0;
        for(int k = 1; k <= n; k *=  2) {
            for (int j = 1; j <= n; j++) {
                sum1++;
            }
        }
        System.out.println(sum1);

        int sum2 = 0;
        for(int k = 1; k <= n; k *= 2) { 
            for(int j = 1; j <= k; k++) { 
                sum2++;
            }
        }
        System.out.println(sum2);
    }

    public static void main(String[] args) {
        int value = linear(3);
        System.out.println(value);

        int A[] = {1, 2, 3};
        System.out.println(Arrays.toString(A));
        foo(A, A.length);
        System.out.println(Arrays.toString(A));
    }
}
