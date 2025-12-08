/**
 * 78. Subsets
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * Example 1: Input: nums = [1,2,3], Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2: Input: nums = [0], Output: [[],[0]]
 * 
 * Algorithm:
 * You take an array, you add the current element, go on adding rest of the elements
 * You remove the element and again go on adding rest of the elements
 * so, for every number, find all combinations with or without it
 * Recursion is used to find all permutations, combinations or when there is a choice between many at every step
 */

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();

        findSubset(nums, 0, set, result);
        return result;
    }

    void findSubset(int[] nums, int i, List<Integer> set, List<List<Integer>> result) {
        if(i == nums.length) {
            result.add(new ArrayList<Integer>(set));
            return;
        }

        set.add(nums[i]);
        findSubset(nums, i+1, set, result);
        set.remove(set.size() - 1);
        findSubset(nums, i+1, set, result);
    }
}
