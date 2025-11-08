/*
 * 643. Maximum Average Subarray I
 * You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 * Input: nums = [1,12,-5,-6,50,3], k = 4, Output: 12.75000, Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * Input: nums = [5], k = 1, Output: 5.00000
 */

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0, sum = 0;
        double avg = 0;

        while(i < k) {
            sum += nums[i++];
        }
        avg = (double) sum / k;

        while(i < nums.length) {
            sum = (sum - nums[i-k] + nums[i]);
            double newAvg = (double) sum/k;
            avg = Math.max(avg, newAvg);
            i++;
        }

        return avg;
    }    
}
