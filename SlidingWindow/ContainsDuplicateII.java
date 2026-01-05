/**
 * 219. Contains Duplicate II
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i = 0, j = 1;

        while(i < nums.length) {
            if(j < nums.length && j - i <= k) {
                if(nums[i] == nums[j]) return true;
                j++;
            } else {
                i++; 
                j = i + 1;
            }
        }

        return false;
    }
}
