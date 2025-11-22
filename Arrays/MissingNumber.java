/**
 * 268. Missing Number
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 * Input: nums = [3,0,1], Output: 2
 * Input: nums = [0,1], Output: 2
 * NOTE: Below algorithm of sum of numbers only works when it starts from 0 to some n
 */

public class MissingNumber {
    public int usingSum(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int sumOfNnumbers = (n * (n + 1))/2;
        return sumOfNnumbers - sum;
    }

    public int usingXor(int[] nums) {
        int xor = 0;
        for(int num : nums) {
            xor^=num;
        }

        for(int i = 0; i<=nums.length; i++) {
            xor^=i;
        }

        return xor;
    }
}
