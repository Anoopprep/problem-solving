/**
 * Time Complexity: Time taken by one function call * number of function calls
 * Here, time taken by one function call is O(1) and number of function calls are n
 * So, overall time complexity is O(n)
 * 
 * Space Complexity: (Height of the recursion tree / depth of the recursion stack) + (auxiliary space used in each function call)
 * Here, height of the recursion tree is n and auxiliary space used in each function call is O(1)
 * So, overall space complexity is O(n)
 */

package Recursion;

public class IsSorted {
    public static boolean isSorted(int[] arr, int i) {
        if (i == 0 || i == 1) return true;
        return arr[i] > arr[i - 1] && isSorted(arr, i - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(isSorted(arr, arr.length - 1)); // true
    }
}