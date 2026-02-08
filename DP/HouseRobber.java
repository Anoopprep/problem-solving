/**
 * 198. House Robber
 * You are a professional robber planning to rob houses along a street. Each house has a certain
 * amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent
 * houses have security systems connected and it will automatically contact the police if two adjacent
 * houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount
 * of money you can rob tonight without alerting the police.
 */

package DP;

import java.util.Arrays;

public class HouseRobber {
    int res = 0;
    public int robBrute(int[] nums) {
        helperBrute(nums, 0, 0);
        return res;
    }

    private void helperBrute(int[] nums, int i, int total) {
        if(i >= nums.length) {
            if(total > res) res = total;
            return;
        }

        helperBrute(nums, i+2, total+nums[i]);
        helperBrute(nums, i+1, total);
    }

    public int robMemoiz(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helperMemoiz(nums, 0, dp);
    }

    private int helperMemoiz(int[] nums, int i, int[] dp) {
        if(i == nums.length - 1) {
            return nums[i];
        }

        if(i >= nums.length) {
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        int two = helperMemoiz(nums, i+2, dp);
        int one = helperMemoiz(nums, i+1, dp);
        dp[i] = Math.max(one, two + nums[i]);
        return dp[i];
    }

    public int robDPTabulation(int[] nums) {
        if(nums.length == 0) return 0; 
        if(nums.length == 1) return nums[0];
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }

        return dp[nums.length-1];
    }
}
