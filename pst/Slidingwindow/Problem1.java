/*
 * Differnce Array Technique 
 * Q: update the query in O(1)
 * A: Problem2
 */

package Slidingwindow;


import java.util.Arrays;

public class Problem1 {
    private static int[] arr = { 10, 5, 20, 40 };

    private static void PrintArray() {
        // update the query in O(n)
        System.out.println(Arrays.toString(arr));
    }

    private static void updateArray(int i, int j, int k) {
        for (int start = i;start <= j;start++){
            arr[start] += k;
        }
    }

    public static void main(String[] args) {
        PrintArray();
        updateArray(0, 1, 10);
        PrintArray();
        updateArray(1,3,20);
        updateArray(2, 2,30);
        PrintArray();
    }

}
