/*
 * 42. Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1.
 * compute how much water it can trap after raining.
 * Input: height = [4,2,0,3,2,5], Output: 9
 * TC: O(n), SC: O(n)
 * 
 * Algorithm:
 * Compute Max array from both the sides
 * At any given i or bar, the water that can be stored on top of it = Math.min(left_max[i], right_max[i]) - height[i];
 */

public class TrappingRainWater {
    public int trap(int[] height) {
        int res = 0, n = height.length;
        int[] left_max = new int[n];
        left_max[0] = height[0]; 
        int[] right_max = new int[n];
        right_max[n-1] = height[n-1];

        for(int i = 1; i < n; i++) {
            left_max[i] = height[i] > left_max[i-1] ? height[i] : left_max[i-1];
        }

        for(int i = n - 2; i >= 0; i--) {
            right_max[i] = height[i] > right_max[i+1] ? height[i] : right_max[i+1];
        }

        for(int i = 0; i < n; i ++) {
            res += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return res;
    }
}