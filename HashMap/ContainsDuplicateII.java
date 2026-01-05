import java.util.HashMap;
import java.util.Map;

/**
 * 219. Contains Duplicate II
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * Maintain a map to store the last index of each number encountered.
 * Return true if a duplicate is found when the difference between the current index and the last index is less than or equal to k.
 * Time Complexity: O(n)
 */

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            Integer lastIndex = map.get(nums[i]);
            if(lastIndex != null) {
                if(i - lastIndex <= k) return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }
}
