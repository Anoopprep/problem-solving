/**
 * 55. Jump Game
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */

package DP;

import java.util.Arrays;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }

    private boolean helper(int[] nums, int i, int[] dp) {
        if(i == nums.length - 1) return true;

        if(i >= nums.length) return false;

        if(dp[i] == 1) return true;
        if(dp[i] == 0) return false;

        int size = nums[i];
        while(size > 0) {
            boolean res = helper(nums, i + size, dp);
            if(res) {
                dp[i] = 1;
                return true;
            }
            size--;
        }
        dp[i] = 0;
        return false;
    }
}
