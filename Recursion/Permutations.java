/**
 * 46. Permutations
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * Algorithm: 
 * We use backtracking to generate all permutations. We swap each element with the current index and recursively generate permutations for the next index.
 * Time Complexity: O(N * N!) where N is the length of nums. There are N! permutations and generating each permutation takes O(N) time.
 * Space Complexity: O(N!) for the output list.
 */

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(nums, res, 0);
        return res;
    }

    public void helper(int[] nums, List<List<Integer>> res, int idx) {
        if(idx == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
            return;
        }

        for(int i = idx; i < nums.length; i++) {
            this.swap(nums, idx, i);
            this.helper(nums, res, idx+1);
            this.swap(nums, idx, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
