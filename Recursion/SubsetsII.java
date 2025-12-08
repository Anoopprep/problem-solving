/**
 * 90. Subsets II
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).The solution set must not contain duplicate subsets. Return the solution in any order. 
 * Example 1: Input: nums = [1,2,2], Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2: Input: nums = [0], Output: [[],[0]]
 * 
 * Algorithm:
 * Find all pairs, but add only if res doesn't contain the current set
 * Use set to find signature of array
*/

package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> subset = new ArrayList<Integer>();
        Set<String> set = new HashSet<String>();
        Arrays.sort(nums);

        findSubset(nums, 0, subset, result, set);
        return result;
    }

    void findSubset(int[] nums, int i, List<Integer> subset, List<List<Integer>> result, Set<String> set) {
        if(i == nums.length) {
            String subsetStr = String.join(",", subset.toString());
            if(!set.contains(subsetStr)) {
                result.add(new ArrayList<Integer>(subset));
                set.add(subsetStr);
            }
            return;
        }

        subset.add(nums[i]);
        findSubset(nums, i+1, subset, result, set);
        subset.remove(subset.size() - 1);
        findSubset(nums, i+1, subset, result, set);
    }
}
