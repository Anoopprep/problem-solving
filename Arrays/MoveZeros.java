import java.util.*;
/**
 * LeetCode 283. Move Zeroes
 * Difficulty: Easy
 * 
 * Given an integer array nums, move all 0's to the end of it while maintaining 
 * the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 * 
 * Algo: 
 * 1. Find the first 0th element at i
 * 2. Find the first non 0th element at j where j starts at i + 1
 * 3. Now swap the elements
 * 4. i becomes i+1 since the very next element will be zero
 * 5. j again finds a non-zero element
 * 6. Repeat until j goes out of bound
 */

public class MoveZeros {
    public static void moveZeros(int[] arr) {
        int i = 0, j = 0;
        while(i < arr.length && arr[i] != 0) i++;
        j = i+1;
        while(j < arr.length && arr[j] == 0) j++;

        while(j < arr.length) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            while(j < arr.length && arr[j] == 0) j++; // Find next non zero element
        }
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,0};
        int[] arr2 = new int[]{0,1,0,3,12};
        int[] arr3 = new int[]{0};
        int[] arr4 = new int[]{1};

        moveZeros(arr1);
        moveZeros(arr2);
        moveZeros(arr3);
        moveZeros(arr4);
        
        printArray(arr1);
        printArray(arr2);
        printArray(arr3);
        printArray(arr4);
    }
}
