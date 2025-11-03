/*
 * 1877. Minimize Maximum Pair Sum in Array
 * Sort the array.
 * Use two pointers:
 * i = 0 (smallest), j = n-1 (largest)
 * Pair nums[i] and nums[j], compute the sum.
 * Track the maximum sum across all such pairs.
 * Return that maximum.
 */

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, max = 0;

        while(i < j) {
            int newMax = nums[i] + nums[j];
            if(newMax > max) max = newMax;
            i++;
            j--;
        }

        return max;
    }
}
