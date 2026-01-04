/**
 * 136. Single Number
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * Using XOR operation to find the unique number.
 * Time Complexity: O(n)
 */

package BitManipulation;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = nums[0];

        for(int i = 1; i < nums.length; i++) res ^= nums[i];

        return res;
    }
}
