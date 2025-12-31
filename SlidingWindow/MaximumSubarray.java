/**
 * 53. Maximum Subarray
 * Kadane's Algorithm
 */

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int currSum = 0, maxSum = 0, max = nums[0];

        for(int num: nums) {
            currSum += num;
            if(currSum < 0) currSum = 0;
            if(currSum > maxSum) maxSum = currSum;
            if(num > max) max = num;
        }

        return maxSum > 0 ? maxSum : max;
    }
}
