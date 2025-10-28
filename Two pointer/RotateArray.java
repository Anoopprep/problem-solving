/*
 * 189. Rotate Array
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * Right rotation - clockwise
 * Left rotation - anti-clockwise
 * DIRECTION - DOWN !IMPORTANT
 * 
 * Right rotation algorithm
 * reverse(nums, 0, nums.length - 1);
 * reverse(nums, 0, k - 1);
 * reverse(nums, k, nums.length - 1);
 * 
 * Left rotation algorithm
 * reverse(nums, 0, nums.length - 1); 
 * reverse(nums, 0, nums.length - k - 1); 
 * reverse(nums, nums.length - k, nums.length - 1);
 */

public class RotateArray {
    public void reverse(int [] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
}
